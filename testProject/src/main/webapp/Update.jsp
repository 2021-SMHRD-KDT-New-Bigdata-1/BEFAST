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
		<li><h5>ȸ����������</h5></li>
		<%
		memberVO vo = (memberVO) session.getAttribute("vo");
		%>
		
		<li><%=vo.getMEMBER_ID() %></li>
		
		<li>
		<input name="pw" type="password" placeholder="PW�� �Է��ϼ���" style="width: 500px; margin: 0 auto;">
		</li>
		
		<li>
		<input name="tel" type="text" placeholder="��ȭ��ȣ�� �Է��ϼ���" style="width: 500px; margin: 0 auto;">
		</li>
		
		<li>
		<input name="address" type="text" placeholder="���ּҸ� �Է��ϼ���" style="width: 500px; margin: 0 auto;">
		</li>
		
		<li>
		<input type="submit" value="Update" class="button fit" style="width: 500px; margin: 0 auto;">
		</li>
		
		</form>
	</div>
</body>
</html>