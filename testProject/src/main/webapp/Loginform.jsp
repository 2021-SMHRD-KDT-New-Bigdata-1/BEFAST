<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="YJW_KSJ/CSS/Loginform.css">

<!-- ���� ��Ʈ  -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Bangers&display=swap" rel="stylesheet">
</head>
<body>
	    <div class="loginBox">
        <h2>BE FAST</h2>
        <div class="log">
        <form action="LoginService" method="post">
            <p>���̵�</p>
            <input type="text" id="MEMBER_ID" name="MEMBER_ID" placeholder="���̵� �Է��ϼ���">
            <p>��й�ȣ</p>
            <input type="password" id="PWD" name="PWD" placeholder="��й�ȣ�� �Է��ϼ���">
            <input type="submit" value="�α���">
            
           	<div class="Join">
            <a href="Joinform.jsp">ȸ������</a>
            </div>
        </form>
        </div>
    </div>
</body>
</html>