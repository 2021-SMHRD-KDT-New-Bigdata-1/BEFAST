
<%@page import="testProject.memberVO"%>
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
<% memberVO vo = (memberVO) session.getAttribute("vo");
 
	
	String member_id = vo.getMEMBER_ID();
	String team_name = vo.getTEAM_NAME();    
	%>
<div id="header">
		<h3 class="title">
			<label>팀 생성 페이지</label>
		</h3>
	<div class="header_box">
		<form action="TeamInsert.jsp" method="post">
			<div id="container">
				<div id="content">
					<div class="join_content">
						<div class="up_group">
							<div class="join_form">

								<h3 class="join_group">
									<label for="name">팀 이름</label>
								</h3>
								
								<span class="input_box_name">
								<input type="text" id="name" name="name" class="input_name"> 
								<input type="button" class="check" value="중복체크" onclick="TeamCheck()">
								</span> 
								
								<span id="sp"></span>
								
								<h3 class="join_group">
									<label for="teamarea">연고지</label>
								</h3>
								
								<span class="input_box_area"> 
								<select id="area" name="area" class="input_area">
										<option value="광산구">광산구</option>
										<option value="동구">동구</option>
										<option value="서구">서구</option>
										<option value="남구">남구</option>
										<option value="북구">북구</option>
								</select>
								
								</span><span id="sp"></span>
								
								<h3 class="join_group">
									<label for="teamtime">선호시간</label>
								</h3>
								
								<span class="input_box_time">
								<input type="checkbox" name="time" class="input_time" value="월">월 
								<input type="checkbox" name="time" class="input_time" value="화">화
								<input type="checkbox" name="time" class="input_time" value="수">수
								<input type="checkbox" name="time" class="input_time" value="목">목
								<input type="checkbox" name="time" class="input_time" value="금">금
								<input type="checkbox" name="time" class="input_time" value="토">토
								<input type="checkbox" name="time" class="input_time" value="일">일
									<!-- </select>  <<존재이유???-->
								</span>
								
								<div class="line"></div>
								
							</div>

							<div class="join_form">
								<h3 class="join_group">
									<label for="teamlevel">팀 경쟁력</label><br> <small>랭킹전
										결과에 따라 변경될 수 있습니다!!</small>
								</h3>
								
								<span class="input_box_teamlevel"> 
								<select id="level" name="level" class="input_level">
										<option value="3">상</option>
										<option value="2">중</option>
										<option value="1">하</option>
								</select>
								</span>

								<h3 class="join_group">
									<label for="teamuniform">팀 유니폼</label>
								</h3>
								
								<span class="input_box_teamuniform">
								<input type="radio" name="unifrom" class="input_uniform" value="O">O 
								<input type="radio" name="unifrom" class="input_uniform" value="X">X
								</span>
								
								<h3 class="join_group">
									<label for="teamintrodution">팀 소개</label>
								</h3>
								
								<div class="input_box_teamintro">
									<textarea placeholder="간단한 팀 소개를 해주세요!" name="intro"></textarea>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
				
				<div class="last">
					<input type="radio" name="img" value="resources/img/logo1.jpg">
					<img src="resources/img/logo1.jpg" class="img">
					
					<input type="radio" name="img" value="resources/img/logo3.jpg">
					<img src="resources/img/logo3.jpg" class="img">
					
					<input type="radio" name="img" value="resources/img/logo4.jpg">
					<img src="resources/img/logo4.jpg" class="img">
					<br>
					
					<input type="radio" name="img" value="resources/img/logo5.jpg">
					<img src="resources/img/logo5.jpg" class="img">
					
					<input type="radio" name="img" value="resources/img/logo6.jpg">
					<img src="resources/img/logo6.jpg" class="img">
					
					<input type="radio" name="img" value="resources/img/logo7.jpg">
					<img src="resources/img/logo7.jpg" class="img">
					<br>
					
					<input type="radio" name="img" value="resources/img/logo8.jpg">
					<img src="resources/img/logo8.jpg" class="img">
					
					<input type="radio" name="img" value="resources/img/logo9.jpg">
					<img src="resources/img/logo9.jpg" class="img">
					
					<input type="radio" name="img" value="resources/img/logo10.jpg">
					<img src="resources/img/logo10.jpg" class="img">
					
			</div>
				<div class="button_create">
				
				<%System.out.println(team_name); 
				if(team_name==null){%>
					<input type="submit" id="create" class="create" value="팀 생성하기">
					<%} 
				else{%>
					<a href = "../Main.jsp">이미 가입된 팀이 존재합니다.</a>
				<% }%>
			</form>
		</div>
	</div>

		<!-- 제이쿼리 로드 -->
		<script src="resources/js/jquery-3.6.0.min.js"></script>
		<script>
			// ID중복체크
			function TeamCheck() {
				var input = document.getElementById("name");
				$.ajax({
					type : "post",
					data : {
						name : input.value
					}, // 서버에 보낼 데이터 JSON(키-값)
					url : "../TeamCheckCon", // 데이터 보낼 서버페이지
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