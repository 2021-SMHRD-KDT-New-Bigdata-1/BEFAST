<%@page import="testProject.BookingVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="testProject.memberVO"%>
<%@page import="testProject.BookingDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="YJW_KSJ/CSS/Showpage.css">
</head>
<body>
   <%
   BookingDAO dao = new BookingDAO();
   memberVO vo = (memberVO) session.getAttribute("vo");
   ArrayList<BookingVO> al;
   %>

   <div class="container">
      <div class="outcontainer">
         <!--    <div class="game_box">
            <h3 class="select_game">예약현황 페이지지롱</h3> -->

         <!-- 예약현황 -->
         <div class="container">
            <div class="game_box2">

               <div class="wait">
                  <table>
                     <caption>
                        <h2>예약현황</h2>
                     </caption>
                     <tbody>
                        <tr>
                           <td>경기일자</td>
                           <td>지역</td>
                           <td>경기장</td>
                           <td>경기시간</td>
                           <td>경기방식</td>
                        </tr>
                        <%
                        if (request.getParameter("choice") == null) {
                           al = dao.select();
                        } else {
                           String choice = request.getParameter("choice");
                           al = dao.bookingsSearch(choice);
                        }

                        int size = al.size() + 1;
                        int total_page = size / 3 + (size % 3 == 0 ? 0 : 1);
                        String page1 = request.getParameter("page");

                		if (page1 == null) {
                			page1 = "1";
                		}
                		int cur_page = Integer.parseInt(page1);
                        System.out.println(page1);
                        int prev_page = cur_page - 1;
                        int next_page = cur_page + 1;

                        
                        for (int i = 3 * (cur_page - 1); i < cur_page * 3; i++) {
                           if (i < al.size()) {
                              out.print("<tr>");
                              out.print("<td>" + al.get(i).getMATCHING_DATE() + "</td>");
                              out.print("<td>" + al.get(i).getADDRESS() + "</td>");
                              out.print("<td>" + al.get(i).getFILED_NAME() + "</td>");
                              out.print("<td>" + al.get(i).getTIMES() + "</td>");
                              out.print("<td>" + al.get(i).getGAMES() + "</td>");
                              out.print("</tr>");
                           } else {
                              break;
                           }
                        }
                        

                        if (prev_page <= 0) {
                           prev_page = 1;
                        } else if (cur_page >= total_page) {
                           next_page = total_page;
                        }
                        
                        out.println("<div class=div1>");
                        out.println("<a href=?page1=" + prev_page + " class=\"btnbtn-smbtn-primary\">이전</a>");
                        out.println((prev_page) + " page / " + (next_page) + " pages");
                        out.println("<a href=?page1=" + next_page + " class=\"btnbtn-smbtn-primary\">다음</a>");
                        out.println("</div>");
                        %>
                     
                  </table>
                  </tbody>

               </div>

            </div>
            <div id='result3'>선택안함</div>
            <form method="get" action="Showpage.jsp">
               <div class="columns">
                  <figure>
                     <!-- 기존 : <img src="img/랭크경기.jpg"> -->
                     <button class="btn" value="일반" id="btn" type="submit"
                        name="choice" onclick='hidden_change("일반")'>
                        <input type="hidden" name="choice" value="선택안함" class="result"
                           id="hidden_input"> <img class="btn-img"
                           src="YJW_KSJ/resources/99. img/team2.jpg">
                     </button>
                     <figcaption>일반경기</figcaption>
                  </figure>

                  <figure>
                     <!-- <img src="img/랭크경기.jpg"> -->
                     <button class="btn" value="친선" id="btn" type="submit"
                        name="choice" onclick='hidden_change("친선")'>
                        <input type="hidden" name="choice" value="선택안함" class="result"
                           id="hidden_input"> <img class="btn-img"
                           src="YJW_KSJ/resources/99. img/team2.jpg">
                     </button>
                     <figcaption>친선경기</figcaption>
                  </figure>

                  <figure>
                     <!-- <img src="img/랭크경기.jpg"> -->
                     <button class="btn" value="랭크" id="btn" type="submit"
                        name="choice" onclick='hidden_change("랭크")'>
                        <input type="hidden" name="choice" value="선택안함" class="result"
                           id="hidden_input"> <img class="btn-img"
                           src="YJW_KSJ/resources/99. img/team2.jpg">
                     </button>
                     <figcaption>랭크경기</figcaption>
                  </figure>

               </div>
            </form>
         </div>

      </div>
      <script>
         function hidden_change(val) {
            var hidden = document.getElementById("hidden_input");
            hidden.value = val;
            document.getElementById("result3").innerText = val;
         }
      </script>
</body>
</html>