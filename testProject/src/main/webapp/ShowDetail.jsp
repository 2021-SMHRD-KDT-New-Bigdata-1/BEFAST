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

	// ���ǿ� �ִ� (�α��εǾ��ִ� ���̵� ����) ���� ���´�.
	String TEAM_NAME2 = vo.getTEAM_NAME();
	String MEMBER_ID = vo.getMEMBER_ID();

	//BookingDAO dao = new BookingDAO();
	//int cnt1 = dao.BOOKINGS_RESULT2(MATCHING_DATE, ADDRESS, FILED_NAME, GAMES, TIMES, TEAM_NAME2);

	
	%>
	<script>
		alert("�� ��Ī�� �Ϸ�Ǿ����ϴ�.");
		location.href ="ShowPage1.jsp"
	</script>
	
</body>
</html>