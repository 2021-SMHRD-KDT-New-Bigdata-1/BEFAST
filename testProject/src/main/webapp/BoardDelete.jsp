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
	int write_number = Integer.parseInt(request.getParameter("write_number"));

	//데이터베이스 연결
	BoardDAO bdao = new BoardDAO();
	String password = bdao.getPass(write_number);
	%>
	<script>
		//패스워드가 틀리면 바로 전페이지로 돌아가게끔 script 코드 작성
		var write_pw = prompt("패스워드를 입력해주세요.");
		//기존 패스워드값과 delete form에서 작성한 패스워드를 비교

		if (write_pw ==<%=password%>) {
			//패스워드가 둘다 같다면
			location.href = 'BoardDelete1.jsp?write_number=<%=write_number%>';
		} else {
			//패스워드가 틀리면 바로 전페이지로 돌아가게끔 script 코드 작성
			alert("패스워드가 틀립니다. 패스워드를 확인해주세요.");
			history.go(-1);

		}
	</script>

</body>
</html>