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
        session.invalidate(); // 모든세션정보 삭제
        response.sendRedirect("LoginForm.jsp"); // 로그인 화면으로 다시 돌아간다.
    %>

</body>
</html>