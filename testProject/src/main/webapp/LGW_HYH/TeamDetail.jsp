<%@page import="testProject.memberDAO"%>
<%@page import="testProject.memberVO"%>
<%@page import="newthang.TeamVO"%>
<%@page import="newthang.TeamDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="TeamDetail.css">
</head>
<body>
	<%

	memberVO vo2 = (memberVO) session.getAttribute("vo");
	String team_name2 = vo2.getTEAM_NAME(); 
	
	String team_name = request.getParameter("team_name");
	TeamDAO dao = new TeamDAO();
	TeamVO vo = dao.TeamDetail(team_name);
	
	%>
< 	<div id="header">
		<div class="team_name">
			<%--<div class="logo"><img src="<%=vo.getTeam_logo() %>"></div>--%>
			<div class="name"><%="*"+vo.getTeam_name()+"*"%>

			</div>
			</h2>
		</div> 
		<div class="table1">
			<table class="table1">
				<tr>
					<td>�� ��</td>
					<td><%=vo.getTeamleader()%></td>
				</tr>
				<tr>
					<td>�� ��</td>
					<td></td>
				</tr>
				<tr>
					<td>����/����</td>
					<td></td>
				</tr>
				<tr>
					<td>�� �ų�����</td>
					<td></td>
				</tr>
				<tr>
					<td>������</td>
					<td><%=vo.getTeam_field()%></td>
				</tr>
				<tr>
					<td>�� �ο�</td>
					<td><%=vo.getTeam_member()%></td>
				</tr>
				<tr>
					<td>�� ������</td>
					<td><%=vo.getTeam_uniform()%></td>
				</tr>
				<tr>
					<td>��ȣ �ð�</td>
					<td><%=vo.getTeam_time() %></td>
				</tr>
			</table>
		</div>
		<div class="info">
			<h4>�� �Ұ�</h4>
			<table>
				<%=vo.getTeam_info()%>
			</table>
		</div>
		
		<%if(team_name2==null){%>
					<a href="../TeamJoin?teamname=<%=vo.getTeam_name()%>">���Խ�û</a>
					<%} 
				else{%>
					<a href="../TeamList">�������</a>
				<% }%>
		
	
		 		
	</div>

</body>
</html>