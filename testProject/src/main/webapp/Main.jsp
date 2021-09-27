<%@page import="testProject.memberVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
    <!-- 폰트 -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    
    <!-- 이미지 슬라이더 왼쪽 오른쪽 화살표 -->
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
    
    <!-- CSS document -->
    <link rel="stylesheet" href="./YJW_KSJ/CSS/Main.css">
    <link rel="stylesheet" href="./YJW_KSJ/CSS/Main_imgSlider.css">
    <link rel="stylesheet" href="./YJW_KSJ/CSS/Main_calendar.css">

    <!-- 순위 CSS -->
    <link rel="stylesheet" href="./YJW_KSJ/CSS/Rank.css">

    <!-- 달력 CSS -->
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
   
   <!-- 햄버거 메뉴 CSS -->
   <link rel="stylesheet" href="./YJW_KSJ/CSS/Menuicon.css">
   
   <link rel="stylesheet" href="./YJW_KSJ/CSS/style.css">
    <!-- Boxicons CDN link -->
   <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
   <!-- 픽토그램 준비-->
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>

<body>

   <%
      memberVO vo = (memberVO) session.getAttribute("vo");
   %>
   
       <!-- 순위 -->
    <!-- 이미지 슬라이더 -->
    <div class="container">
        <div class="navbar">
            <div class="navContainer">
                <div class="newLogo">
                    <a href="#">
                        <img src="./99. img/logo1.png">
                    </a>
                </div>

                <div class="top_menu">
                    <div class="goIn">
            <%
               if (vo == null) {
                  out.print("<a href='Loginform.jsp'>로그인</a> <span>또는</span> <a href='Joinform.html'>회원가입</a>");
                  
               }else {
                  
               if (vo.getMEMBER_ID().equals("admin")){
                  out.print("<a href='#'>회원전체 관리</a>");
                  
               }%><%else {%>
                    <input type="checkbox" id="menuicon">
                    <label for="menuicon">
                       <!-- 햄버거 -->
                        <span></span>
                        
                        <span></span>
                        <span></span>
                    </label>
                 
                    <div class="sidebar_content">
                    <%
				 	out.print("<h3>" + vo.getMEMBER_ID() + "님 환영합니다.</h3>");
					%>
                     <ul>
                            <li><a href="Update.jsp">내 정보</a></li>
                             <li><a>팀 찾기</a></li>
                             <li><a href="Team.jsp">팀 생성</a></li>
                            <li><a>경기선택</a></li>
                            <li><a href="BoardList">용병게시판</a></li>
                            <li><a href="LGW_HYH/Guide.jsp">풋살가이드</a></li>                           
                            <li><a href="Logoutform.jsp">로그아웃</a></li>
                        </ul>
                    </div> 

                  <!-- // 햄버거 메뉴 -->
                   <!-- out.print("<a href='#'><i class='iconbtn fas fa-bars'></i></a>");  -->
                  <%}
               }
            %>
            
                    </div>
                </div>
            </div>

            <div class="Rank_box">
                <div id="Rank">
                    <p>실시간 랭킹 순위</p>
                    <dl id="rank-list">
                        <div class="cont">
                        <dd>
                            <ol>
                                <li><a href="#">[Rank 1] A팀 승점 : 1000점 전적 200승 2무 0패 매너점수 4.7</a></li>
                                <li><a href="#">Rank 2</a></li>
                                <li><a href="#">Rank 3</a></li>
                                <li><a href="#">Rank 4</a></li>
                                <li><a href="#">Rank 5</a></li>
                                <li><a href="#">Rank 6</a></li>
                                <li><a href="#">Rank 7</a></li>
                                <li><a href="#">Rank 8</a></li>
                                <li><a href="#">Rank 9</a></li>
                                <li><a href="#">Rank 10</a></li>
                            </ol>
                        </dd>

                        </div>
                    </dl>
                </div>
            </div>
        </div>
    
        


