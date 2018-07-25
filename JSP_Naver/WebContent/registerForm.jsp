<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style>
	body {
		background-color: #f2f2f2;
	}
	
	a {
		color: black;
	}
	
	#container {
		width: 500px;
		margin: 0 auto;
	}
	
	 #content {
	 	 width: 500px;
	 	 
	 	 margin: 0 auto;
	 }
	 
	 #content_wrap {
	 	width: 440px;
	 	
	 	margin-top: 30px;
	 	margin-left: 30px;
	 	
	 	padding-bottom: 10px;
	 }
	 
	 .focus {
	 	color: red;
	 	font-size: 14px;
	 }
	 
	 .success {
	 	color: #4CAF50;
	 	font-size: 14px;
	 }
	 
	 #id-output, #pwd-output, #pwd-chk-output, #name-output, #gender-output, #email-output, #birth-output, #tel-output {
	 	height: 30px;
	 	
	 	margin-bottom: 10px;
	 }
	 
	 h4 {
	 	display: inline;
	 }
	 
	 input[type=text], input[type=password], select {
	 	background-color:transparent;
	 	border: none;
	 }
	 
	 .box {
	 	width: 440px;
	 	height: 50px;
	 	
	 	line-height: 50px;
	 	
	 	background-color: white;
	 	
	 	border: 1px solid #bfbfbf;
	 }
	 
	 .size-1 {
	 	margin-left: 15px;
	 	
	 	width: 300px;
	 	height: 25px;
	 	
	 	padding-right: 30px;
	 }
	 
	 .size-2 {
	 	margin-left: 15px;
	 	
	 	width: 410px;
	 	height: 25px;
	 }
	 
	 .size-3 {
	 	margin-left: 10px;
	 	
	 	width: 120px;
	 	height: 25px;
	 }
	 
	 .size-4 {
	 	margin-left: 15px;
	 	
	 	width: 300px;
	 	height: 30px;
	 }
	 
	 #birth {
	 	margin-top: 10px;
	 	margin-bottom: 5px;
	 }
	 
	 #year-wrap, #month-wrap, #day-wrap {
	 	width: 130px;
	 	height: 50px;
	 	
	 	background-color: white;
	 	
	 	line-height: 50px;
	 	padding-right: 10px;
	 	
	 	border: 1px solid #bfbfbf;
	 	
	 	display: inline-block;
	 }
	 
	 #gender {
	 	margin-top: 10px;
	 	margin-bottom: 10px;
	 	
	 	height: 75px;
	 }
	 
	 .org {
	 	color: #bfbfbf;
	 	
	 	border: 1px solid #bfbfbf;
	 }
	 
	 .chg {
	 	color: #4CAF50;
	 	
	 	border: 1px solid #4CAF50;
	 }
	 
	 #male, #female {
	 	width: 218px;
	 	height: 50px;
	 	
	 	text-align: center;
	 	line-height: 50px;
	 	
	 	display: inline-block;
	 }
	 
	 #male {
	 	float: left;
	 }
	 
	 #female {
	 	float: right;
	 }
	 
	 input[type=radio] {
	 	display: none;
	 }
	 
	 #tel {
	 	width: 440px;
	 	height: 200px;
	 	
	 	margin-top: 10px;
	 	margin-bottom: 30px;
	 }
	 
	 #telbox {
	 	height: 150px;
	 	
	 	line-height: 50px;
	 }
	 
	 #region-wrap {
	 	background-color: white;
	 	
	 	margin-top: 10px;
	 	margin-bottom: 10px;
	 	
	 	border: 1px solid #bfbfbf;
	 }
	 
	 #input-tel-wrap {
	 	width: 330px;
	 	
	 	display: inline-block;
	 	
	 	background-color: white;
	 	
	 	margin-top: 10px;
	 	margin-bottom: 10px;
	 	
	 	border: 1px solid #bfbfbf;
	 }
	 
	 #input-code-wrap {
	 	border: 1px solid #bfbfbf;
	 }
	 
	 #rev-code {
	 	height: 35px;
	 	
	 	font-size: 14px;
	 	
	 	color: white;
	 	background-color: #4CAF50;
	 	
	 	border: none;
	 }
	 
	 #photo {
	 	width: 440px;
	 	height: 200px;
	 }
	 
	 #photobox {
	 	width: 440px;
	 	height: 50px;
	 	
	 	line-height: 50px;
	 	
	 	padding-left: 5px;
	 	
	 	background-color: white;
	 	
	 	border: 1px solid #bfbfbf;
	 }
	 
	 #signup {
	 	width: 440px;
	 	height: 50px;
	 	
	 	font-size: 20px;
	 	
	 	color: white;
	 	background-color: #4CAF50;
	 	
	 	border: none;
	 }
