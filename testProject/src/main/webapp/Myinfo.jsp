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
	width: 250px;
	padding: 30px 20px;
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
	font-size: 20px;
	font-weight: 600;
	margin-top: 20px;
	margin-bottom: 20px;
	color: #1FD145;
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

.Card .My_info2 .title {
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
}

.PreNext {
	margin: 5px auto;
	position: relative;
	top: 15px;
}

.PreNext a{
	text-decoration: none;
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
	left: -50px;
}

button#next {
	position: relative;
	right: -50px;
}


</style>
<body>
	<% memberVO vo = (memberVO) session.getAttribute("vo"); %>
	
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
					<p class="title">경기정보</p>
					<div class="line"></div>
				<div class="barOuter">
				
					<div class="barLevel barHTML">선호지역
					<p class="My_type"><i class="fas fa-search-location"></i><%=vo.getP_AREA()%></p>
					</div>
					
					<div class="barLevel barHTML">선호 포지션
					<p class="My_type"><i class="fas fa-futbol"></i><%=vo.getPOSITION()%></p>
					</div>
					
					<div class="barLevel barHTML">소속 팀
					<p class="My_type"><i class="fas fa-users"></i><%=vo.getTEAM_NAME()%></p>
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
		
	</body>
</html>