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
	try {
		request.setCharacterEncoding("EUC-KR");
	} catch (Exception ex) {
	}
	String m_result = request.getParameter("m_result");
	//String result = request.getParameter("result");
	String result = request.getParameter("rating");
	String result1 = request.getParameter("rating2");
	String result2 = request.getParameter("rating3");
	String comments = request.getParameter("comments");

	System.out.println("결과 : " + m_result);
	System.out.println("결과1 : " + result);
	System.out.println("결과2 : " + result1);
	System.out.println("결과3 : " + result2);
	System.out.println("결과4 : " + comments);
	
	MannerVO vo = new MannerVO();
	vo.setM_result(m_result);
	vo.setTime_result(result);
	vo.setFair_plays(result1);
	vo.setLanguages(result2);
	vo.setComments(comments);

	MannerDAO dao = new MannerDAO();
	dao.MannerInsert(vo);
	%>
	<script>
		alert("경기 평가 등록이 완료되었습니다.")
		location.href = "Main.jsp"
	</script>

</body>
</html>