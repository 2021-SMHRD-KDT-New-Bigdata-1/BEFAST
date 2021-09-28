<%@page import="newthang.BoardDAO"%>
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
	String write_number = request.getParameter("write_number");
	BoardDAO bdao = new BoardDAO();
	bdao.deleteBoard(Integer.parseInt(write_number));
	%>
	<script>
		alert("삭제되었습니다.");
		location.href = "BoardList";
	</script>
</body>
</html>