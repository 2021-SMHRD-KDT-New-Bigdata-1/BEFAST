<%@page import="newthang.BoardVO"%>
<%@page import="java.io.PrintWriter"%>
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
	request.setCharacterEncoding("euc-kr");
	int write_number = Integer.parseInt(request.getParameter("write_number"));
	int field_code = Integer.parseInt(request.getParameter("warrior"));
	int field_member = Integer.parseInt(request.getParameter("member"));
	String p_area = request.getParameter("field_code");
	String team_name = request.getParameter("name");
	String write_subject = request.getParameter("subject");
	String write_content = request.getParameter("content");
	String matching_time = request.getParameter("time");
	String write_pw = request.getParameter("pwd");

	BoardVO vo = new BoardVO();
	vo.setField_code(field_code);
	vo.setField_member(field_member);
	vo.setP_area(p_area);
	vo.setTeam_name(team_name);
	vo.setWrite_subject(write_subject);
	vo.setWrite_content(write_content);
	vo.setMatching_time(matching_time);
	vo.setWrite_pw(write_pw);
	vo.setWrite_number(write_number);

	// DAO로 전송 => 오라클 INSERT
	BoardDAO dao = new BoardDAO();
	dao.update(vo);
	%>
	<script>
		alert("수정되었습니다.");
		location.href = "BoardList";
	</script>

</body>
</html>