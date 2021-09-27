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
			<b>�� ���� ������</b>
		</h2>

		<form action="teampage" method="post">
			<div id="container">
				<div id="content">
					<div class="join_content">
						<div class="up_group">
							<div class="join_form">

								<h3 class="join_group">
									<label for="name">�� �̸�</label>
								</h3>
								<span class="input_box_name"> <input type="text"
									id="name" name="name" class="input_name"> <input
									type="button" class="check" value="�ߺ�üũ" onclick="TeamCheck()">
								</span> 
								<span id="sp"></span>
								<h3 class="join_group">
									<label for="number">�� �ο�</label>
								</h3>
								<span class="input_box_number"> <input type="text"
									id="number" name="number" class="input_number">
								</span>
								<h3 class="join_group">
									<label for="teamarea">������</label>
								</h3>
								<span class="input_box_area"> <select id="area"
									name="area" class="input_area">
										<option value="1">���걸</option>
										<option value="2">����</option>
										<option value="3">����</option>
										<option value="4">����</option>
										<option value="5">�ϱ�</option>
								</select>
								</span>
							</div>

							<div class="join_form">
								<h3 class="join_group">
									<label for="teamlevel">�� �����</label><br> <small>��ŷ��
										����� ���� ����� �� �ֽ��ϴ�.</small>
								</h3>
								<span class="input_box_teamlevel"> <select id="level"
									name="level" class="input_level">
										<option value="1">��</option>
										<option value="2">��</option>
										<option value="3">��</option>
								</select>
								</span>

								<h3 class="join_group">
									<label for="teamuniform">�� ������</label>
								</h3>
								<span class="input_box_teamuniform"> <input type="radio"
									name="unifrom" class="input_uniform">O <input
									type="radio" name="unifrom" class="input_uniform">X
								</span>
								<h3 class="join_group">
									<label for="teamintrodution">�� �Ұ�</label>
								</h3>
								<div class="input_box_teamintro">
									<textarea cols="33" rows="5"
										placeholder="������ �� �Ұ��� ���ּ���! ���� �� ���������� ������ �� �ֽ��ϴ�."
										name="intro">
                  </textarea>
								</div>

								<div class="button_create">
									<input type="submit" id="create" class="create" value="�� �����ϱ�">
								</div>
							</div>
						</div>
					</div>
				</div>
		</form>
		<!-- �������� �ε� -->
		<script src="LGW_HYH/resources/js/jquery-3.6.0.min.js"></script>

		<script>
			// ID�ߺ�üũ
			function TeamCheck() {
				var input = document.getElementById("name");
				$.ajax({
					type : "post",
					data : {
						name : input.value
					}, // ������ ���� ������ JSON(Ű-��)
					url : "TeamCheckCon", // ������ ���� ����������
					dataType : "text",
					success : function(data) {
						// ������ ������ ���� id="sp"�� ���� ����
						var sp = document.getElementById("sp");

						if (data == "true") {
							sp.innerHTML = "����� �� ���� �����Դϴ�!";

						} else {
							sp.innerHTML = "����� �� �ִ� �����Դϴ�!";
						}
					},
					error : function() {
						alert("��Ž���!")
					}
				})
			}
		</script>
</body>
</html>