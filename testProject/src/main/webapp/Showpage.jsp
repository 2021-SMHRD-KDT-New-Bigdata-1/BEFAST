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
<body>
	<%
	BookingDAO dao = new BookingDAO();
	memberVO vo = (memberVO) session.getAttribute("vo");
	ArrayList<BookingVO> al = dao.select();
   %>
   
	<div class="container">
		<div class="outcontainer">

		<!-- 	<div class="game_box">
				<h3 class="select_game">예약현황 페이지지롱</h3> -->

				<!-- 예약현황 -->
				<div class="container">
				<div class="game_box2">

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
								</tr>
				
				<%
                        //회원정보 출력(한명의 회원 정보는 하나의 tr 태그에 - 한줄)
                        //회원의 수만큼 tr 태그 추가
                        //각 정보 (이메일,전화번호,주소)는 각 td 태그에
                        for(int i=0; i<al.size();i++){//회원의 수만큼 반복
                           out.print("<tr>");
                           out.print("<td>"+al.get(i).getMATCHING_DATE()+"</td>");
                           out.print("<td>"+al.get(i).getADDRESS()+"</td>");
                           out.print("<td>"+al.get(i).getFILED_NAME()+"</td>");
                           out.print("<td>"+al.get(i).getTIMES()+"</td>");
                           out.print("<td>"+al.get(i).getGAMES()+"</td>");
                           out.print("</tr>");
                        }
					%>
							
						</table>
						</tbody>
						</div>

					</div>

					<form action="#">
						<div class="columns">
							<figure>
								<!-- 기존 : <img src="img/랭크경기.jpg"> -->
								<button class="btn" id="btn" type="submit">
									<img class="btn-img" src="YJW_KSJ/resources/99. img/랭크경기.jpg">
								</button>
								<figcaption>일반경기</figcaption>
							</figure>

							<figure>
								<!-- <img src="img/랭크경기.jpg"> -->
								<button class="btn" id="btn" type="submit">
									<img class="btn-img" src="/99.img/랭크경기.jpg">
								</button>
								<figcaption>친선경기</figcaption>
							</figure>

							<figure>
								<!-- <img src="img/랭크경기.jpg"> -->
								<button class="btn" id="btn" type="submit">
									<img class="btn-img" src="/99.img/랭크경기.jpg">
								</button>
								<figcaption>랭크경기</figcaption>
							</figure>

						</div>
					</form>
				</div>
			
	</div>
	</div>
	
</body>
</html>