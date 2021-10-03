<%@page import="testProject.BookingVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="testProject.BookingDAO"%>
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
	
	
	BookingDAO dao = new BookingDAO();
	memberVO vo = (memberVO) session.getAttribute("vo");
	ArrayList<BookingVO> al;
	String MATCHING_DATE = request.getParameter("MATCHING_DATE");
    String ADDRESS = request.getParameter("ADDRESS");
    String FILED_NAME = request.getParameter("FILED_NAME");
    String GAMES = request.getParameter("GAMES");
    String TIMES = request.getParameter("TIMES");
    System.out.println(MATCHING_DATE);
    System.out.println(ADDRESS);
    System.out.println(MATCHING_DATE);
    System.out.println(GAMES);
    System.out.println(TIMES);
    
	HttpSession session2 = request.getSession();
	memberVO vo2 = (memberVO) session.getAttribute("vo");

	// 세션에 있는 (로그인되어있는 아이디를 기준) 값을 들고온다.
	String TEAM_NAME2 = vo.getTEAM_NAME();
	String MEMBER_ID = vo.getMEMBER_ID();

	//BookingDAO dao = new BookingDAO();
	//int cnt1 = dao.BOOKINGS_RESULT2(MATCHING_DATE, ADDRESS, FILED_NAME, GAMES, TIMES, TEAM_NAME2);

	
	%>
	<script>
		alert("팀 매칭이 완료되었습니다.");
		location.href ="ShowPage1.jsp"
	</script>
	
</body>
</html>