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
</head>

<body>
	<%
		memberVO vo = (memberVO) session.getAttribute("vo");
	%>
	
	<%
		if (vo == null) {
			out.print("<a href='#'>�α���</a>");
		}else {
			if (vo.getMEMBER_ID().equals("admin")){
				out.print("<a href='#'>ȸ����ü ����</a>");
			}else {
				out.print("<a href='#'>����������</a>");
			}
			out.print("<a href='#'>�α׾ƿ�</a>");
		}
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
					}else {
						out.print("<a href='#'>����������\t</a>");
					}
						out.print("<a href='#'>�α׾ƿ�</a>");
					}
				%>
                        <!-- <a href="Loginform.html">�α���</a> -->
                        <!-- <span>�Ǵ�</span> -->
                        <!-- <a href="Joinform.html">ȸ������</a> -->
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
                                <li><a href="#">Rank 1 : A��</a></li>
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
    <div class="ready">
            <div class="date_select">

                <span>�� ���� ��
                    <input type="text" id="datepicker1" 
                        placeholder="��¥�� �����ϼ���" 
                        autocomplete="off">
                </span>
            
                <span>������ �����ϼ���
                    <select class="locations" onchange="categoryChange(this)">
                        <option>������ �����ϼ���</option>
                        <option value="���걸">���걸</option>
                        <option value="����">����</option>
                        <option value="����">����</option>
                        <option value="�ϱ�">�ϱ�</option>
                        <option value="����">����</option>
                    </select>
                </span>
            
                <span>������� �����ϼ���
                    <!-- sub -->
                    <select id="fileds"> 
                        <option>������� �����ϼ���</option>
                    </select>
                </span>
            </div>
			
			<div class="button_area">
                <input type="button" id="btnjoin" class="btntype" value="�����ϱ�">
            </div>
           
</div>


    <!-- �������� �ε� -->
    <script src="./YJW_KSJ/JS/jquery-3.6.0.min.js"></script>

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
        
        <!-- ������ ���� ����� ���� �ڹٽ�ũ��Ʈ -->
        <script src="./YJW_KSJ/JS/Main_fileds.js"></script>
</body>
</html>