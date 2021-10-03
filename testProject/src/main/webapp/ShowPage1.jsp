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
            <h3 class="select_game">예약현황 페이지지롱</h3> -->

			<!-- 예약현황 -->
			<div class="container">
				<div class="game_box2">
					<div class="box1">



						<%
						out.println("<h1 class=\"coloring\">랭크 순위</h1>");

						out.println("<table class=\"table table-hover\">");
						out.println("<tr class=color>"); // 색상 빨간색:danger(table-hover)
						out.println("<th class=text-center width=15>순위</th>");
						out.println("<th class=text-center width=40>팀명</th>");
						out.println("<th class=text-center width=15>매너점수</th>");
						out.println("<th class=text-center width=15>승점</th>");
						out.println("<th class=text-center width=15>전적</th>");
						out.println("</tr>"); // 출력 MannerDAO dao = new MannerDAO(); ArrayList
						MannerDAO dao2 = new MannerDAO();
						ArrayList<TeamsssVO> list = dao2.MannerListData();
						for (int i = 0; i < 5; i++) {
							if (i < 10) {
								TeamsssVO vo3 = list.get(i); // 회원의 수만큼 반복 
								out.print("<tr>");
								out.print("<td width=15>" + (i + 1) + "</td>");
								out.print("<td><a href='LGW_HYH/TeamDetail.jsp?team_name=" + list.get(i).getTeam_name() + "'>"
								+ list.get(i).getTeam_name() + "</a></td>");
								out.print("<td width=15>" + list.get(i).getMannerscores() + "</td>");
								//매너점수 
								out.print("<td width=15>" + list.get(i).getWinner_point() + "</td>");
								//승점(경기결과에서 가져옴) 
								out.print("<td width=15>" + list.get(i).getResult_3() + "승" + list.get(i).getResult_1() + "패"
								+ list.get(i).getResult_2() + "무</td>"); //전적 
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
                                 
                                 <input type="submit" value="도전">
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
								<h2>예약현황</h2>
							</caption>
							<tbody>
								<tr>
									<td>경기일자</td>
									<td>지역</td>
									<td>경기장</td>
									<td>경기시간</td>
									<td>경기방식</td>
									<td>팀명</td>
									<td>예약</td>

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
								System.out.println("현재 페이지 "+cur_page);
								System.out.println("총페이지 "+al.size());
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
										out.print("<td><input type=\"submit\" name=\"btnsss\" value=\"예약\" class=\"result\""
										+ "onclick='ClickBtn()'></td>");
										//out.print("<td><input type=\"submit\" value=\"예약\" id=btnss onclick=changeBtnName()"
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
								out.println("<a href=?page1=" + prev_page + " class=\"btn btn-sm btn-primary\">이전</a>");
								out.println((prev_page) + " page / " + (next_page) + " pages");
								out.println("<a href=?page1=" + next_page + " class=\"btn btn-sm btn-primary\">다음</a>");
								%>
							
						</table>
						</tbody>

					</div>

				</div>
				<div id='result3'>선택안함</div>
				<form method="get" action="ShowPage1.jsp">
					<div class="columns">
						<figure>
							<!-- 기존 : <img src="img/랭크경기.jpg"> -->
							<button class="btn" value="일반" id="btn" type="submit"
								name="choice" onclick='hidden_change("일반")'>
								<input type="hidden" name="choice" value="선택안함" class="result"
									id="hidden_input"> <img class="btn-img"
									src="YJW_KSJ/resources/99. img/team2.jpg">
							</button>
							<figcaption>일반경기</figcaption>
						</figure>

						<figure>
							<!-- <img src="img/랭크경기.jpg"> -->
							<button class="btn" value="친선" id="btn" type="submit"
								name="choice" onclick='hidden_change("친선")'>
								<input type="hidden" name="choice" value="선택안함" class="result"
									id="hidden_input"> <img class="btn-img"
									src="YJW_KSJ/resources/99. img/team2.jpg">
							</button>
							<figcaption>친선경기</figcaption>
						</figure>

						<figure>
							<!-- <img src="img/랭크경기.jpg"> -->
							<button class="btn" value="랭크" id="btn" type="submit"
								name="choice" onclick='hidden_change("랭크")'>
								<input type="hidden" name="choice" value="선택안함" class="result"
									id="hidden_input"> <img class="btn-img"
									src="YJW_KSJ/resources/99. img/team2.jpg">
							</button>
							<figcaption>랭크경기</figcaption>
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

				btnElement.value = "마감";
			}

			function ClickBtn() {
				var cnt22 = dao.BOOKINGS22(MATCHING_DATE, ADDRESS, FILED_NAME,
						GAMES, TIMES, TEAM_NAME2);
			}
		</script>
</body>
</html>