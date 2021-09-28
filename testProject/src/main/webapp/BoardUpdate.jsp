<%@page import="newthang.BoardVO"%>
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
	int write_number = Integer.parseInt(request.getParameter("write_number"));
	// HTML을 브라우저로 전송 시작
	out.println("<html>");
	out.println("<head>");
	out.println("<Link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
	out.println("<Link rel=\"stylesheet\" href=\"resources/css/football_insert.css\">");
	out.println("<style type=text/css>");
	out.println(".row {margin:0px auto; width:500px}");
	out.println("h2 {text-align:center}");
	out.println("</style>");
	out.println("</head>");
	out.println("<body>");
	out.println("<div class=newthang>");
	out.println("<h2 class=h2>BE FAST</h2>");
	out.println("</div>");
	out.println("<div class=container>");
	out.println("<h3 class=h3>용병 모집 글쓰기</h3>");
	out.println("<div class=row>");

	out.println("<form method=post action=BoardUpdate1.jsp?write_number="+write_number+">");
	out.println("<div class=select_1>");
	out.println("<select name=warrior class=select1 >\r\n" + "<option value=1>랭크전</option>\r\n"
			+ "                <option value=2>일반전</option>\r\n" + "                <option value=3>친선전</option></select>");
	out.println("<select class=select1 name=member>\r\n" + "<option value=1>1명</option>\r\n"
			+ "                <option value=2>2명</option>\r\n" + "<option value=3>3명</option></select>\r\n");
	out.println("<select class=select1 name=field_code>\r\n"
			+ "          		                <option value=광산구>광산구</option>\r\n"
			+ "          		                <option value=북구>북구</option>\r\n"
			+ "          		                <option value=서구>서구</option>\r\n"
			+ "          		                <option value=동구>동구</option>\r\n"
			+ "          		                <option value=남구>남구</option>\r\n"
			+ "          		            </select><br>");
	out.println("</div>");

	// post 보안 / get 다보여짐

	out.println("<input type=\"text\" class=\"title\" name=\"name\" placeholder=\"팀이를을 입력해주세요.\"><br>");
	out.println("<input type=\"text\" class=\"title\" name=\"subject\" placeholder=\"제목을 입력해주세요.\"><br>");

	out.println("<textarea cols=50 rows=10 name=\"content\" class=\"text_area\" placeholder=\"내용을 입력해주세요.\"></textarea>");

	out.println("<input type=text class=matching_time name=time placeholder='경기시간을 입력하세요'><br>");

	out.println("<input type=password class=pw name=pwd placeholder=비밀번호입력><br>");

	out.println("<div class=button text-align=center>");
	out.println("<input type=submit class=\"btn btn-sm btn-danger\" value=글쓰기>");
	out.println("<input type=button class=\"btn btn-sm btn-info\" value=취소 onclick=\"javascript:history.back()\">");
	out.println("</div>");

	out.println("</form>");
	out.println("</div>");
	out.println("</div>");
	out.println("</body>");
	out.println("</html>");
	%>




</body>
</html>