</style>
</head>

<body>
<div id="container">
	<jsp:include page="header2.jsp" />
	
	<div id="content">
		<div id="content_wrap">
			<form action="/Naver/registerInsert.jsp" method="post" id="registerForm" enctype="multipart/form-data">
				<label><h4>아이디</h4></label>
					<div class="box">
						<input type="text" id="id" name="id" class="size-1"><span>@naver.com</span>
					</div>
					
					<div id="id-output"></div>
					
				<label><h4>비밀번호</h4></label>
					<div class="box">
						<input type="password" id="pwd" name="password" class="size-2">
					</div>
					
					<div id="pwd-output"></div>
					
				<label><h4>비밀번호 재확인</h4></label>
					<div class="box">
						<input type="password" id="pwd-chk" class="size-2">
					</div>
					
					<div id="pwd-chk-output"></div>
				
				<label><h4>이름</h4></label>
					<div class="box">
						<input type="text" id="name" name="name" class="size-2">
					</div>
					
					<div id="name-output"></div>
					
				<div id="birth">
					<label><h4>생년월일</h4></label>
					
						<div class="birth-wrap">
							<div id="year-wrap">
								<input type="text" id="year" name="year" class="size-3">
							</div>
							
							<div id="month-wrap">
								<select id="month" name="month" class="size-3" style="height: 30px;"></select>
							</div>
							
							<div id="day-wrap">
								<input type="text" id="day" name="day" class="size-3">
							</div>
						</div>
				</div>
				
					<div id="birth-output"></div>
					
				<div id="gender">
					<label><h4>성별</h4></label>
					
						<div class="gender-wrap">
							<div id="male" class="org">
								<label for="rd-male">남자<input type="radio" name="gender" id="rd-male" value="male"></label>
							</div>
							
							<div id="female" class="org">
								<label for="rd-female">여자<input type="radio" name="gender" id="rd-female" value="female"></label>
							</div>
						</div>
				</div>
				
					<div id="gender-output"></div>
					
				<label><h4>본인 확인 이메일</h4></label>
					<div class="box">
						<input type="text" id="email" name="email" class="size-2" placeholder="선택입력">
					</div>
					
					<div id="email-output"></div>
					
				<div id="tel">
					<label><h4>휴대폰</h4></label>
					
						<div id="telbox">
							<div id="region-wrap">
								<select id="region" class="size-2" style="height: 30px;"></select>
							</div>
							
							<div id="input-tel-wrap">
								<input type="text" id="input-tel" name="phone" class="size-4" placeholder="전화번호 입력">
							</div>
								<input type="button" value="인증번호 받기" id="rev-code" style="width: 100px; height: 50px;">
								
							<div id="input-code-wrap">
								<input type="text" id="input-code" class="size-2 org" placeholder="인증번호를 입력하세요" disabled>
							</div>
						</div>
				</div>
				
					<div id="tel-output"></div>
					
				<div id="photo">
					<label><h4>사진</h4></label>
					
					<div id="photobox">
						<input type="file" name="photo">
					</div>
				</div>
					
				<div id="btn">
					<input type="button" value="가입하기" id="signup">
				</div>
			</form>
		</div>
	</div>
	
	<jsp:include page="footer.jsp" />
</div>

