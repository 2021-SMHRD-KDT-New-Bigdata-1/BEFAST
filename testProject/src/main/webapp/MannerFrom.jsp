<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="YJW_KSJ/CSS/Manner.css">
</head>
<body>
	<div id="header"></div>
        <h1><b>��� �� ��</b></h1>
        <form>
        <div>
            1. ��� ���� �ð� ����� �� ���׳���? 
            <div class="star-rating space-x-4 mx-auto">
            <input type="radio" id="5-stars" name="rating" value="5" v-model="ratings"/>
            <label for="5-stars" class="star pr-4">��</label>
            <input type="radio" id="4-stars" name="rating" value="4" v-model="ratings"/>
            <label for="4-stars" class="star">��</label>
            <input type="radio" id="3-stars" name="rating" value="3" v-model="ratings"/>
            <label for="3-stars" class="star">��</label>
            <input type="radio" id="2-stars" name="rating" value="2" v-model="ratings"/>
            <label for="2-stars" class="star">��</label>
            <input type="radio" id="1-star" name="rating" value="1" v-model="ratings" />
            <label for="1-star" class="star">��</label>
        </div> <br>
            2. ��� �� ��ģ �ൿ�� �־�����? 
            <div class="star-rating space-x-4 mx-auto">
            <input type="radio" id="5-stars2" name="rating2" value="5" v-model="ratings2"/>
            <label for="5-stars2" class="star pr-4">��</label>
            <input type="radio" id="4-stars2" name="rating2" value="4" v-model="ratings2"/>
            <label for="4-stars2" class="star">��</label>
            <input type="radio" id="3-stars2" name="rating2" value="3" v-model="ratings2"/>
            <label for="3-stars2" class="star">��</label>
            <input type="radio" id="2-stars2" name="rating2" value="2" v-model="ratings2"/>
            <label for="2-stars2" class="star">��</label>
            <input type="radio" id="1-star2" name="rating2" value="1" v-model="ratings2" />
            <label for="1-star2" class="star">��</label>
        </div> <br>
            3. ��� ���� ��� �弳�� ����߳���?
            <div class="star-rating space-x-4 mx-auto">
            <input type="radio" id="5-stars3" name="rating3" value="5" v-model="ratings3"/>
            <label for="5-stars3" class="star pr-4">��</label>
            <input type="radio" id="4-stars3" name="rating3" value="4" v-model="ratings3"/>
            <label for="4-stars3" class="star">��</label>
            <input type="radio" id="3-stars3" name="rating3" value="3" v-model="ratings3"/>
            <label for="3-stars3" class="star">��</label>
            <input type="radio" id="2-stars3" name="rating3" value="2" v-model="ratings3"/>
            <label for="2-stars3" class="star">��</label>
            <input type="radio" id="1-star3" name="rating3" value="1" v-model="ratings3" />
            <label for="1-star3" class="star">��</label>
        </div>
        <p><h3>�ڸ�Ʈ<br></p>
        <textarea cols="50" rows="5" placeholder="�ǰ��� �����ּ���"></textarea>
    </form>
<form>
    <input type='button' value='����ϱ�'>
</form>
</body>
</html>