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
		<div class="Card">
		
		<form action="UpdateService" method="post">
		<div class="fo">회원정보수정</div>
		<div class="line"></div>
		<!-- <div class="line"></div> -->
		<%
		memberVO vo = (memberVO) session.getAttribute("vo");
		%>

		
		
			
			<div>
			<span>비밀번호 변경</span> 
			<!-- 폰트 적용 안 되서 기본 폰트로 할 것 -->
			<input type="password" name="PWD" placeholder="PW를 입력하세요" style="width: 500px;">
			</div>
		
		
			
			<div><span>휴대폰 번호 변경</span>
			<input type="text" name="MEMBER_PHONE" placeholder="휴대폰 번호를 입력하세요" autocomplete="off" style="width: 500px; margin: 0 auto;">
			</div>
		
		
			
			<div><span>선호지역</span>
				<select id="input_location" name="P_AREA">
						<option>선호지역을 선택하세요</option>
						<option value="광산구">광산구</option>
						<option value="남구">남구</option>
						<option value="동구">동구</option>
						<option value="북구">북구</option>
						<option value="서구">서구</option>
				</select>
			</div>
		

			<div>
			<span>선호포지션</span>
			<select id="input_position" name="POSITION">
				<option>포지션을 선택하세요</option>
				<option value="공격수">공격수</option>
				<option value="수비수">수비수</option>
				<option value="골키퍼">골키퍼</option>
			</select>
			</div>
			
			

		<div class="line"></div>
		
		<div class="sub">
		<button id="pre" onclick="history.back();">메인으로</button>
		<input type="submit" value="저장" class="button fit">
		</div>
		
		</form>
		</div>
	</div>
</body>
</html>