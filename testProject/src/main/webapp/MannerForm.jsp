<%@page import="testProject.memberVO"%>
<%@page import="testProject.BookingDAO2"%>
<%@page import="testProject.BookingVO"%>
<%@page import="newthang.MannerDAO"%>
<%@page import="newthang.MannerVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<Link rel="stylesheet" href="LGW_HYH/resources/css/result.css">
<link rel="stylesheet" href="YJW_KSJ/CSS/Manner.css">
<script src="./YJW_KSJ/JS/jquery-3.6.0.min.js"></script>
<style type=text/css></style>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	memberVO vo = (memberVO) session.getAttribute("vo");
	BookingDAO2 dao = new BookingDAO2();
	 BookingVO Bvo = dao.My_booking(vo.getMEMBER_ID());
	%>
	<form action="MannerInsert.jsp" method="post">
		<div id="header"></div>
		
		<!--- <div class="partner">
			<h2>경기 결과</h2>
			<div class="partner_info">
				<p>클릭해주세요.</p>
			</div>
		</div>
		<div class="clear"></div>
		<div id="modal">
			<div class="body">
				<p class="p">경기결과를 클릭해주세요</p>
				<br>
				<div class="modal_img">
					<input type="button" name="m_result" value="승리" class="result"
						onclick='hidden_change("승리")'> <input type="hidden"
						name="m_result" value="선택안함" class="result" id="hidden_input">
					<input type="button" name="m_result" value="패배" class="result"
						onclick='hidden_change("패배")'> <input type="hidden"
						name="m_result" value="선택안함" class="result" id="hidden_input">
					<input type="button" name="m_result" value="무승부" class="result"
						onclick='hidden_change("무승부")'> <input type="hidden"
						name="m_result" value="선택안함" class="result" id="hidden_input">
				</div>
				<br> 경기결과 :
				<div id='result3'>선택안함</div>
				<div class="button">
					<button type="button" id="btn-close">닫기</button>
				</div>
			</div>
		</div>
		<script>
			$(".partner p").click(function() {
				$("#modal").addClass("active");
			});
			$("#modal button").click(function() {
				$("#modal").removeClass("active");
			});
		</script>

		<div> -->
		<div class="Card">
		<h1>
			<b>경기 평가</b>
		</h1>
			1.<input type="text" name="team_name2" class="manner"
	value="<%=Bvo.getTEAM_NAME2()%>" readonly/>은 시간 약속을 잘 지켰나요?
			<div class="star-rating space-x-4 mx-auto">
				<input type="radio" id="5-stars" name="rating" value="5"
					v-model="ratings" class="rate_radio" onclick='getCheckboxValue()' />
				<label for="5-stars" class="star pr-4">★</label> <input type="radio"
					id="4-stars" name="rating" value="4" v-model="ratings"
					class="rate_radio" onclick='getCheckboxValue()' /> <label
					for="4-stars" class="star">★</label> <input type="radio"
					id="3-stars" name="rating" value="3" v-model="ratings"
					onclick='getCheckboxValue()' class="rate_radio" /> <label
					for="3-stars" class="star">★</label> <input type="radio"
					id="2-stars" name="rating" value="2" onclick='getCheckboxValue()'
					v-model="ratings" class="rate_radio" /> <label for="2-stars"
					class="star">★</label> <input type="radio" id="1-star"
					name="rating" value="1" v-model="ratings" class="rate_radio"
					onclick='getCheckboxValue()' /> <label for="1-star" class="star">★</label>
			</div>
			<br> 2. 경기 중 거친 행동이 있었나요?
			<div class="star-rating space-x-4 mx-auto">
				<input type="radio" id="5-stars2" name="rating2" value="5"
					onclick='getCheckboxValue()' v-model="ratings2" /> <label
					for="5-stars2" class="star pr-4">★</label> <input type="radio"
					id="4-stars2" name="rating2" value="4" onclick='getCheckboxValue()'
					v-model="ratings2" /> <label for="4-stars2" class="star">★</label>
				<input type="radio" id="3-stars2" name="rating2" value="3"
					onclick='getCheckboxValue()' v-model="ratings2" /> <label
					for="3-stars2" class="star">★</label> <input type="radio"
					id="2-stars2" name="rating2" value="2" onclick='getCheckboxValue()'
					v-model="ratings2" /> <label for="2-stars2" class="star">★</label>
				<input type="radio" id="1-star2" name="rating2" value="1"
					onclick='getCheckboxValue()' v-model="ratings2" /> <label
					for="1-star2" class="star">★</label>
			</div>
			<br> 3. 상대 팀은 폭언 및 욕설을 사용했나요?
			<div class="star-rating space-x-4 mx-auto">
				<input type="radio" id="5-stars3" name="rating3" value="5"
					onclick='getCheckboxValue()' v-model="ratings3" /> <label
					for="5-stars3" class="star pr-4">★</label> <input type="radio"
					id="4-stars3" name="rating3" value="4" onclick='getCheckboxValue()'
					v-model="ratings3" /> <label for="4-stars3" class="star">★</label>
				<input type="radio" id="3-stars3" name="rating3" value="3"
					onclick='getCheckboxValue()' v-model="ratings3" /> <label
					for="3-stars3" class="star">★</label> <input type="radio"
					id="2-stars3" name="rating3" value="2" onclick='getCheckboxValue()'
					v-model="ratings3" /> <label for="2-stars3" class="star">★</label>
				<input type="radio" id="1-star3" name="rating3" value="1"
					onclick='getCheckboxValue()' v-model="ratings3" /> <label
					for="1-star3" class="star">★</label>
			</div>
			<p>
			<h3>
				코멘트
				<div class="line"></div>
				</p>
				<textarea cols="50" rows="5" name="comments" placeholder="의견을 적어주세요."></textarea>
				<div class="sub">
				<input type="submit" value='등록하기'>
				</div>
		</div>
	</form>
	<script>
		function hidden_change(val) {
			var hidden = document.getElementById("hidden_input");
			hidden.value = val;
			document.getElementById('result3').innerText = val;
		}
	</script>
</body>
</html>