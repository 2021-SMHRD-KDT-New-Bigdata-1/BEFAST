<%@page import="newthang.TeamVO"%>
<%@page import="newthang.TeamDAO"%>
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
	String team_level = request.getParameter("level");
	String team_uniform = request.getParameter("unifrom");
	String team_info = request.getParameter("intro");
	String member = request.getParameter("number");
	TeamVO vo = new TeamVO();
	vo.setTeam_name(team_name);
	vo.setTeam_field(team_field);
	vo.setTeam_level(team_level);
	vo.setTeam_uniform(team_uniform);
	vo.setTeam_info(team_info);

	// DAO로 전송 => 오라클 INSERT
	TeamDAO dao = new TeamDAO();
	dao.TeamInsert(vo);

	// 목록으로 이동
	response.sendRedirect("Main.jsp");
	%>
</body>
</html>