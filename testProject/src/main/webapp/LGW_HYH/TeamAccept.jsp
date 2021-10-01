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

	<th>신청번호</th><th>신청자</th><th>전화번호</th><th>보기</th>

</tr>
	<% 

		ArrayList<memberVO> list = TeamJoinDAO.getAccept();

		if(list.size()<=0){		

	%>

		<tr><td colspan="7">가입신청 목록이 없습니다.</td></tr>

	<% 	} else {

		for(memberVO vo : list){%>

			<tr>

			<td><%=vo.getMEMBER_ID() %></td>

			<td><%=vo.getMEMBER_PHONE() %></td>

			
			<td><a href="../Myinfo?member_id(<%=vo.getMEMBER_ID()%>)">상세보기</a></td

			</tr>




	








</body>
</html>