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
					<td>주 장</td>
					<td><%=vo.getTeamleader()%></td>
				</tr>
				<tr>
					<td>순 위</td>
					<td></td>
				</tr>
				<tr>
					<td>승점/전적</td>
					<td></td>
				</tr>
				<tr>
					<td>팀 매너점수</td>
					<td></td>
				</tr>
				<tr>
					<td>연고지</td>
					<td><%=vo.getTeam_field()%></td>
				</tr>
				<tr>
					<td>팀 인원</td>
					<td><%=vo.getTeam_member()%></td>
				</tr>
				<tr>
					<td>팀 유니폼</td>
					<td><%=vo.getTeam_uniform()%></td>
				</tr>
				<tr>
					<td>선호 시간</td>
					<td><%=vo.getTeam_time() %></td>
				</tr>
			</table>
		</div>
		<div class="info">
			<h4>팀 소개</h4>
			<table>
				<%=vo.getTeam_info()%>
			</table>
		</div>
		
		<%if(team_name2==null){%>
					<a href="../TeamJoin?teamname=<%=vo.getTeam_name()%>">가입신청</a>
					<%} 
				else{%>
					<a href="../TeamList">목록으로</a>
				<% }%>
		
	
		 		
	</div>

</body>
</html>