<%@page import="testProject.memberVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	
	<!-- Update CSS -->
	<link rel="stylesheet" href="./YJW_KSJ/CSS/Update.css">
	
</head>
<body>
	<div class="Update_box">
		<form action="UpdateService" method="post">
		<li><h5>ȸ����������</h5></li>
		<%
		memberVO vo = (memberVO) session.getAttribute("vo");
		%>
		
		<%-- <li><%=vo.getMEMBER_ID() %></li> --%>
		
		<li>
		<input type="password" name="PWD" placeholder="PW�� �Է��ϼ���" style="width: 500px; margin: 0 auto;">
		</li>
		
		<li>
		<input type="text" name="MEMBER_PHONE" placeholder="�޴��� ��ȣ�� �Է��ϼ���" autocomplete="off" style="width: 500px; margin: 0 auto;">
		</li>
		
		<li>	
			<li><h5>��ȣ����</h5></li>
				<select id="input_location" name="P_AREA">
						<option>��ȣ������ �����ϼ���</option>
						<option value="���걸">���걸</option>
						<option value="����">����</option>
						<option value="����">����</option>
						<option value="�ϱ�">�ϱ�</option>
						<option value="����">����</option>
				</select>
		</li>

		<li>
			<li><h5>��ȣ������</h5></li> 
			<select id="input_position" name="POSITION">
				<option>�������� �����ϼ���</option>
				<option value="���ݼ�">���ݼ�</option>
				<option value="�����">�����</option>
				<option value="��Ű��">��Ű��</option>
			</select>
			</li>

			<li>
		<input type="submit" value="Update" class="button fit" style="width: 500px; margin: 0 auto;">
		</li>
		
		</form>
	</div>
</body>
</html>