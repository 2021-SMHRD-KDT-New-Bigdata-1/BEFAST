<%@page import="newthang.MannerDAO"%>
<%@page import="newthang.MannerVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<Link rel="stylesheet" href="LGW_HYH/resources/css/result.css">
<style type=text/css></style>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="YJW_KSJ/CSS/Manner.css">
</head>
<body>
	<div id="header"></div>
	<h1>
		<b>��� ��� & ��� ��</b>
	</h1>
	<div class="partner">
		<h2>��� ���</h2>
		<div class="partner_info">
			<p>Ŭ�����ּ���.</p>
		</div>
	</div>
	<div class="clear"></div>
	<div id="modal">
		<div class="body">
			<p class="p">������� Ŭ�����ּ���</p>
			<br>
			<div class="modal_img">
				<input type="button" name="m_result" value="�¸�" class="result"> <input
					type="button" name="m_result" value="�й�" class="result"> <input
					type="button" name="m_result" value="���º�" class="result">
			</div>
			<div class="button">
				<button type="button" id="btn-close">�ݱ�</button>
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
	</script>
	<form action="#">
		<div>
			1. ��� ���� �ð� ����� �� ���׳���?
			<div class="star-rating space-x-4 mx-auto">
				<input type="radio" id="5-stars" name="rating" value="5"
					v-model="ratings" /> <label for="5-stars" class="star pr-4">��</label>
				<input type="radio" id="4-stars" name="rating" value="4"
					v-model="ratings" /> <label for="4-stars" class="star">��</label> <input
					type="radio" id="3-stars" name="rating" value="3" v-model="ratings" />
				<label for="3-stars" class="star">��</label> <input type="radio"
					id="2-stars" name="rating" value="2" v-model="ratings" /> <label
					for="2-stars" class="star">��</label> <input type="radio"
					id="1-star" name="rating" value="1" v-model="ratings" /> <label
					for="1-star" class="star">��</label>
			</div>
			<br> 2. ��� �� ��ģ �ൿ�� �־�����?
			<div class="star-rating space-x-4 mx-auto">
				<input type="radio" id="5-stars2" name="rating2" value="5"
					v-model="ratings2" /> <label for="5-stars2" class="star pr-4">��</label>
				<input type="radio" id="4-stars2" name="rating2" value="4"
					v-model="ratings2" /> <label for="4-stars2" class="star">��</label>
				<input type="radio" id="3-stars2" name="rating2" value="3"
					v-model="ratings2" /> <label for="3-stars2" class="star">��</label>
				<input type="radio" id="2-stars2" name="rating2" value="2"
					v-model="ratings2" /> <label for="2-stars2" class="star">��</label>
				<input type="radio" id="1-star2" name="rating2" value="1"
					v-model="ratings2" /> <label for="1-star2" class="star">��</label>
			</div>
			<br> 3. ��� ���� ���� �� �弳�� ����߳���?
			<div class="star-rating space-x-4 mx-auto">
				<input type="radio" id="5-stars3" name="rating3" value="5"
					v-model="ratings3" /> <label for="5-stars3" class="star pr-4">��</label>
				<input type="radio" id="4-stars3" name="rating3" value="4"
					v-model="ratings3" /> <label for="4-stars3" class="star">��</label>
				<input type="radio" id="3-stars3" name="rating3" value="3"
					v-model="ratings3" /> <label for="3-stars3" class="star">��</label>
				<input type="radio" id="2-stars3" name="rating3" value="2"
					v-model="ratings3" /> <label for="2-stars3" class="star">��</label>
				<input type="radio" id="1-star3" name="rating3" value="1"
					v-model="ratings3" /> <label for="1-star3" class="star">��</label>
			</div>
			<p>
			<h3>
				�ڸ�Ʈ<br>
				</p>
				<textarea cols="50" rows="5" name="comments" placeholder="�ǰ��� �����ּ���"></textarea>

				<input type='submit' value='����ϱ�'>
	</form>

	<%
	try {
		request.setCharacterEncoding("EUC-KR");
	} catch (Exception ex) {
	}
	String m_result = request.getParameter("m_result");
	String time_result = request.getParameter("rating");
	String fair_plays = request.getParameter("rating2");
	String languages = request.getParameter("rating3");
	String comments = request.getParameter("comments");
	
	MannerVO vo = new MannerVO();
	vo.setM_result(m_result);
	vo.setTime_result(time_result);
	vo.setFair_palys(fair_palys);
	vo.setLanguages(languages);
	vo.setComments(comments);
	
	MannerDAO dao = new MannerDAO();
	dao.MannerInsert(vo);
	%>
	<script>
		alert("�򰡰� �Ϸ�Ǿ����ϴ�.")
		location.href="Main.jsp";
	</script>
	
	
	
</body>
</html>