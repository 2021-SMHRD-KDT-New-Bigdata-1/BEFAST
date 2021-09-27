<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="Team.css">
</head>
<body>
	<div id="header">
		<h2>
			<b>팀 생성 페이지</b>
		</h2>

		<form action="teampage" method="post">
			<div id="container">
				<div id="content">
					<div class="join_content">
						<div class="up_group">
							<div class="join_form">

								<h3 class="join_group">
									<label for="name">팀 이름</label>
								</h3>
								<span class="input_box_name"> <input type="text"
									id="name" name="name" class="input_name"> <input
									type="button" class="check" value="중복체크" onclick="TeamCheck()">
								</span> 
								<span id="sp"></span>
								<h3 class="join_group">
									<label for="number">팀 인원</label>
								</h3>
								<span class="input_box_number"> <input type="text"
									id="number" name="number" class="input_number">
								</span>
								<h3 class="join_group">
									<label for="teamarea">연고지</label>
								</h3>
								<span class="input_box_area"> <select id="area"
									name="area" class="input_area">
										<option value="1">광산구</option>
										<option value="2">동구</option>
										<option value="3">서구</option>
										<option value="4">남구</option>
										<option value="5">북구</option>
								</select>
								</span>
							</div>

							<div class="join_form">
								<h3 class="join_group">
									<label for="teamlevel">팀 경쟁력</label><br> <small>랭킹전
										결과에 따라 변경될 수 있습니다.</small>
								</h3>
								<span class="input_box_teamlevel"> <select id="level"
									name="level" class="input_level">
										<option value="1">상</option>
										<option value="2">중</option>
										<option value="3">하</option>
								</select>
								</span>

								<h3 class="join_group">
									<label for="teamuniform">팀 유니폼</label>
								</h3>
								<span class="input_box_teamuniform"> <input type="radio"
									name="unifrom" class="input_uniform">O <input
									type="radio" name="unifrom" class="input_uniform">X
								</span>
								<h3 class="join_group">
									<label for="teamintrodution">팀 소개</label>
								</h3>
								<div class="input_box_teamintro">
									<textarea cols="33" rows="5"
										placeholder="간단한 팀 소개를 해주세요! 나의 팀 페이지에서 수정할 수 있습니다."
										name="intro">
                  </textarea>
								</div>

								<div class="button_create">
									<input type="submit" id="create" class="create" value="팀 생성하기">
								</div>
							</div>
						</div>
					</div>
				</div>
		</form>
		<!-- 제이쿼리 로드 -->
		<script src="LGW_HYH/resources/js/jquery-3.6.0.min.js"></script>

		<script>
			// ID중복체크
			function TeamCheck() {
				var input = document.getElementById("name");
				$.ajax({
					type : "post",
					data : {
						name : input.value
					}, // 서버에 보낼 데이터 JSON(키-값)
					url : "TeamCheckCon", // 데이터 보낼 서버페이지
					dataType : "text",
					success : function(data) {
						// 데이터 유무에 따라 id="sp"로 보낼 내용
						var sp = document.getElementById("sp");

						if (data == "true") {
							sp.innerHTML = "사용할 수 없는 팀명입니다!";

						} else {
							sp.innerHTML = "사용할 수 있는 팀명입니다!";
						}
					},
					error : function() {
						alert("통신실패!")
					}
				})
			}
		</script>
</body>
</html>