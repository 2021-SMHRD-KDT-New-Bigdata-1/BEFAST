<%@page import="newthang.MannerVO"%>
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

<!-- 폰트어썸 -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css"/>

<link rel="stylesheet" href="CSS/Showpage.css">
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
	transform: 0;
	border:none;
	background: transparent;
	color :white;
	text-align: center;
	
}
</style>
<body>
	<%
	BookingDAO dao = new BookingDAO();
	memberVO vo = (memberVO) session.getAttribute("vo");
	ArrayList<BookingVO> al;

	%>
<div class="back">
	<div class="outcontainer">
		<div class="outcontainer2">
			<div class="container">
				<!-- 예약현황 -->
					<!-- <div class="container"> -->
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
						ArrayList<MannerVO> list = dao2.MannerListData();
						for (int i = 0; i < 5; i++) {
							if (i < 10) {
								MannerVO vo3 = list.get(i); // 회원의 수만큼 반복 
								out.print("<tr>");
								out.print("<td width=15>" + (i + 1) + "</td>");
								out.print("<td><a href='../LGW_HYH/TeamDetail.jsp?team_name=" + list.get(i).getTeam_name() + "'>"
								+ list.get(i).getTeam_name() + "</a></td>");
								out.print("<td width=15>" + list.get(i).getM_result() + "</td>");
								//매너점수 
								out.print("<td width=15>" + list.get(i).getTotal_score() + "</td>");
								//승점(경기결과에서 가져옴) 
								out.print("<td width=15>" + list.get(i).getResult_1() + "승" + list.get(i).getResult_3() + "패"
								+ list.get(i).getResult_2() + "무</td>"); //전적 
								out.print("</tr>");
							}
						} 
						out.println("</table>");
						%>
						
						
					</div>

               <div class="wait">
                  <table class="wait2">
                  
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
                        int prev_page = cur_page - 1;
                        int next_page = cur_page + 1;

                        if (prev_page <= 0) {
                           cur_page = 1;
                        } else if (cur_page >= total_page) {
                           cur_page = total_page;
                        }
                        
                        for (int i = 3 * (cur_page - 1); i < cur_page * 3; i++) {
                           if (i < al.size()) {
                              out.print("<form action=ShowDetail2.jsp>");      %>
                              <td> <input type="text" name="MATCHING_DATE"
                                 value="<%=al.get(i).getMATCHING_DATE()%>" readonly/></td>
                              <td> <input type="text" name="ADDRESS"
                                 value="<%=al.get(i).getADDRESS()%>" readonly/></td>
                              <td> <input type="text" name="FILED_NAME"
                                 value="<%=al.get(i).getFILED_NAME()%>" readonly/></td>
                              <td> <input type="text" name="TIMES"
                                 value="<%=al.get(i).getTIMES()%>" readonly/></td>
                              <td> <input type="text" name="GAMES"
                                 value="<%=al.get(i).getGAMES()%>" readonly/></td>
                              <td> <input type="text" name="TEAM_NAME"
                                 value="<%=al.get(i).getTEAM_NAME()%>" readonly/></td>
                              <%
                              
                              if(al.get(i).getTEAM_NAME2()==null){
                                  
                                  out.print("<td><input type=\"submit\" name=\"btnsss\" value=\"예약\" class=\"result\""
                                  + "onclick='ClickBtn()'></td>");
                                  }else{
                                     out.print("<td><input type=\"text\" name=\"btnsss\" value=\"예약이 마감되었습니다.\" readonly/ class=\"result\""
                                           + "onclick='ClickBtn()'></td>");   
                                     
                                  }
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
                        out.println("<p class=\"white1\">"+(prev_page) + " page / " + (next_page) + " pages</p>");
                        out.println("<a href=?page1=" + next_page + " class=\"btn btn-sm btn-primary\">다음</a>");
                       
                        %>
                     
                 	 </tbody>
                  </table>
				</div>
			</div>
			
				<div id='result3'>경기방식을 선택하세요</div>
				<form method="get" action="ShowPage2.jsp">
					
					<div class="columns">
					
						<figure>
							<!-- 친선경기 -->
							<button class="btn" value="일반" id="btn" type="submit" name="choice" onclick='hidden_change("일반")'>
							<i class="fas fa-flag-checkered"></i>
							<input type="hidden" name="choice" value="선택안함" class="result" id="hidden_input"> 
							
							<!-- <img class="btn-img" src="resources/99. img/team2.jpg"> -->
							</button>
							<figcaption>일반경기</figcaption>
						</figure>

						<figure>
							<!-- 친선경기 -->
							<button class="btn" value="친선" id="btn" type="submit" name="choice" onclick='hidden_change("친선")'>
							<input type="hidden" name="choice" value="선택안함" class="result" id="hidden_input"> 
							<i class="far fa-handshake"></i>
							
							<!-- <img class="btn-img"src="resources/99. img/team2.jpg"> -->
							</button>
							<figcaption>친선경기</figcaption>
						</figure>

						<figure>
							<!-- 랭크경기  -->
							<button class="btn" value="랭크" id="btn" type="submit" name="choice" onclick='hidden_change("랭크")'>
							<input type="hidden" name="choice" value="선택안함" class="result" id="hidden_input"> 
							<i class="fas fa-trophy"></i>
							<!-- <img class="btn-img" src="resources/99. img/team2.jpg"> -->
							</button>
							<figcaption>랭크경기</figcaption>
						</figure>

					</div>
				</form>
				
			</div>
		</div>
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