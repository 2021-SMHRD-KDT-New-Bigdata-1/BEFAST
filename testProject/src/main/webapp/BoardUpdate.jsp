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
	// HTML�� �������� ���� ����
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
	out.println("<h3 class=h3>�뺴 ���� �۾���</h3>");
	out.println("<div class=row>");

	out.println("<form method=post action=BoardUpdate1.jsp?write_number="+write_number+">");
	out.println("<div class=select_1>");
	out.println("<select name=warrior class=select1 >\r\n" + "<option value=1>��ũ��</option>\r\n"
			+ "                <option value=2>�Ϲ���</option>\r\n" + "                <option value=3>ģ����</option></select>");
	out.println("<select class=select1 name=member>\r\n" + "<option value=1>1��</option>\r\n"
			+ "                <option value=2>2��</option>\r\n" + "<option value=3>3��</option></select>\r\n");
	out.println("<select class=select1 name=field_code>\r\n"
			+ "          		                <option value=���걸>���걸</option>\r\n"
			+ "          		                <option value=�ϱ�>�ϱ�</option>\r\n"
			+ "          		                <option value=����>����</option>\r\n"
			+ "          		                <option value=����>����</option>\r\n"
			+ "          		                <option value=����>����</option>\r\n"
			+ "          		            </select><br>");
	out.println("</div>");

	// post ���� / get �ٺ�����

	out.println("<input type=\"text\" class=\"title\" name=\"name\" placeholder=\"���̸��� �Է����ּ���.\"><br>");
	out.println("<input type=\"text\" class=\"title\" name=\"subject\" placeholder=\"������ �Է����ּ���.\"><br>");

	out.println("<textarea cols=50 rows=10 name=\"content\" class=\"text_area\" placeholder=\"������ �Է����ּ���.\"></textarea>");

	out.println("<input type=text class=matching_time name=time placeholder='���ð��� �Է��ϼ���'><br>");

	out.println("<input type=password class=pw name=pwd placeholder=��й�ȣ�Է�><br>");

	out.println("<div class=button text-align=center>");
	out.println("<input type=submit class=\"btn btn-sm btn-danger\" value=�۾���>");
	out.println("<input type=button class=\"btn btn-sm btn-info\" value=��� onclick=\"javascript:history.back()\">");
	out.println("</div>");

	out.println("</form>");
	out.println("</div>");
	out.println("</div>");
	out.println("</body>");
	out.println("</html>");
	%>




</body>
</html>