<!-- 이미지 슬라이더 -->
<!-- ----사진 변경 필요!!!!-- -->
<div id="wrapper">
    <div id="slider-wrap">
        <ul id="slider">
            <li>
                <div>
                    <h3>Slide  #1</h3>
                    <span>Sub-title #1</span>
                </div>                
<img src="https://fakeimg.pl/350x200/960a96/000?text=11111">
            </li>

            <li>
                <div>
                    <h3>Slide #2</h3>
                    <span>Sub-title #2</span>
                </div>
<img src="https://fakeimg.pl/350x200/D27328/000?text=22222">
            </li>

            <li>
                <div>
                    <h3>Slide #3</h3>
                    <span>Sub-title #3</span>
                </div>
<img src="https://fakeimg.pl/350x200/FF607F/000?text=33333">
            </li>

            <li>
                <div>
                    <h3>Slide #4</h3>
                    <span>Sub-title #4</span>
                </div>
<img src="https://fakeimg.pl/350x200/0A6E0A/000?text=44444">
            </li>

            <li>
                <div>
                    <h3>Slide #5</h3>
                    <span>Sub-title #5</span>
                </div>
<img src="https://fakeimg.pl/350x200/0064CD/000?text=55555">
            </li>


        </ul>

        <!--이미지 슬라이더 컨트롤-->
        <div class="btns" id="next"><i class="fa fa-arrow-right"></i></div>
        <div class="btns" id="previous"><i class="fa fa-arrow-left"></i></div>
        <div id="counter"></div>

        <div id="pagination-wrap">
            <ul>
            </ul>
        </div>
        <!--controls-->  

    </div>

</div>
    </div>



    <!-- 매칭준비 -->
	<form action="BookingService">
    <div class="ready">
            <div class="date_select">

                <span>공 차는 날
                    <input type="text" id="datepicker1" name="MATCHING_DATE"
                        placeholder="날짜를 선택하세요" 
                        autocomplete="off">
                </span>
            
                <span>지역을 선택하세요
                    <select class="locations" name="ADDRESS" onchange="categoryChange(this)">
                        <option>지역을 선택하세요</option>
                        <option value="광산구">광산구</option>
                        <option value="남구">남구</option>
                        <option value="동구">동구</option>
                        <option value="북구">북구</option>
                        <option value="서구">서구</option>
                    </select>
                </span>
            
                <span>경기장을 선택하세요
                    <select id="fileds" name="FILED_NAME"> 
                        <option>경기장을 선택하세요</option>
                    </select>
                </span>
                <span>경기방식을 선택하세요
                    <select class="match_type" name="GAMES">
                        <option>경기방식을 선택하세요</option>
                        <option value="친선">친선</option>
                        <option value="일반">일반</option>
                        <option value="랭크">랭크</option>                      
                    </select>
                </span>
            </div>
         
         <div class="button_area">
                <input type="submit" id="btnjoin" class="btntype" value="예약하기">
            </div>
	</form>
           
</div>


    <!-- 제이쿼리 로드 -->
    <script src="./YJW_KSJ/JS/jquery-3.6.0.min.js"></script>
   
   <!-- 지역에 따른 경기장 선택 자바스크립트 -->
   <!-- 한글 인코딩(charset=utf-8) 추가 -->
   <script type="text/javascript" charset="utf-8" src="./YJW_KSJ/JS/Main_fileds.js"></script>>
    
    <!-- 순위 제이쿼리 -->
   <script src="./YJW_KSJ/JS/Main_rank.js" type="text/javascript"></script>

    <!-- 제이쿼리 달력 라이브러리 로드 -->
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

    <!-- 이미지 슬라이더 스크립트 -->
    <script src="./YJW_KSJ/JS/Main_imgSlider.js"></script>

    <script>
        //제이쿼리 달력라이브러리 기능
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
                ,minDate: "-5Y" //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
                ,maxDate: "+5y" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)  
                //옵션들 생략//
                //옵션들 생략//
            });                           
        });
        </script>
        
  
</body>
</html>