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
		<div class="Card">
		
		<form action="UpdateService" method="post">
		<div class="fo">ȸ����������</div>
		<div class="line"></div>
		<!-- <div class="line"></div> -->
		<%
		memberVO vo = (memberVO) session.getAttribute("vo");
		%>

		
		
			
			<div>
			<span>��й�ȣ ����</span> 
			<!-- ��Ʈ ���� �� �Ǽ� �⺻ ��Ʈ�� �� �� -->
			<input type="password" name="PWD" placeholder="PW�� �Է��ϼ���" style="width: 500px;">
			</div>
		
		
			
			<div><span>�޴��� ��ȣ ����</span>
			<input type="text" name="MEMBER_PHONE" placeholder="�޴��� ��ȣ�� �Է��ϼ���" autocomplete="off" style="width: 500px; margin: 0 auto;">
			</div>
		
		
			
			<div><span>��ȣ����</span>
				<select id="input_location" name="P_AREA">
						<option>��ȣ������ �����ϼ���</option>
						<option value="���걸">���걸</option>
						<option value="����">����</option>
						<option value="����">����</option>
						<option value="�ϱ�">�ϱ�</option>
						<option value="����">����</option>
				</select>
			</div>
		

			<div>
			<span>��ȣ������</span>
			<select id="input_position" name="POSITION">
				<option>�������� �����ϼ���</option>
				<option value="���ݼ�">���ݼ�</option>
				<option value="�����">�����</option>
				<option value="��Ű��">��Ű��</option>
			</select>
			</div>
			
			

		<div class="line"></div>
		
		<div class="sub">
		<button id="pre" onclick="history.back();">��������</button>
		<input type="submit" value="����" class="button fit">
		</div>
		
		</form>
		</div>
	</div>
</body>
</html>