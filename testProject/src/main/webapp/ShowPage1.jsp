<%@page import="newthang.MannerDAO"%>
<%@page import="newthang.TeamsssVO"%>
<%@page import="testProject.BookingVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="testProject.memberVO"%>
<%@page import="testProject.BookingDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="YJW_KSJ/CSS/Showpage.css">
</head>
<style>
input[type="text"] {
	/* cursor: pointer; */
	background-color: #eee;
	padding: 5px;
	position: relative;
	text-align: left;
	font-size: 18px;
	height: 50px;
	justify-content: center;
	border: 0.25rem solid rgba(31, 209, 69);
	/* background-color: rgba(31,209,69); */
	border-radius: 5px;
	align-items: center;
	transform: 0.
}
</style>
<body>
	<%
	BookingDAO dao = new BookingDAO();
	memberVO vo = (memberVO) session.getAttribute("vo");
	ArrayList<BookingVO> al;

	%>

	<div class="container">
		<div class="outcontainer">
			<!--    <div class="game_box">
            <h3 class="select_game">������Ȳ ����������</h3> -->

			<!-- ������Ȳ -->
			<div class="container">
				<div class="game_box2">
					<div class="box1">



						<%
						out.println("<h1 class=\"coloring\">��ũ ����</h1>");

						out.println("<table class=\"table table-hover\">");
						out.println("<tr class=color>"); // ���� ������:danger(table-hover)
						out.println("<th class=text-center width=15>����</th>");
						out.println("<th class=text-center width=40>����</th>");
						out.println("<th class=text-center width=15>�ų�����</th>");
						out.println("<th class=text-center width=15>����</th>");
						out.println("<th class=text-center width=15>����</th>");
						out.println("</tr>"); // ��� MannerDAO dao = new MannerDAO(); ArrayList
						MannerDAO dao2 = new MannerDAO();
						ArrayList<TeamsssVO> list = dao2.MannerListData();
						for (int i = 0; i < 5; i++) {
							if (i < 10) {
								TeamsssVO vo3 = list.get(i); // ȸ���� ����ŭ �ݺ� 
								out.print("<tr>");
								out.print("<td width=15>" + (i + 1) + "</td>");
								out.print("<td><a href='LGW_HYH/TeamDetail.jsp?team_name=" + list.get(i).getTeam_name() + "'>"
								+ list.get(i).getTeam_name() + "</a></td>");
								out.print("<td width=15>" + list.get(i).getMannerscores() + "</td>");
								//�ų����� 
								out.print("<td width=15>" + list.get(i).getWinner_point() + "</td>");
								//����(��������� ������) 
								out.print("<td width=15>" + list.get(i).getResult_3() + "��" + list.get(i).getResult_1() + "��"
								+ list.get(i).getResult_2() + "��</td>"); //���� 
								out.print("</tr>");
							}
						}
						out.println("</table><br>");
						%>
					</div>
					<%--                             <form action="MatchService">
                           <table>
                              <tr>
                                 <td><input type="hidden"  name="MATCHING_DATE" value="<%=al.get(i).getMATCHING_DATE()%>"></td>
                                 <td><input type="hidden"  name="FILED_NAME" value="<%=al.get(i).getFILED_NAME()%>"><%=al.get(i).getFILED_NAME()%></td>
                                 <td><input type="hidden"  name="TIMES" value="<%=al.get(i).getTIMES()%>"><%=al.get(i).getTIMES()%></td>
                                 <td><input type="hidden"  name="GAMES" value="<%=al.get(i).getGAMES()%>"><%=al.get(i).getGAMES()%></td>
                                 <td><input type="hidden"  name="TEAM_NAME" value="<%=al.get(i).getTEAM_NAME()%>"><%=al.get(i).getTEAM_NAME()%></td>
                                 
                                 <input type="submit" value="����">
                              </tr>
                           </table>
                           </form> --%>


					<!--                               out.print("<tr>");
                              out.print("<td>" + al.get(i).getMATCHING_DATE() + "</td>");
                              out.print("<td>" + al.get(i).getADDRESS() + "</td>");
                              out.print("<td>" + al.get(i).getFILED_NAME() + "</td>");
                              out.print("<td>" + al.get(i).getTIMES() + "</td>");
                              out.print("<td>" + al.get(i).getGAMES() + "</td>");
                              out.print("<td>" + al.get(i).getTEAM_NAME() + "</td>");
                              out.print("</tr>"); -->




					<div class="wait">
						<table>
							<caption>
								<h2>������Ȳ</h2>
							</caption>
							<tbody>
								<tr>
									<td>�������</td>
									<td>����</td>
									<td>�����</td>
									<td>���ð�</td>
									<td>�����</td>
									<td>����</td>
									<td>����</td>

								</tr>
								<tr>


								</tr>
								<%
								if (request.getParameter("choice") == null) {
									al = dao.select();
								} else {
									String choice = request.getParameter("choice");
									al = dao.bookingsSearch(choice);
								}

								int size = al.size() + 1;
								int total_page = size / 3 + (size % 3 == 0 ? 0 : 1);
								String page1 = request.getParameter("page1");

								if (page1 == null) {
									page1 = "1";
								}
								int cur_page = Integer.parseInt(page1);
								System.out.println("���� ������ "+cur_page);
								System.out.println("�������� "+al.size());
								System.out.println(total_page);
								int prev_page = cur_page - 1;
								int next_page = cur_page + 1;

								if (prev_page <= 0) {
									cur_page = 1;
								} else if (cur_page >= total_page) {
									cur_page = total_page;
								}

								for (int i = 3 * (cur_page - 1); i < cur_page * 3; i++) {
									if (i < al.size()) {
										out.print("<td>" + al.get(i).getMATCHING_DATE() + "</td>");
										out.print("<td>" + al.get(i).getADDRESS() + "</td>");
										out.print("<td>" + al.get(i).getFILED_NAME() + "</td>");
										out.print("<td>" + al.get(i).getTIMES() + "</td>");
										out.print("<td>" + al.get(i).getGAMES() + "</td>");
										out.print("<td>" + al.get(i).getTEAM_NAME() + "</td>");

										out.print("<form action=ShowDetail.jsp>");
										out.print("<td><input type=\"submit\" name=\"btnsss\" value=\"����\" class=\"result\""
										+ "onclick='ClickBtn()'></td>");
										//out.print("<td><input type=\"submit\" value=\"����\" id=btnss onclick=changeBtnName()"
										//     +"></td>");
										out.print("</form>");
										out.print("</tr>");
									} else {
										break;
									}

								}

								if (prev_page <= 0) {
									prev_page = 1;
								} else if (cur_page >= total_page) {
									next_page = total_page;
								}
								out.println("<a href=?page1=" + prev_page + " class=\"btn btn-sm btn-primary\">����</a>");
								out.println((prev_page) + " page / " + (next_page) + " pages");
								out.println("<a href=?page1=" + next_page + " class=\"btn btn-sm btn-primary\">����</a>");
								%>
							
						</table>
						</tbody>

					</div>

				</div>
				<div id='result3'>���þ���</div>
				<form method="get" action="ShowPage1.jsp">
					<div class="columns">
						<figure>
							<!-- ���� : <img src="img/��ũ���.jpg"> -->
							<button class="btn" value="�Ϲ�" id="btn" type="submit"
								name="choice" onclick='hidden_change("�Ϲ�")'>
								<input type="hidden" name="choice" value="���þ���" class="result"
									id="hidden_input"> <img class="btn-img"
									src="YJW_KSJ/resources/99. img/team2.jpg">
							</button>
							<figcaption>�Ϲݰ��</figcaption>
						</figure>

						<figure>
							<!-- <img src="img/��ũ���.jpg"> -->
							<button class="btn" value="ģ��" id="btn" type="submit"
								name="choice" onclick='hidden_change("ģ��")'>
								<input type="hidden" name="choice" value="���þ���" class="result"
									id="hidden_input"> <img class="btn-img"
									src="YJW_KSJ/resources/99. img/team2.jpg">
							</button>
							<figcaption>ģ�����</figcaption>
						</figure>

						<figure>
							<!-- <img src="img/��ũ���.jpg"> -->
							<button class="btn" value="��ũ" id="btn" type="submit"
								name="choice" onclick='hidden_change("��ũ")'>
								<input type="hidden" name="choice" value="���þ���" class="result"
									id="hidden_input"> <img class="btn-img"
									src="YJW_KSJ/resources/99. img/team2.jpg">
							</button>
							<figcaption>��ũ���</figcaption>
						</figure>

					</div>
				</form>
			</div>

		</div>
		<script>
			function hidden_change(val) {
				var hidden = document.getElementById("hidden_input");
				hidden.value = val;
				document.getElementById("result3").innerText = val;
			}

			function changeBtnName() {
				const btnElement = document.getElementById('btnsss');

				btnElement.value = "����";
			}

			function ClickBtn() {
				var cnt22 = dao.BOOKINGS22(MATCHING_DATE, ADDRESS, FILED_NAME,
						GAMES, TIMES, TEAM_NAME2);
			}
		</script>
</body>
</html>