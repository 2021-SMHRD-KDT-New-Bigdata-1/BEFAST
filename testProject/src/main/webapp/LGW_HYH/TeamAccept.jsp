<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<tr>

	<th>��û��ȣ</th><th>��û��</th><th>��ȭ��ȣ</th><th>����</th>

</tr>
	<% 

		ArrayList<memberVO> list = TeamJoinDAO.getAccept();

		if(list.size()<=0){		

	%>

		<tr><td colspan="7">���Խ�û ����� �����ϴ�.</td></tr>

	<% 	} else {

		for(memberVO vo : list){%>

			<tr>

			<td><%=vo.getMEMBER_ID() %></td>

			<td><%=vo.getMEMBER_PHONE() %></td>

			
			<td><a href="../Myinfo?member_id(<%=vo.getMEMBER_ID()%>)">�󼼺���</a></td

			</tr>




	








</body>
</html>