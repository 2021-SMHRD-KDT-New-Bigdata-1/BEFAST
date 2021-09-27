<%@page import="testProject.memberVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	
	<!-- Update CSS -->
	<link rel="stylesheet" href="./YJW_KSJ/CSS/Update.css">
	
</head>
<body>
	<div class="Update_box">
		<form action="UpdateService" method="post">
		<li><h5>회원정보수정</h5></li>
		<%
		memberVO vo = (memberVO) session.getAttribute("vo");
		%>
		
		<%-- <li><%=vo.getMEMBER_ID() %></li> --%>
		
		<li>
		<input type="password" name="PWD" placeholder="PW를 입력하세요" style="width: 500px; margin: 0 auto;">
		</li>
		
		<li>
		<input type="text" name="MEMBER_PHONE" placeholder="휴대폰 번호를 입력하세요" autocomplete="off" style="width: 500px; margin: 0 auto;">
		</li>
		
		<li>	
			<li><h5>선호지역</h5></li>
				<select id="input_location" name="P_AREA">
						<option>선호지역을 선택하세요</option>
						<option value="광산구">광산구</option>
						<option value="남구">남구</option>
						<option value="동구">동구</option>
						<option value="북구">북구</option>
						<option value="서구">서구</option>
				</select>
		</li>

		<li>
			<li><h5>선호포지션</h5></li> 
			<select id="input_position" name="POSITION">
				<option>포지션을 선택하세요</option>
				<option value="공격수">공격수</option>
				<option value="수비수">수비수</option>
				<option value="골키퍼">골키퍼</option>
			</select>
			</li>

			<li>
		<input type="submit" value="Update" class="button fit" style="width: 500px; margin: 0 auto;">
		</li>
		
		</form>
	</div>
</body>
</html>