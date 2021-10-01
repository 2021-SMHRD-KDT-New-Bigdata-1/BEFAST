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
	// memberVO vo = (memberVO) session.getAttribute("vo");
	ArrayList<BookingVO> al;
	%>
	<div class="container">
		<div class="outcontainer">
			<form action="#">
				<!-- 	<div class="game_box">
				<h3 class="select_game">������Ȳ ����������</h3> -->

				<!-- ������Ȳ -->
				<div class="container">
					<div class="game_box2">

						<div class="wait">
							<table>
								<caption>
									<h2>������Ȳ</h2>
								</caption>
								<tbody>
									<tr>
										<td>�������</td>
										<td>����</td>
										<td>�����</td>
										<td>���ð�</td>
										<td>�����</td>
									</tr>
									<%
									if (request.getParameter("choice") == null) {
										al = dao.select();
									} else {
										String choice = request.getParameter("choice");
										al = dao.bookingsSearch(choice);
									}
									
									//ȸ������ ���(�Ѹ��� ȸ�� ������ �ϳ��� tr �±׿� - ����)
									//ȸ���� ����ŭ tr �±� �߰�
									//�� ���� (�̸���,��ȭ��ȣ,�ּ�)�� �� td �±׿�
									for (int i = 0; i < al.size(); i++) {
										BookingVO vo = al.get(i);
										out.print("<tr>");
										out.print("<td>" + al.get(i).getMATCHING_DATE() + "</td>");
										out.print("<td>" + al.get(i).getADDRESS() + "</td>");
										out.print("<td>" + al.get(i).getFILED_NAME() + "</td>");
										out.print("<td>" + al.get(i).getTIMES() + "</td>");
										out.print("<td>" + al.get(i).getGAMES() + "</td>");
										out.print("</tr>");
									}
									%>
								
							</table>
							</tbody>
						</div>

					</div>
					<div id='result3'>���þ���</div>

					<div class="columns">
						<figure>
							<!-- ���� : <img src="img/��ũ���.jpg"> -->
							<button class="btn" value="�Ϲ�" id="btn" type="submit"
								name="choice" onclick='hidden_change("�Ϲ�")'>
								<input type="hidden" name="choice" value="���þ���" class="result"
									id="hidden_input"> <img class="btn-img"
									src="YJW_KSJ/resources/99. img/team2.jpg">
							</button>
							<figcaption>�Ϲݰ��</figcaption>
						</figure>

						<figure>
							<!-- <img src="img/��ũ���.jpg"> -->
							<button class="btn" value="friend" id="btn" type="submit"
								name="choice" onclick='hidden_change("ģ��")'>
								<input type="hidden" name="choice" value="���þ���" class="result"
									id="hidden_input"> <img class="btn-img"
									src="YJW_KSJ/resources/99. img/team2.jpg">
							</button>
							<figcaption>ģ�����</figcaption>
						</figure>

						<figure>
							<!-- <img src="img/��ũ���.jpg"> -->
							<button class="btn" value="rank" id="btn" type="submit"
								name="choice" onclick='hidden_change("��ũ")'>
								<input type="hidden" name="choice" value="���þ���" class="result"
									id="hidden_input"> <img class="btn-img"
									src="YJW_KSJ/resources/99. img/team2.jpg">
							</button>
							<figcaption>��ũ���</figcaption>
						</figure>

					</div>
			</form>
		</div>

	</div>
	<script>
		function hidden_change(val) {
			var hidden = document.getElementById("hidden_input");
			hidden.value = val;
			document.getElementById("result3").innerText = val;
		}
	</script>
</body>
</html>