<script>
	$(document).ready(function() {
		//id 유효성 검사
		$('#id').focusout(function() { 
			var text = $(this).val();
			var reg = /^[a-z0-9_-]{5,20}$/;
			
 			if(text.length == 0){
				$('#id-output').empty().removeClass('success');
				$('#id-output').text('필수 정보입니다.').addClass('focus');
			}        
			
 			else if(!reg.test(text)){
				$('#id-output').empty().removeClass('success');
				$('#id-output').text('5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.').addClass('focus');
			}
			
			else {
				$.ajax({
					type : 'POST',
					data : {
						id : text
					},
					url : 'idCheck.jsp',
					success : function(data) {
						if(data > 0) {
							$('#id-output').empty().removeClass('success');
							$('#id-output').text('이미 사용중이거나 탈퇴한 아이디입니다.').addClass('focus');
						}
						else {
							$('#id-output').empty().removeClass('focus');
							$('#id-output').text('멋진 아이디네요!').addClass('success');
						}
					}
				});
			}
		});
		
		//password 유효성 검사
		$('#pwd').focusout(function() {
			var text = $(this).val();
			var reg = /^(?=.*?[a-zA-Z])(?=.*?[0-9])(?=.*[#?!@$%^&*-]){6,16}/;
			
 			if(text.length == 0){
				$('#pwd-output').empty().removeClass('success');
				$('#pwd-output').text('필수 정보입니다.').addClass('focus');
			}
			
 			else if(!reg.test(text)){
				$('#pwd-output').empty().removeClass('success');
				$('#pwd-output').text('6~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.').addClass('focus');
			}
			
			else {
				$('#pwd-output').empty().removeClass('focus');
				$('#pwd-output').text('안전!').addClass('success');
			}
		});
		
		//password 일치 확인
		$('#pwd-chk').focusout(function() {
			var text = $(this).val();
			
			if(text.length == 0){
				$('#pwd-chk-output').empty().removeClass('success');
				$('#pwd-chk-output').text('필수 정보입니다.').addClass('focus');
			}
			
			else if(text == $('#pwd').val()){
				$('#pwd-chk-output').empty().removeClass('focus');
				$('#pwd-chk-output').text('비밀번호 일치!').addClass('success');
			}
			
			else{
				$('#pwd-chk-output').empty().removeClass('success');
				$('#pwd-chk-output').text('비밀번호가 일치하지 않습니다.').addClass('focus');
			}
		});
		
		//이름
		$('#name').focusout(function() {
			var text = $(this).val();
			
			if(text.length == 0)
				$('#name-output').text('필수 정보입니다.').addClass('focus');
			else
				$('#name-output').empty().removeClass('focus');
		});
		
		//성별 체크
		$('input[type=radio][name=gender]').on('click', function() {
			var gender = $(':input[type=radio][name=gender]:checked').val();
			
			if(gender == 'male') {
				$('#male').addClass('chg');
				$('#female').removeClass('chg');
			}
			
			else {
				$('#male').removeClass('chg');
				$('#female').addClass('chg');
			}
		}); 
		
		//휴대폰
		$('#input-tel').focusout(function() {
			var text = $(this).val();
			
			if(text.length == 0)
				$('#tel-output').text('필수 정보입니다.').addClass('focus');
			else 
				$('#tel-output').empty().removeClass('focus');
		});
		
		for(var m=0; m<13; m++){
			var option = '';
			
			if(m==0)
				option = $('<option> 월 </option>');
			else
				option = $('<option value="' + m + '">' + m + '월' + '</option>');
			
			$('#month').append(option);
		}
		
		var array = ['그리스 +30', '노르웨이 +47', '대한민국 +82', '마카오 +853', '불가리아 +359', '싱가포르 +65', '우크라이나 +380', '칠레 +56', '피지 +679'];
		
		for(var r=0; r<array.length; r++) {
			var option = $('<option>' + array[r] + '</option>');
			$('#region').append(option);
		}
		
		//인증번호 입력 활성화
		$('#rev-code').on('click', function() {
			$('#input-code').prop('disabled', false);
			$('#input-code-wrap').css('background-color', 'white');
		});
		
		//가입하기
		$('#signup').click(function() {
			var id = $('#id').val();
			var pwd = $('#pwd').val();
			var pwd_chk = $('#pwd-chk').val();
			var name = $('#name').val();
			var gender = $(':input[type=radio][name=gender]:checked').val();
			var phone = $('#input-tel').val();		
			
			if(id.length == 0)
				$('#id-output').text('필수 정보입니다.').addClass('focus');
			
			if(pwd.length == 0)
				$('#pwd-output').text('필수 정보입니다.').addClass('focus');
			
 			if(pwd_chk.length == 0)
 				$('#pwd-chk-output').text('필수 정보입니다.').addClass('focus');
 			
 			if(name.length == 0)
				$('#name-output').text('필수 정보입니다.').addClass('focus');
 			
 			if(gender.length == 0)
				$('#gender-output').text('필수 정보입니다.').addClass('focus');
 			
 			if(phone.length == 0)
				$('#tel-output').text('필수 정보입니다.').addClass('focus');
 			
			else
				$('#registerForm').submit();
		});
	});
</script>
</body>
</html>