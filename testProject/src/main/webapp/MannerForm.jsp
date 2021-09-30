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
<script type="text/javascript" src="LGW_HYH/js/rating.js"></script>
<style type=text/css></style>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="MannerInsert.jsp" method="post">
		<div id="header"></div>
		<h1>
			<b>경기 등록 & 경기 평가</b>
		</h1>
		<div class="partner">
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
					<input type="button" name="m_result" value="승리" class="result">
					<input type="button" name="m_result" value="패배" class="result">
					<input type="button" name="m_result" value="무승부" class="result">
				</div>
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

		<div>
			1. 상대 팀은 시간 약속을 잘 지켰나요?
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
				<input type="radio" id="5-stars2" name="rating2" value="5" onclick='getCheckboxValue()'
					v-model="ratings2" /> <label for="5-stars2" class="star pr-4">★</label>
				<input type="radio" id="4-stars2" name="rating2" value="4" onclick='getCheckboxValue()'
					v-model="ratings2" /> <label for="4-stars2" class="star">★</label>
				<input type="radio" id="3-stars2" name="rating2" value="3" onclick='getCheckboxValue()'
					v-model="ratings2" /> <label for="3-stars2" class="star">★</label>
				<input type="radio" id="2-stars2" name="rating2" value="2" onclick='getCheckboxValue()'
					v-model="ratings2" /> <label for="2-stars2" class="star">★</label>
				<input type="radio" id="1-star2" name="rating2" value="1" onclick='getCheckboxValue()'
					v-model="ratings2" /> <label for="1-star2" class="star">★</label>
			</div>
			<br> 3. 상대 팀은 폭언 및 욕설을 사용했나요?
			<div class="star-rating space-x-4 mx-auto">
				<input type="radio" id="5-stars3" name="rating3" value="5" onclick='getCheckboxValue()'
					v-model="ratings3" /> <label for="5-stars3" class="star pr-4">★</label>
				<input type="radio" id="4-stars3" name="rating3" value="4" onclick='getCheckboxValue()'
					v-model="ratings3" /> <label for="4-stars3" class="star">★</label>
				<input type="radio" id="3-stars3" name="rating3" value="3" onclick='getCheckboxValue()'
					v-model="ratings3" /> <label for="3-stars3" class="star">★</label>
				<input type="radio" id="2-stars3" name="rating3" value="2" onclick='getCheckboxValue()'
					v-model="ratings3" /> <label for="2-stars3" class="star">★</label>
				<input type="radio" id="1-star3" name="rating3" value="1" onclick='getCheckboxValue()'
					v-model="ratings3" /> <label for="1-star3" class="star">★</label>
			</div>
			<p>
			<h3>
				코멘트<br>
				</p>
				<textarea cols="50" rows="5" name="comments" placeholder="의견을 적어주세요"></textarea>
				<div id='result'></div>
				<input type="submit" value='등록하기'>
	</form>
	<script>
	function getCheckboxValue()  {
		  // 선택된 목록 가져오기
		  const query = 'input[name="rating"]:checked';
		  const query1 = 'input[name="rating2"]:checked';
		  const query2= 'input[name="rating3"]:checked';
		  const selectedEls =  document.querySelectorAll(query);
		  const selectedEls1 =  document.querySelectorAll(query1);
		  const selectedEls2 =  document.querySelectorAll(query2);
		  
		  // 선택된 목록에서 value 찾기
		  let result = '';
		  let result1 = '';
		  let result2 = '';
		  selectedEls.forEach((el) => {result += el.value + ' ';});
		  selectedEls1.forEach((el) => {result1 += el.value + ' ';});
		  selectedEls2.forEach((el) => {result2 += el.value + ' ';});
		  
		  // 출력
		  document.getElementById('result').innerText = result;
		  document.getElementById('result1').innerText = result1;
		  document.getElementById('result2').innerText = result2;
		  //window.open("MannerInsert.jsp?result="+result);
		}
</script>
</body>
</html>