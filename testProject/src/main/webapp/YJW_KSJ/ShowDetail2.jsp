<%@page import="testProject.BookingDAO2"%>
<%@page import="testProject.BookingVO"%>
<%@page import="java.util.ArrayList"%>
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
	String MATCHING_DATE = request.getParameter("MATCHING_DATE");	
	String ADDRESS = request.getParameter("ADDRESS");
	String FILED_NAME = request.getParameter("FILED_NAME");
	String TIMES = request.getParameter("TIMES");
	String GAMES = request.getParameter("GAMES");
	String TEAM_NAME = request.getParameter("TEAM_NAME");
	
	System.out.println("지역 :" + MATCHING_DATE);
	
	memberVO vo = (memberVO) session.getAttribute("vo");
	String TEAM_NAME3 = vo.getTEAM_NAME();
	String MEMBER_ID = vo.getMEMBER_ID();
    
	BookingVO vo2 = new BookingVO();
	BookingDAO2 dao = new BookingDAO2();
	vo2.setMATCHING_DATE(MATCHING_DATE);
	vo2.setADDRESS(ADDRESS);
	vo2.setFILED_NAME(FILED_NAME);
	vo2.setTIMES(TIMES);
	vo2.setGAMES(GAMES);
	vo2.setTEAM_NAME(TEAM_NAME3);
	vo2.setMEMBER_ID(MEMBER_ID);
	vo2.setTEAM_NAME2(TEAM_NAME);	

	
	
	dao.BOOKINGS(vo2);
	int cnt2 = dao.BOOKINGS_RESULT2(MATCHING_DATE, FILED_NAME, GAMES, TIMES, TEAM_NAME3, TEAM_NAME);
  			
	// 세션에 있는 (로그인되어있는 아이디를 기준) 값을 들고온다.
	

	// BookingDAO dao = new BookingDAO();
	// int cnt1 = dao.BOOKINGS_RESULT2(MATCHING_DATE, ADDRESS, FILED_NAME, GAMES, TIMES, TEAM_NAME2);

	
	%>
	<script>
		alert("팀 매칭이 완료되었습니다.");
		location.href ="ShowPage2.jsp"
	</script>
	
</body>
</html>