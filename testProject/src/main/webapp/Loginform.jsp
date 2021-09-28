<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="YJW_KSJ/CSS/Loginform.css">
</head>
<body>
	    <div class="loginBox">
        <h2>BE FAST</h2>
        <form action="LoginService" method="post">
            <p>아이디</p>
            <input type="text" id="MEMBER_ID" name="MEMBER_ID" placeholder="아이디를 입력하세요">
            <p>비밀번호</p>
            <input type="password" id="PWD" name="PWD" placeholder="비밀번호를 입력하세요">
            <input type="submit" value="로그인">
            
           	<div class="Join">
            <a href="Joinform.jsp">회원가입</a>
            </div>
        </form>
    </div>
</body>
</html>