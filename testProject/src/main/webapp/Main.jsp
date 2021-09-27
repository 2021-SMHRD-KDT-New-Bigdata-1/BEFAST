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
      memberVO vo = (memberVO) session.getAttribute("vo");
   %>
   
       <!-- ���� -->
    <!-- �̹��� �����̴� -->
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
                  out.print("<a href='Loginform.jsp'>�α���</a> <span>�Ǵ�</span> <a href='Joinform.html'>ȸ������</a>");
                  
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
                    <%
				 	out.print("<h3>" + vo.getMEMBER_ID() + "�� ȯ���մϴ�.</h3>");
					%>
                     <ul>
                            <li><a href="Update.jsp">�� ����</a></li>
                             <li><a>�� ã��</a></li>
                             <li><a href="Team.jsp">�� ����</a></li>
                            <li><a>��⼱��</a></li>
                            <li><a href="BoardList">�뺴�Խ���</a></li>
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
                                <li><a href="#">[Rank 1] A�� ���� : 1000�� ���� 200�� 2�� 0�� �ų����� 4.7</a></li>
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
    
        


<!-- �̹��� �����̴� -->
<!-- ----���� ���� �ʿ�!!!!-- -->
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
    </div>



    <!-- ��Ī�غ� -->
	<form action="BookingService">
    <div class="ready">
            <div class="date_select">

                <span>�� ���� ��
                    <input type="text" id="datepicker1" name="MATCHING_DATE"
                        placeholder="��¥�� �����ϼ���" 
                        autocomplete="off">
                </span>
            
                <span>������ �����ϼ���
                    <select class="locations" name="ADDRESS" onchange="categoryChange(this)">
                        <option>������ �����ϼ���</option>
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
                <span>������� �����ϼ���
                    <select class="match_type" name="GAMES">
                        <option>������� �����ϼ���</option>
                        <option value="ģ��">ģ��</option>
                        <option value="�Ϲ�">�Ϲ�</option>
                        <option value="��ũ">��ũ</option>                      
                    </select>
                </span>
            </div>
         
         <div class="button_area">
                <input type="submit" id="btnjoin" class="btntype" value="�����ϱ�">
            </div>
	</form>
           
</div>


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
        
  
</body>
</html>