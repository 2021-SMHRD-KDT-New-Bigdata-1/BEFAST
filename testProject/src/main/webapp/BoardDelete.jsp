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

	//�����ͺ��̽� ����
	BoardDAO bdao = new BoardDAO();
	String password = bdao.getPass(write_number);
	%>
	<script>
		//�н����尡 Ʋ���� �ٷ� ���������� ���ư��Բ� script �ڵ� �ۼ�
		var write_pw = prompt("�н����带 �Է����ּ���.");
		//���� �н����尪�� delete form���� �ۼ��� �н����带 ��

		if (write_pw ==<%=password%>) {
			//�н����尡 �Ѵ� ���ٸ�
			location.href = 'BoardDelete1.jsp?write_number=<%=write_number%>';
		} else {
			//�н����尡 Ʋ���� �ٷ� ���������� ���ư��Բ� script �ڵ� �ۼ�
			alert("�н����尡 Ʋ���ϴ�. �н����带 Ȯ�����ּ���.");
			history.go(-1);

		}
	</script>

</body>
</html>