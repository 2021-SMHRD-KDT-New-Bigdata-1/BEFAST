<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<Link rel="stylesheet" href="LGW_HYH/resources/css/result.css">
<style type=text/css></style>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<div class="partner">
		<h2>��� ���</h2>
		<div class="partner_info">
			<p>����� �Է�â</p>
		</div>
	</div>
	<div class="clear"></div>
	<div id="modal">
		<div class="body">
			<div class="modal_img">
				<input type="button" value="�¸�" class="result"> <input
					type="button" value="�й�" class="result"> <input type="button"
					value="���º�" class="result">
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

	<input type="button" style="display: inline-block">�º�
	</input>
	<input type="button" style="display: inline-block">�й�
	</input>
</body>
</html>