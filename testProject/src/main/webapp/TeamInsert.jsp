<%@page import="newthang.TeamVO"%>
<%@page import="newthang.TeamDAO"%>
<%@page import="testProject.memberVO"%>
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
	
	request.setCharacterEncoding("EUC-KR");
	String team_name = request.getParameter("name");
	String team_field = request.getParameter("area");
	String team_time = request.getParameter("time");
	String team_level = request.getParameter("level");
	String team_uniform = request.getParameter("unifrom");
	String team_info = request.getParameter("intro");
	String team_logo = request.getParameter("img");

	memberVO vo2 = (memberVO)session.getAttribute("vo");
	String teamleader = vo2.getMEMBER_ID();
	
	TeamVO vo = new TeamVO();
	vo.setTeam_name(team_name);
	vo.setTeam_field(team_field);
	vo.setTeam_time(team_time);
	vo.setTeam_level(team_level);
	vo.setTeam_uniform(team_uniform);
	vo.setTeam_info(team_info);
	vo.setTeam_logo(team_logo);
	vo.setTeamleader(teamleader);
	// DAO로 전송 => 오라클 INSERT
	TeamDAO dao = new TeamDAO();
	dao.TeamInsert(vo);
	
	%>
	<script>
		alert("팀 생성되었습니다.");
		location.href = "Main.jsp";
	</script>

</body>
</html>