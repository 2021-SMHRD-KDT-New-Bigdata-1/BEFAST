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
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<% memberVO vo = (memberVO) session.getAttribute("vo"); %>
	
	
	<%=vo.getGENDER() %>
	<%=vo.getMEMBER_NAME() %>
	<%=vo.getPOSITION() %>
	<%=vo.getP_AREA() %>
	




		
		
		
</body>
</html>