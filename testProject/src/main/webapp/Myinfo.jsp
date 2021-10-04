<%@page import="testProject.BookingDAO"%>
<%@page import="testProject.BookingVO"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="testProject.memberVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="LGW_HYH/resources/css/result.css">
<link rel="stylesheet" href="YJW_KSJ/CSS/Manner.css">
<title>�� ����</title>
<!-- font-awesome  -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css"/>
<meta charset="EUC-KR">
</head>
<style>
/* Ƽ���̳���ü */
@font-face {
    font-family: 'twayfly';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_tway@1.0/twayfly.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}


* {
	font-family: 'twayfly';
	margin: 0 auto;
	padding: 0;
}

body {
	background-color: #090934;
}

.Card {
	background-color: #3d405b;
	color: #f4f1de;
/* 	width: 250px; *//*  */
	padding: 30px 15px;
	height: auto;
	box-shadow: 0 0 15px #000;
	border-radius: 15px;
	position: absolute;
	left: 50%;
	top: 50%;
	transform: translate(-50%,-50%);
	display: flex;
	flex-direction: column;
	align-items: center;
	overflow: hidden;
}

.Card .Pic img{
	border-radius: 50%;
	width: 120px;
}

.Card .MEMBER_ID {
	font-size: 25px;
	font-weight: 600;
	margin-top: 20px;
	margin-bottom: 20px;
	color: #eee;
}

.Card .My_info1 {
	margin-bottom: 20px;
	color: #eee;
}



.Card .My_info1 ul li {
	display: inline-block;
	padding: 0 10px;
	text-align: center;
	color: #eee;
	font-size: 20px;
}

.Card .My_info1 ul li span{
	color: #eee;
	font-size: 15px;
	
}

.Card .My_info2 {
	width: 100%;
	color: #eee;
}

p{ 

text-align: center;

}

.Card .My_info2 .title, .Matching_info {
	color: #eee;
	margin-bottom: 8px;
	font-weight: 500;
	text-align: center;
	font-size: 20px;
}

.line {
	border-bottom: 2px solid yellow;
	margin: 8px auto;
}

.Card .barOuter {
	margin-top: 12px;
	display: flex;
	line-height: 1.5;
	justify-content: center;
	text-align: center;
}

.Card .barOuter .My_type {
	text-transform: lowercase;
	font-size: 15px;
	margin-bottom: 5px;
}

p.My_type2 {
	display: flex;
}

.Card .barOuter .barLevel {
	height: auto;
	line-height: 1.7;
	padding: 8px;
}

.Card .barOuter2 .barLevel {
	line-height: 1.4;
    margin-bottom: 15px;
    display: flex;
    justify-content: center;
    text-align: center;
    align-items: center;
}

.PreNext {
	margin: 5px auto;
	position: relative;
	top: 15px;
	display: flex;
	justify-content: center;
	padding: 0px;
}


button#pre:hover, button#next:hover {
	transition: all 0.2s ease 0s;
	background-color: rgba(31,209,69);
} 

button {
	border-radius: 5px;
	height: 30px;
	padding: 26px;
	justify-content: center;
	text-align: center;
	align-items: center;
	display: flex;
	background: rgba(9,9,52);
	border: 1px solid #eee;
	color: #eee;
}

button:hover {
	cursor: pointer;
}


.barOuter2 {
	text-align: center;
	padding: 0 6px;
	margin: 0 10px auto;

}

p.My_type {
	text-align: center;
}



.re {
	/* display: flex; */
	line-height: 1.7;
	margin-top: 16px;
}

table {
	margin: 0 auto;
}
tbody {
	/* display: flex; */
	justify-content: center;
    align-items: center;
    text-align: center;
}

tbody tr td {
	padding: 8px;

}

/* .date, .location {
	display: flex;
} */

</style>
<body>
	<% memberVO vo = (memberVO) session.getAttribute("vo");
	
	   BookingDAO dao = new BookingDAO();
	   /* BookingVO Bvo = (BookingVO) session.getAttribute("Bvo"); */
	   /* BookingVO Bvo2 = (BookingVO) session.getAttribute("Bvo2"); */
	   BookingVO Bvo = dao.My_booking(vo.getMEMBER_ID());

       /* BookingVO Bvo = (BookingVO) session.getAttribute("Bvo"); */
	%>
	
		<div class="Card">
			<div class="Pic">
				<img src="YJW_KSJ/resources/99. img/game2.jpg">
			</div>
			
				<p class="MEMBER_ID"><%=vo.getMEMBER_ID() %></p>
				
				
			<div class="My_info1">
				<ul>
					<li>�̸�<bR>  <span><%=vo.getMEMBER_NAME()%></span> </li>
					<li>����<bR>  <span><%=vo.getGENDER()%></span> </li>
					<li>�޴���ȭ<bR>  	 <span><%=vo.getMEMBER_PHONE()%></span> </li>
