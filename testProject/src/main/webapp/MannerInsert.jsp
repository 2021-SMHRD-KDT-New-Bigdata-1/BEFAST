<%@page import="newthang.MannerDAO"%>
<%@page import="newthang.MannerVO"%>
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
	
	String team_name =request.getParameter("team_name2");
	int result_1 = Integer.parseInt(request.getParameter("rating"));
	int result_2 = Integer.parseInt(request.getParameter("rating2"));
	int result_3 = Integer.parseInt(request.getParameter("rating3"));
	String comments = request.getParameter("comments");
	
	 
	
	//String result = request.getParameter("result");
	
	MannerDAO dao =new MannerDAO();
	MannerVO vo = new MannerVO();
	dao.MANNER_AVG(vo.getTeam_name());
	//dao.MANNER(m_result, result_1, result_2, result_3, team_name );
	
	
	
	int cnt =0;
	cnt = dao.MANNER(result_1, result_2, result_3,team_name);
	if(cnt>0){
		System.out.print(vo.getTime_result());
	}
	%>
	<script>
		alert("경기 평가 등록이 완료되었습니다.")
		location.href = "Main.jsp"
	</script>

</body>
</html>