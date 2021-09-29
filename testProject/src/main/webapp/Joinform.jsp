<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="EUC-KR">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="YJW_KSJ/CSS/Joinform.css">

    <!-- 제이쿼리 달력 CSS -->
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    
 <script>
    function checks(){
    	if(document.getElementById('MEMBER_ID').value==""){
    		alert("아이디를 입력해주세요.")
    		document.getElementById('MEMBER_ID').focus();
    		return false;
    	}else if(document.getElementById('PWD').value==""){
    		alert("비밀번호를 입력해주세요.")
    		document.document.getElementById('PWD').focus();
    		return false;
    	}else{
    		alert("회원가입이 완료되었습니다.");
    		document.getElementById('joinform').submit();
    		return true;
    	}
    }
	</script>
    
</head>
<body>
    <div id="header">
        <h2><b>BE FAST</b></h2>
    </div>
<form action="JoinService" method="post" id="joinform">
    <div id="container">
        <div id="content">
            <div class="join_content">
                <div class="up_group">
                    <div class="join_form">

                        <h3 class="join_group">
                            <label for="id">아이디</label>
                        </h3>
                        <span class="input_box_id">
                            <input type="text" id="MEMBER_ID" name="MEMBER_ID" class="input_id">
                            <input type="button" value="ID중복체크" onclick="idCheck()">
                            
                            
                            

                        </span>
                        <!-- 성공 유무에 따른 결과값 받는 곳 -->
                        <span id="sp"></span>

                        <h3 class="join_group">
                            <label for="pw">비밀번호</label>
                        </h3>
                        <span class="input_box_pw">
                            <input type="password" id="PWD" name="PWD" class="input_pw">
                        </span>

                    </div>

                    <div class="join_form">
                        <h3 class="join_group">
                            <label for="name">이름</label>
                        </h3>
                        <span class="input_box_name">
                            <input type="text" id="name" name="MEMBER_NAME" class="input_name">
                        </span>

                        <h3 class="join_group">
                            <label for="Bday">생년월일</label>
                        </h3>
                        <span class="input_box_Bday">
                            <input type="text" class="input_Bday" name="MEMBER_BIRTHDATE"  placeholder="날짜를 선택하세요"
                            autocomplete = "off" id="datepicker1">
                        </span>

                        <h3 class="join_group">
                            <label for="gender">성별</label>
                        </h3>
                        <div class="input_box_gender">
                            <input type="radio" name="GENDER" value="M">남 <input type="radio" name="GENDER" value="F">여
                            
                        </div>

                        <h3 class="join_group">
                            <label for="Phone">휴대전화</label>
                        </h3>
                        <span class="input_box_Phone">
                            <input type="tel" id="tel" name="MEMBER_PHONE" class="input_Phone" placeholder="-을 빼고 입력하세요">
                        </span>

                        <h3 class="join_group">
                            <label for="Location">선호지역</label>
                        </h3>
                        <span class="input_box_location">
                            <select id="input_location" name="P_AREA"> 
                                <option>선호지역을 선택하세요</option>
                                <option value="광산구">광산구</option>
                                <option value="남구">남구</option>
                                <option value="동구">동구</option>
                                <option value="북구">북구</option>
                                <option value="서구">서구</option>
                            </select>
                        </span>

                        <h3 class="join_group">
                            <label for="Position">포지션</label>
                        </h3>
                        <span class="input_box_position">
                            <select id="input_position" name="POSITION"> 
                                <option>선호하는 포지션을 선택하세요</option>
                                <option value="공격수">공격수</option>
                                <option value="수비수">수비수</option>
                                <option value="골키퍼">골키퍼</option>
                            </select>
                        </span>

                    </div>

                    <div class="button_area">
                        <input type="button" id="btnjoin" class="btntype" value="가입하기" onclick="checks();">
                    </div>
                   
                    <script>
           
                   /*  function JOIN() {
       				 alert("회원가입이 완료되었습니다.");
       		   		} */
                    
					</script>

                </div>
            </div>
        </div>
    </div>
</form>

    <!-- 제이쿼리 로드 -->
    <script src="YJW_KSJ/JS/jquery-3.6.0.min.js"></script>

    <!-- 제이쿼리 달력 라이브러리 로드 -->
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    
    <!-- 제이쿼리 달력라이브러리 기능 -->
    <script>
        $(function() {
            $("#datepicker1").datepicker({
                dateFormat: 'yy-mm-dd' //달력 날짜 형태
                ,showOtherMonths: true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
                ,showMonthAfterYear:true // 월- 년 순서가아닌 년도 - 월 순서
                ,changeYear: true //option값 년 선택 가능
                ,changeMonth: true //option값  월 선택 가능                
                // ,showOn : button // 버튼으로 달력 띄우기
                
                ,buttonText: "선택" //버튼 호버 텍스트              
                ,yearSuffix: "년 " //달력의 년도 부분 뒤 텍스트
                ,monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 텍스트
                ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip
                ,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 텍스트
                ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 Tooltip
                // ,minDate: "-100y" //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전),
                ,yearRange: 'c-100:c+0' // 현재날짜로부터 100년 전까지
                // ,maxDate: "+5y" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)  
                // //옵션들 생략//
                // //옵션들 생략//
            });                           
        });
    </script>

    <script>
        // ID중복체크
        function idCheck(){
        	var input = document.getElementById("MEMBER_ID");
            $.ajax({
                type : "post",
                data : {MEMBER_ID : input.value}, // 서버에 보낼 데이터 JSON(키-값)
                url : "idCheckCon", // 데이터 보낼 서버페이지
                dataType : "text",
                success : function(data) {  
                	// 데이터 유무에 따라 id="sp"로 보낼 내용
                    var sp = document.getElementById("sp");

                    if (data == "true"){
                        sp.innerHTML = "사용할 수 없는 ID입니다!";

                    }else {
                        sp.innerHTML = "사용할 수 있는 ID입니다!";
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