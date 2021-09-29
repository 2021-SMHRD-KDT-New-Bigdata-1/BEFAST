<%@page import="testProject.memberVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
		<%
		memberVO vo = (memberVO) session.getAttribute("vo");
		%>
	<%=vo.getMEMBER_ID() %>
	<%=vo.getMEMBER_NAME() %>
	<%=vo.getGENDER() %>
	<%=vo.getMEMBER_PHONE()%>
	<%=vo.getMEMBER_BIRTHDATE()%>


		
		
		
</body>
</html>