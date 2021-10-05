
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
    <!-- ��Ʈ -->  
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    
    <!-- �̹��� �����̴� ���� ������ ȭ��ǥ -->
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
    
    <!-- CSS document -->
    <link rel="stylesheet" href="./YJW_KSJ/CSS/Main.css">
    <link rel="stylesheet" href="./YJW_KSJ/CSS/Main_imgSlider.css">
    <link rel="stylesheet" href="./YJW_KSJ/CSS/Main_calendar.css">

    <!-- ���� CSS -->
    <link rel="stylesheet" href="./YJW_KSJ/CSS/Rank.css">

    <!-- �޷� CSS -->
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
   
   <!-- �ܹ��� �޴� CSS -->
   <link rel="stylesheet" href="./YJW_KSJ/CSS/Menuicon.css">
   
   <link rel="stylesheet" href="./YJW_KSJ/CSS/style.css">
    <!-- Boxicons CDN link -->
   <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
   <!-- ����׷� �غ�-->
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
   
   
       <!-- ���� -->
    <!-- �̹��� �����̴� -->
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
                  out.print("<a href='Loginform.jsp'>�α���</a> <span>�Ǵ�</span> <a href='Joinform.jsp'>ȸ������</a>");
                  
               }else {
                  
               if (vo.getMEMBER_ID().equals("admin")){
                  out.print("<a href='#'>ȸ����ü ����</a>");
                  
               }%><%else {%>
                    <input type="checkbox" id="menuicon">
                    <label for="menuicon">
                       <!-- �ܹ��� -->
                        <span></span>
                        <span></span>
                        <span></span>
                    </label>
                 
                    <div class="sidebar_content">
                    
                    <%-- <%
                out.print("<h3>" + vo.getMEMBER_ID() + "�� ȯ���մϴ�.</h3>");
               %> --%>
               
                     <ul>
                    <%
                out.print("<h3>" + vo.getMEMBER_ID() + "�� ȯ���մϴ�.</h3>");
               
               %>
               
                            <li><a href="Myinfo.jsp">�� ����</a></li>
                          <%--  <%if(vo.getMEMBER_ID().equals()  {%>
                           
                           
                           <% }%> --%>
                            <li><a href="TeamList">�� ã��</a></li>
                            <li><a href="LGW_HYH/Team.jsp">�� ����</a></li>
                            <li><a href="BoardList">�뺴�Խ���</a></li>
                            <li><a href="YJW_KSJ/ShowPage2.jsp">������Ȳ</a></li>
                            <li><a href="LGW_HYH/Guide.jsp">ǲ�찡�̵�</a></li>
                            <li><a href="Logoutform.jsp">�α׾ƿ�</a></li>
                        </ul>
                    </div> 

                  <!-- // �ܹ��� �޴� -->
                   <!-- out.print("<a href='#'><i class='iconbtn fas fa-bars'></i></a>");  -->
                  <%}
               }
            %>
            
                    </div>
                </div>
            </div>

            <div class="Rank_box">
                <div id="Rank">
                    <p>�ǽð� ��ŷ ����</p>
                    <dl id="rank-list">
                        <div class="cont">
                        <dd>
                            <ol>
                                <li><a href="#">[Rank 1] Ȳ����FC ���� : 2040�� ����: 80�� 1�� 5�� �ų�����: 4</a></li>
                                <li><a href="#">[Rank 2] ȫ����FC ���� : 1340�� ����: 40�� 2�� 4�� �ų�����: 4</a></li>
                                <li><a href="#">[Rank 3] ������3FC ���� : 1120�� ����: 12�� 4�� 5�� �ų�����: 5</a></li>
                                <li><a href="#">[Rank 4] ������2FC ���� : 1060�� ����: 3�� 4�� 5�� �ų�����: 5</a></li>
                                <li><a href="#">[Rank 5] �ְǿ�FC ���� : 1040�� ����: 9�� 1�� 5�� �ų�����:4</a></li>
                               
                            </ol>
                        </dd>

                        </div>
                    </dl>
                </div>
            </div>
        </div>
    
        




<!-- �̹��� �����̴� -->
<!-- ----���� ���� �ʿ�!!!!-- -->
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

        <!--�̹��� �����̴� ��Ʈ��-->
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

    </div> <!-- <--�����̳� ����κ� -->
    




    <!-- ��Ī�غ� -->
   <form action="BookingService2" id="Bookingform">
    <div class="ready">
            <div class="date_select">

                <span>�� ���� ��
                    <input type="text" id="datepicker1" name="MATCHING_DATE"
                        placeholder="��¥�� �����ϼ���" 
                        autocomplete="off">
                </span>
            
                <span>������ �����ϼ���
                    <select class="locations" id="locations" name="ADDRESS" onchange="categoryChange(this)">
                        <option value="">������ �����ϼ���</option>
                        <option value="���걸">���걸</option>
                        <option value="����">����</option>
                        <option value="����">����</option>
                        <option value="�ϱ�">�ϱ�</option>
                        <option value="����">����</option>
                    </select>
                </span>
            
            
                <span>������� �����ϼ���
                    <select id="fileds" name="FILED_NAME"> 
                        <option>������� �����ϼ���</option>
                    </select>
                </span>
                
            <span>���ð��� �����ϼ���
               <select id="TIMES" name="TIMES"> 
                        <option value="">���ð��� �����ϼ���</option>
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
                
                
                <span>������� �����ϼ���
                    <select class="match_type" id="match_type" name="GAMES">
                        <option value="">������� �����ϼ���</option>
                        <option value="ģ��">ģ��</option>
                        <option value="�Ϲ�">�Ϲ�</option>
                        <option value="��ũ">��ũ</option>                      
                    </select>
                </span>
            </div>
        
         <div class="button_area">
                <input type="button" id="btnjoin" class="btntype" value="�����ϱ�" onclick="BOOKING();">

         </div>
        
    </div>      
   </form>
           




    <!-- �������� �ε� -->
    <script src="./YJW_KSJ/JS/jquery-3.6.0.min.js"></script>
   
   <!-- ������ ���� ����� ���� �ڹٽ�ũ��Ʈ -->
   <!-- �ѱ� ���ڵ�(charset=utf-8) �߰� -->
   <script type="text/javascript" charset="utf-8" src="./YJW_KSJ/JS/Main_fileds.js"></script>>
    
    <!-- ���� �������� -->
   <script src="./YJW_KSJ/JS/Main_rank.js" type="text/javascript"></script>

    <!-- �������� �޷� ���̺귯�� �ε� -->
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

    <!-- �̹��� �����̴� ��ũ��Ʈ -->
    <script src="./YJW_KSJ/JS/Main_imgSlider.js"></script>

    <script>
        //�������� �޷¶��̺귯�� ���
        $(function() {
            $("#datepicker1").datepicker({
                dateFormat: 'yy-mm-dd' //�޷� ��¥ ����
                // ,type : "date"
                ,showOtherMonths: true //�� ������ ������� �յڿ��� ��¥�� ǥ��
                ,showMonthAfterYear:true // ��- �� �������ƴ� �⵵ - �� ����
                ,changeYear: true //option�� �� ���� ����
                ,changeMonth: true //option��  �� ���� ����                
                // ,showOn : button // ��ư���� �޷� ����
                
                ,buttonText: "����" //��ư ȣ�� �ؽ�Ʈ              
                ,yearSuffix: "�� " //�޷��� �⵵ �κ� �� �ؽ�Ʈ
                ,monthNamesShort: ['1��','2��','3��','4��','5��','6��','7��','8��','9��','10��','11��','12��'] //�޷��� �� �κ� �ؽ�Ʈ
                ,monthNames: ['1��','2��','3��','4��','5��','6��','7��','8��','9��','10��','11��','12��'] //�޷��� �� �κ� Tooltip
                ,dayNamesMin: ['��','��','ȭ','��','��','��','��'] //�޷��� ���� �ؽ�Ʈ
                ,dayNames: ['�Ͽ���','������','ȭ����','������','�����','�ݿ���','�����'] //�޷��� ���� Tooltip
                ,minDate: "-5Y" //�ּ� ��������(-1D:�Ϸ���, -1M:�Ѵ���, -1Y:�ϳ���)
                ,maxDate: "+5y" //�ִ� ��������(+1D:�Ϸ���, -1M:�Ѵ���, -1Y:�ϳ���)  
                //�ɼǵ� ����//
                //�ɼǵ� ����//
            });                           
        });
        </script>
        
           <script>
         function BOOKING() {

             if (document.getElementById('datepicker1').value==""){
                alert("������ڸ� �������ּ���.")
                document.getElementById('datepicker1').focus();
                
                return false;
                
             }else if (document.getElementById('locations').value==""){
                alert("������ �������ּ���.")
                document.getElementById('locations').focus();
                
                return false;
                
             } else if (document.getElementById("fileds").value==""){
               alert("������� �������ּ���.")
               document.getElementById('fileds').focus();
               
               return false;
               
             } else if (document.getElementById("TIMES").value==""){
               alert("���ð��� �������ּ���.")
               document.getElementById('TIMES').focus();
               
               return false;
               
             } else if (document.getElementById("match_type").value=="") {
               alert("������� �������ּ���.")
               document.getElementById('match_type').focus();
               
               return false;
               
             }else{
                alert("������ �Ϸ�Ǿ����ϴ�.");
                document.getElementById('Bookingform').submit();
                return true;
             }
          }
      </script>

  
</body>
</html>