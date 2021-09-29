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

    <!-- �������� �޷� CSS -->
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    
 <script>
    function checks(){
    	if(document.getElementById('MEMBER_ID').value==""){
    		alert("���̵� �Է����ּ���.")
    		document.getElementById('MEMBER_ID').focus();
    		return false;
    	}else if(document.getElementById('PWD').value==""){
    		alert("��й�ȣ�� �Է����ּ���.")
    		document.document.getElementById('PWD').focus();
    		return false;
    	}else{
    		alert("ȸ�������� �Ϸ�Ǿ����ϴ�.");
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
                            <label for="id">���̵�</label>
                        </h3>
                        <span class="input_box_id">
                            <input type="text" id="MEMBER_ID" name="MEMBER_ID" class="input_id">
                            <input type="button" value="ID�ߺ�üũ" onclick="idCheck()">
                            
                            
                            

                        </span>
                        <!-- ���� ������ ���� ����� �޴� �� -->
                        <span id="sp"></span>

                        <h3 class="join_group">
                            <label for="pw">��й�ȣ</label>
                        </h3>
                        <span class="input_box_pw">
                            <input type="password" id="PWD" name="PWD" class="input_pw">
                        </span>

                    </div>

                    <div class="join_form">
                        <h3 class="join_group">
                            <label for="name">�̸�</label>
                        </h3>
                        <span class="input_box_name">
                            <input type="text" id="name" name="MEMBER_NAME" class="input_name">
                        </span>

                        <h3 class="join_group">
                            <label for="Bday">�������</label>
                        </h3>
                        <span class="input_box_Bday">
                            <input type="text" class="input_Bday" name="MEMBER_BIRTHDATE"  placeholder="��¥�� �����ϼ���"
                            autocomplete = "off" id="datepicker1">
                        </span>

                        <h3 class="join_group">
                            <label for="gender">����</label>
                        </h3>
                        <div class="input_box_gender">
                            <input type="radio" name="GENDER" value="M">�� <input type="radio" name="GENDER" value="F">��
                            
                        </div>

                        <h3 class="join_group">
                            <label for="Phone">�޴���ȭ</label>
                        </h3>
                        <span class="input_box_Phone">
                            <input type="tel" id="tel" name="MEMBER_PHONE" class="input_Phone" placeholder="-�� ���� �Է��ϼ���">
                        </span>

                        <h3 class="join_group">
                            <label for="Location">��ȣ����</label>
                        </h3>
                        <span class="input_box_location">
                            <select id="input_location" name="P_AREA"> 
                                <option>��ȣ������ �����ϼ���</option>
                                <option value="���걸">���걸</option>
                                <option value="����">����</option>
                                <option value="����">����</option>
                                <option value="�ϱ�">�ϱ�</option>
                                <option value="����">����</option>
                            </select>
                        </span>

                        <h3 class="join_group">
                            <label for="Position">������</label>
                        </h3>
                        <span class="input_box_position">
                            <select id="input_position" name="POSITION"> 
                                <option>��ȣ�ϴ� �������� �����ϼ���</option>
                                <option value="���ݼ�">���ݼ�</option>
                                <option value="�����">�����</option>
                                <option value="��Ű��">��Ű��</option>
                            </select>
                        </span>

                    </div>

                    <div class="button_area">
                        <input type="button" id="btnjoin" class="btntype" value="�����ϱ�" onclick="checks();">
                    </div>
                   
                    <script>
           
                   /*  function JOIN() {
       				 alert("ȸ�������� �Ϸ�Ǿ����ϴ�.");
       		   		} */
                    
					</script>

                </div>
            </div>
        </div>
    </div>
</form>

    <!-- �������� �ε� -->
    <script src="YJW_KSJ/JS/jquery-3.6.0.min.js"></script>

    <!-- �������� �޷� ���̺귯�� �ε� -->
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    
    <!-- �������� �޷¶��̺귯�� ��� -->
    <script>
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
                // ,minDate: "-100y" //�ּ� ��������(-1D:�Ϸ���, -1M:�Ѵ���, -1Y:�ϳ���),
                ,yearRange: 'c-100:c+0' // ���糯¥�κ��� 100�� ������
                // ,maxDate: "+5y" //�ִ� ��������(+1D:�Ϸ���, -1M:�Ѵ���, -1Y:�ϳ���)  
                // //�ɼǵ� ����//
                // //�ɼǵ� ����//
            });                           
        });
    </script>

    <script>
        // ID�ߺ�üũ
        function idCheck(){
        	var input = document.getElementById("MEMBER_ID");
            $.ajax({
                type : "post",
                data : {MEMBER_ID : input.value}, // ������ ���� ������ JSON(Ű-��)
                url : "idCheckCon", // ������ ���� ����������
                dataType : "text",
                success : function(data) {  
                	// ������ ������ ���� id="sp"�� ���� ����
                    var sp = document.getElementById("sp");

                    if (data == "true"){
                        sp.innerHTML = "����� �� ���� ID�Դϴ�!";

                    }else {
                        sp.innerHTML = "����� �� �ִ� ID�Դϴ�!";
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