<%@page import="testProject.BookingDAO"%>
<%@page import="testProject.BookingVO"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="testProject.memberVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="LGW_HYH/resources/css/result.css">
<link rel="stylesheet" href="YJW_KSJ/CSS/Manner.css">

<title>내 정보</title>
<!-- font-awesome  -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css"/>
<meta charset="EUC-KR">
</head>
<style>
* {
	margin: 0 auto;
	padding: 0;
}

body {
	background-color: #090934;
}

.Card {
	background-color: #3d405b;
	color: #f4f1de;
/* 	width: 250px; *//*  */
	padding: 30px 15px;
	height: auto;
	box-shadow: 0 0 15px #000;
	border-radius: 15px;
	position: absolute;
	left: 50%;
	top: 50%;
	transform: translate(-50%,-50%);
	display: flex;
	flex-direction: column;
	align-items: center;
	overflow: hidden;
}

.Card .Pic img{
	border-radius: 50%;
	width: 120px;
}

.Card .MEMBER_ID {
	font-size: 25px;
	font-weight: 600;
	margin-top: 20px;
	margin-bottom: 20px;
	color: #eee;
}

.Card .My_info1 {
	margin-bottom: 20px;
}



.Card .My_info1 ul li {
	display: inline-block;
	padding: 0 10px;
	text-align: center;
	color: #f4f1de;
	font-size: 20px;
}

.Card .My_info1 ul li span{
	color: #eee;
	font-size: 15px;
	
}

.Card .My_info2 {
	width: 100%;
}
p{ text-align: center;}

.Card .My_info2 .title, .Matching_info {
	color: #eee;
	margin-bottom: 8px;
	font-weight: 500;
	text-align: center;
	font-size: 20px;
}

.line {
	border-bottom: 2px solid yellow;
	margin: 8px auto;
}

.Card .barOuter {
	margin-top: 12px;
	display: flex;
	line-height: 1.5;
	justify-content: center;
	text-align: center;
}

.Card .barOuter .My_type {
	text-transform: lowercase;
	font-size: 15px;
	margin-bottom: 5px;
}

.Card .barOuter .barLevel {
	height: auto;
	line-height: 1.7;
	padding: 8px;
}

.Card .barOuter2 .barLevel {
	line-height: 1.4;
    margin-bottom: 15px;
    display: flex;
    justify-content: center;
    text-align: center;
    align-items: center;
}

.PreNext {
	margin: 5px auto;
	position: relative;
	top: 15px;
}

.PreNext{
	text-decoration: none;
	/* margin-left: 4px; */
}

button {
	border: none;
	border-radius: 5px;
	height: 30px;
	margin: 3px auto;
	padding: 5px;
}

button:hover {
	cursor: pointer;
}

button#pre {
	position: relative;
	/* left: -50px; */
}

button#next {
	position: relative;
	/* right: -141px; */
}

.barOuter2 {
	text-align: center;
	padding: 6px;
	margin-left: 16px;

}

</style>
<body>
	<% memberVO vo = (memberVO) session.getAttribute("vo");
	
	   BookingDAO dao = new BookingDAO();
	   /* BookingVO Bvo = (BookingVO) session.getAttribute("Bvo"); */
	   /* BookingVO Bvo2 = (BookingVO) session.getAttribute("Bvo2"); */
	   BookingVO Bvo = dao.My_booking(vo.getMEMBER_ID());

       /* BookingVO Bvo = (BookingVO) session.getAttribute("Bvo"); */
	%>
	
		<div class="Card">
			<div class="Pic">
				<img src="YJW_KSJ/resources/99. img/game2.jpg">
			</div>
			
				<p class="MEMBER_ID"><%=vo.getMEMBER_ID() %></p>
				
				
			<div class="My_info1">
				<ul>
					<li>이름<bR>  <span><%=vo.getMEMBER_NAME()%></span> </li>
					<li>성별<bR>  <span><%=vo.getGENDER()%></span> </li>
					<li>휴대전화<bR>  	 <span><%=vo.getMEMBER_PHONE()%></span> </li>