<%-- 				<li><%=vo.getP_AREA()%>   <bR>  <span></span> </li>
					<li><%=vo.getTEAM_NAME()%><bR>  <span></span> </li>
					<li><%=vo.getPOSITION()%><bR>  <span></span> </li>	 --%>			
				</ul>
			</div>
			
			<div class="My_info2">
					<div class="line"></div>
					<p class="title">�������</p>
					
				<div class="barOuter">
				
					<div class="barLevel barHTML">��ȣ���� <i class="fas fa-search-location"></i>
					<p class="My_type"><%=vo.getP_AREA()%></p>
					</div>
					
					<div class="barLevel barHTML">������ <i class="fas fa-futbol"></i>
					<p class="My_type"><%=vo.getPOSITION()%></p>
					</div>
					
					<div class="barLevel barHTML">�Ҽ� �� <i class="fas fa-users"></i>
					<p class="My_type"><%=vo.getTEAM_NAME()%></p>
					</div>
				</div>
				
			
					<div class="line"></div>
					<p class="haha">�� ��Ī��Ȳ</p><!-- <p class="Matching_info">�� ��Ī��Ȳ</p> -->
				
				<!-- <div class="barOuter2"> -->
				
					<%if(Bvo!=null){ %>
					
					<table>
						<tbody>
							<tr> <!-- 1�� -->
								<td>�������</td>
								<td><i class="far fa-calendar-alt"></i></td>
								<td><%=Bvo.getMATCHING_DATE()%></td>
							</tr>
							
							<tr> <!-- 2�� -->
								<td>�������</td>
								<td><i class="fas fa-search-location"></i></td>
								<td><%=Bvo.getADDRESS()%></td>
							</tr>
							
							<tr> <!-- 3�� -->
								<td>������</td>
								<td><i class="far fa-compass"></i></td>
								<td><%=Bvo.getFILED_NAME()%></td>
							</tr>
							
							<tr> <!-- 4�� -->
								<td>���ӹ��</td>
								<td><i class="far fa-futbol fa-1g"></i></td>
								<td><%=Bvo.getGAMES()%></td>
							</tr>
							
							<tr> <!-- 5�� -->
								<td>���ð�</td>
								<td><i class="far fa-clock"></i></td>
								<td><%=Bvo.getTIMES()%></td>
							</tr>
							
							
						</tbody>
					</table>
					
<%-- 					<div class="barLevel barHTML">�������
					<p class="My_type2"><i class="far fa-calendar-alt"></i><%=Bvo.getMATCHING_DATE()%> 
					</div>
					
 					<div class="barLevel barHTML">�������
					<p class="My_type2"><i class="far fa-calendar-alt"></i><%=Bvo.getADDRESS()%>
					</div>
					
					<div class="barLevel barHTML">������
					<p class="My_type2"><i class="far fa-calendar-alt"></i><%=Bvo.getFILED_NAME()%></p>
					</div>
					
					<div class="barLevel barHTML">���ӹ��
					<p class="My_type2"><i class="far fa-calendar-alt"></i><%=Bvo.getGAMES()%></p>
					</div>
					
					<div class="barLevel barHTML">���ð�
					<p class="My_type2"><i class="far fa-calendar-alt"></i><%=Bvo.getTIMES()%></p>
					</div> --%>
					
				<!-- </div> -->
					
					<% }else{%>
					������ �����ϴ�
					<% }%>
					
					<div class="line"></div>
					
	<div class="re">
		<div class="partner">
			<!-- <h2>��� ���</h2> -->
				<div class="partner_info">
					<p>������ �������</p>
				</div>
		</div>
		
	<div class="partner2">
		<form action="MannerForm.jsp">
		<!-- <h2>��������</h2> -->
		<input type="submit" value="������ ��" class="form"> 
		</form>
	</div>
		
		<!-- <div class="clear"></div> -->
			<div id="modal">
				<div class="body">
					<p class="p">������� Ŭ�����ּ���</p>
					<br>
					
				<div class="modal_img">
					<input type="button" name="m_result" value="�¸�" class="win"
						onclick='hidden_change("�¸�")'> <input type="hidden"
						name="m_result" value="���þ���" class="result" id="hidden_input">
						
					<input type="button" name="m_result" value="�й�" class="lose"
						onclick='hidden_change("�й�")'> <input type="hidden"
						name="m_result" value="���þ���" class="result" id="hidden_input">
						
					<input type="button" name="m_result" value="���º�" class="mu"
						onclick='hidden_change("���º�")'> <input type="hidden"
						name="m_result" value="���þ���" class="result" id="hidden_input">
						
				</div>
					<br>
					<div id='result3'>���þ���</div>
						<div class="button">
							<button type="button" id="btn-close">�ݱ�</button>
						</div>
				</div>
			</div>
		<!-- </div> -->
			
				<div class="PreNext">
			
				<!-- �ڷΰ���  -->
				<button id="pre" onclick="history.back();">��������</button>
				
				<!-- ���� ���������� �ٸ� ������ �̵�  -->
				<button id="next" onclick="location.href='Update.jsp'">��������</button>
				
				<!-- <a href="#" onclick="history.back()">��������</a>
				<a href="#" onclick="location.href='Update.jsp'">�� ��������</a> -->
				
				</div>
		</div>
			
		</div>
	</div>
		
	<script src="./YJW_KSJ/JS/jquery-3.6.0.min.js"></script>
	
	<script>
		$(".partner p").click(function() {
			$("#modal").addClass("active");
		});
		
		$("#modal button").click(function() {
			$("#modal").removeClass("active");
		});
		
		function hidden_change(val) {
			var hidden = document.getElementById("hidden_input");
			hidden.value = val;
			document.getElementById('result3').innerText = val;
		}
		
	</script>
		
	</body>
</html>