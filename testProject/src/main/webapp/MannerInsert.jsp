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
	int m_result1 =0;
	int result_1 = 0;
	int result_2 = 0;
	int result_3 = 0;
	//String result = request.getParameter("result");
	if (m_result.equals("패배")) {
		m_result = "10";
		m_result1 = Integer.parseInt(m_result);
		m_result1 = -m_result1;
		result_1 +=1;
	} else if (m_result.equals("승리")) {
		m_result = "10";
		m_result1 = Integer.parseInt(m_result);
		result_2 +=1;
	} else {
		m_result = "0";
		m_result1 = Integer.parseInt(m_result);
		result_3 +=1;
	}
	int result = Integer.parseInt(request.getParameter("rating"));
	int result1 = Integer.parseInt(request.getParameter("rating2"));
	int result2 = Integer.parseInt(request.getParameter("rating3"));
	String comments = request.getParameter("comments");

	MannerVO vo = new MannerVO();
	vo.setM_result(m_result1);
	vo.setTime_result(result);
	vo.setFair_plays(result1);
	vo.setLanguages(result2);
	vo.setComments(comments);
	vo.setTotal_score((result + result1 + result2) / 3);
	vo.setResult_1(result_1);
	vo.setResult_2(result_2);
	vo.setResult_3(result_3);

	MannerDAO dao = new MannerDAO();
	dao.MannerInsert(vo);
	%>
	<script>
		alert("경기 평가 등록이 완료되었습니다.")
		location.href = "Main.jsp"
	</script>

</body>
</html>