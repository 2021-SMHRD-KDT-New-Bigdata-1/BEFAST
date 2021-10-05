
<%@page import="newthang.TeamVO"%>
<%@page import="newthang.TeamDAO"%>
<%@page import="testProject.BookingVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="testProject.BookingDAO"%>
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
   BookingDAO dao = new BookingDAO();
   memberVO vo = (memberVO) session.getAttribute("vo");
   ArrayList<BookingVO> al = dao.select();
   TeamDAO dao2 =new TeamDAO();
   ArrayList<TeamVO> list =dao2.TeamboardListData();
   
   %>
   
   
       <!-- 순위 -->
    <!-- 이미지 슬라이더 -->
    <div class="container">
        <div class="navbar">
            <div class="navContainer">
                <div class="newLogo">
                    <a href="Main.jsp">
                        <img src="YJW_KSJ/resources/99. img/logo1.png">
                    </a>
                </div>

                <div class="top_menu">
                    <div class="goIn">
            <%
               if (vo == null) {
                  out.print("<a href='Loginform.jsp'>로그인</a> <span>또는</span> <a href='Joinform.jsp'>회원가입</a>");
                  
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
                    
                    <%-- <%
                out.print("<h3>" + vo.getMEMBER_ID() + "님 환영합니다.</h3>");
               %> --%>
               
                     <ul>
                    <%
                out.print("<h3>" + vo.getMEMBER_ID() + "님 환영합니다.</h3>");
               
               %>
               
                            <li><a href="Myinfo.jsp">내 정보</a></li>
                          <%--  <%if(vo.getMEMBER_ID().equals()  {%>
                           
                           
                           <% }%> --%>
                            <li><a href="TeamList">팀 찾기</a></li>
                            <li><a href="LGW_HYH/Team.jsp">팀 생성</a></li>
                            <li><a href="BoardList">용병게시판</a></li>
                            <li><a href="YJW_KSJ/ShowPage2.jsp">예약현황</a></li>
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
                                <li><a href="#">[Rank 1] 황윤희FC 승점 : 2040점 전적: 80승 1패 5무 매너점수: 4</a></li>
                                <li><a href="#">[Rank 2] 홍윤희FC 승점 : 1340점 전적: 40승 2패 4무 매너점수: 4</a></li>
                                <li><a href="#">[Rank 3] 윤종원3FC 승점 : 1120점 전적: 12승 4패 5무 매너점수: 5</a></li>
                                <li><a href="#">[Rank 4] 윤종원2FC 승점 : 1060점 전적: 3승 4패 5무 매너점수: 5</a></li>
                                <li><a href="#">[Rank 5] 최건우FC 승점 : 1040점 전적: 9승 1패 5무 매너점수:4</a></li>
                               
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
               <!--  <div>
                    <h3>Slide  #1</h3>
                    <span>Sub-title #1</span>
                </div>  -->               
<img src="YJW_KSJ/resources/99. img/foot1.jpg">
            </li>

            <li>
               <!--  <div>
                    <h3>Slide #2</h3>
                    <span>Sub-title #2</span>
                </div> -->
<img src="YJW_KSJ/resources/99. img/foot2.jpg">
            </li>

            <li>
               <!--  <div>
                    <h3>Slide #3</h3>
                    <span>Sub-title #3</span>
                </div> -->
<img src="YJW_KSJ/resources/99. img/foot3.jpg">
            </li>

            <li>
               <!--  <div>
                    <h3>Slide #4</h3>
                    <span>Sub-title #4</span>
                </div> -->
<img src="YJW_KSJ/resources/99. img/foot4.jpg">
            </li>

            <li>
               <!--  <div>
                    <h3>Slide #5</h3>
                    <span>Sub-title #5</span>
                </div> -->
<img src="YJW_KSJ/resources/99. img/foot5.jpg">
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

    </div> <!-- <--컨테이너 종료부분 -->
    




    <!-- 매칭준비 -->
   <form action="BookingService2" id="Bookingform">
    <div class="ready">
            <div class="date_select">

                <span>공 차는 날
                    <input type="text" id="datepicker1" name="MATCHING_DATE"
                        placeholder="날짜를 선택하세요" 
                        autocomplete="off">
                </span>
            
                <span>지역을 선택하세요
                    <select class="locations" id="locations" name="ADDRESS" onchange="categoryChange(this)">
                        <option value="">지역을 선택하세요</option>
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
                
            <span>경기시간을 선택하세요
               <select id="TIMES" name="TIMES"> 
                        <option value="">경기시간을 선택하세요</option>
                        <option>06:00 ~ 08:00</option>
                        <option>08:00 ~ 10:00</option>
                        <option>10:00 ~ 12:00</option>
                        <option>12:00 ~ 14:00</option>
                        <option>14:00 ~ 16:00</option>
                        <option>16:00 ~ 18:00</option>
                        <option>18:00 ~ 20:00</option>
                        <option>20:00 ~ 22:00</option>
                        <option>22:00 ~ 24:00</option>
                        <option>00:00 ~ 02:00</option>
                        <option>02:00 ~ 04:00</option>
                        <option>04:00 ~ 06:00</option>
               </select>
                </span>
                
                
                <span>경기방식을 선택하세요
                    <select class="match_type" id="match_type" name="GAMES">
                        <option value="">경기방식을 선택하세요</option>
                        <option value="친선">친선</option>
                        <option value="일반">일반</option>
                        <option value="랭크">랭크</option>                      
                    </select>
                </span>
            </div>
        
         <div class="button_area">
                <input type="button" id="btnjoin" class="btntype" value="예약하기" onclick="BOOKING();">

         </div>
        
    </div>      
   </form>
           




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
                // ,type : "date"
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
        
           <script>
         function BOOKING() {

             if (document.getElementById('datepicker1').value==""){
                alert("경기일자를 선택해주세요.")
                document.getElementById('datepicker1').focus();
                
                return false;
                
             }else if (document.getElementById('locations').value==""){
                alert("지역을 선택해주세요.")
                document.getElementById('locations').focus();
                
                return false;
                
             } else if (document.getElementById("fileds").value==""){
               alert("경기장을 선택해주세요.")
               document.getElementById('fileds').focus();
               
               return false;
               
             } else if (document.getElementById("TIMES").value==""){
               alert("경기시간을 선택해주세요.")
               document.getElementById('TIMES').focus();
               
               return false;
               
             } else if (document.getElementById("match_type").value=="") {
               alert("경기방식을 선택해주세요.")
               document.getElementById('match_type').focus();
               
               return false;
               
             }else{
                alert("예약이 완료되었습니다.");
                document.getElementById('Bookingform').submit();
                return true;
             }
          }
      </script>

  
</body>
</html>