<%-- 				<li><%=vo.getP_AREA()%>   <bR>  <span></span> </li>
					<li><%=vo.getTEAM_NAME()%><bR>  <span></span> </li>
					<li><%=vo.getPOSITION()%><bR>  <span></span> </li>	 --%>			
				</ul>
			</div>
			
			<div class="My_info2">
					<div class="line"></div>
					<p class="title">경기정보</p>
					
				<div class="barOuter">
				
					<div class="barLevel barHTML">선호지역 <i class="fas fa-search-location"></i>
					<p class="My_type"><%=vo.getP_AREA()%></p>
					</div>
					
					<div class="barLevel barHTML">포지션 <i class="fas fa-futbol"></i>
					<p class="My_type"><%=vo.getPOSITION()%></p>
					</div>
					
					<div class="barLevel barHTML">소속 팀 <i class="fas fa-users"></i>
					<p class="My_type"><%=vo.getTEAM_NAME()%></p>
					</div>
				</div>
				
			
					<div class="line"></div>
					<p class="haha">내 매칭현황</p><!-- <p class="Matching_info">내 매칭현황</p> -->
				
				<div class="barOuter2">
				
					<%if(Bvo!=null){ %>
					<div class="barLevel barHTML">경기일자
					<p class="My_type"><i class="far fa-calendar-alt"></i><%=Bvo.getMATCHING_DATE()%></p> 
					</div>
					
 					<div class="barLevel barHTML">경기지역
					<p class="My_type"><i class="far fa-calendar-alt"></i><%=Bvo.getADDRESS()%></p>
					</div>
					
					<div class="barLevel barHTML">경기장
					<p class="My_type"><i class="far fa-calendar-alt"></i><%=Bvo.getFILED_NAME()%></p>
					</div>
					
					<div class="barLevel barHTML">게임방식
					<p class="My_type"><i class="far fa-calendar-alt"></i><%=Bvo.getGAMES()%></p>
					</div>
					
					<div class="barLevel barHTML">경기시간
					<p class="My_type"><i class="far fa-calendar-alt"></i><%=Bvo.getTIMES()%></p>
					</div>
					
					</div>
					
					<% }else{%>
					예약이 없습니다
					<% }%>
					
					<div class="line"></div>
					
		<div class="partner">
			<h2>경기 결과</h2>
				<div class="partner_info">
					<p>클릭해주세요.</p>
				</div>
		</div>
		
		<div class="clear"></div>
			<div id="modal">
				<div class="body">
					<p class="p">경기결과를 클릭해주세요</p>
					<br>
					
				<div class="modal_img">
					<input type="button" name="m_result" value="승리" class="win"
						onclick='hidden_change("승리")'> <input type="hidden"
						name="m_result" value="선택안함" class="result" id="hidden_input">
						
					<input type="button" name="m_result" value="패배" class="lose"
						onclick='hidden_change("패배")'> <input type="hidden"
						name="m_result" value="선택안함" class="result" id="hidden_input">
						
					<input type="button" name="m_result" value="무승부" class="mu"
						onclick='hidden_change("무승부")'> <input type="hidden"
						name="m_result" value="선택안함" class="result" id="hidden_input">
						
				</div>
					<br>
					<div id='result3'>선택안함</div>
						<div class="button">
							<button type="button" id="btn-close">닫기</button>
						</div>
				</div>
			</div>
		</div>
			
				<div class="PreNext">
			
				<!-- 뒤로가기  -->
				<button id="pre" onclick="history.back();">이전으로</button>
				
				<!-- 현재 페이지에서 다른 페이지 이동  -->
				<button id="next" onclick="location.href='Update.jsp'">정보변경</button>
				
				<!-- <a href="#" onclick="history.back()">이전으로</a>
				<a href="#" onclick="location.href='Update.jsp'">내 정보변경</a> -->
				
				</div>
			
		</div>
		
	<script src="./YJW_KSJ/JS/jquery-3.6.0.min.js"></script>
	
	<script>
		$(".partner p").click(function() {
			$("#modal").addClass("active");
		});
		
		$("#modal button").click(function() {
			$("#modal").removeClass("active");
		});
		
		function hidden_change(val) {
			var hidden = document.getElementById("hidden_input");
			hidden.value = val;
			document.getElementById('result3').innerText = val;
		}
		
	</script>
		
	</body>
</html>