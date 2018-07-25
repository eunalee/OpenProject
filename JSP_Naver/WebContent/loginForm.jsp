<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<style>
	body {
		background-color: #f2f2f2;
	}
	
	#container {
		width: 500px;
		
		margin: 0 auto;
	}

	#content {
		width: 500px;
		height: 400px;
		
		margin: 0 auto;
	}
	
	#content_wrap {
		margin-top: 30px;
		margin-left: 10px;
		margin-right: 10px;
	}
	
	#chk_wrap {
		margin-top: 20px;
		margin-left: 10px;
		margin-right: 10px;
		
		font-size: 13px;
	}
	
	.box {
		height: 50px;
		
		margin-top: 10px;
		
		border: 1px solid #bfbfbf;
		
		background-color: white;
	}
	
	.warning {
		color: red;
		font-size: 14px;
	}
	
	input[type=text], input[type=password] {
		width: 450px;
		height: 30px;
		
		margin: 10px;
		
		background-color:transparent;
		border: none;
    }
	
	input[type=button] {
		margin-top: 30px;
		width: 480px;
		height: 50px;
		
		font-size: 20px;
		border: none;
		
		color: white;
		background-color: #4CAF50;
	}
	
	#line {
		border-top: 1px solid #bfbfbf;
		
		margin-top: 30px;
		margin-left: 10px;
		margin-right: 10px;
	}
	
	#info_wrap {
		text-align: center;
		margin-right: 90px;
		margin-left: 90px;
	}
	
	.info_a {
		font-size: 13px;
		
		text-decoration: none;
	}
	
	.info_a:hover {
		text-decoration: underline;
	}
</style>
</head>
<body>
	<div id="container">
		<jsp:include page="header.jsp" />
		
		<div id="content">
			<div id="content_wrap">
				<form action="/Naver/loginAccess.jsp" id="loginForm" method="post">
					<div class="box">
					<%
						String id = "";
						Cookie[] cookies = request.getCookies();
						
						if(cookies != null && cookies.length > 0) {
							for(int i=0; i<cookies.length; i++) {
								if(cookies[i].getName().equals("id"))
									id = cookies[i].getValue();
							}
						}
					%>
					<input type="text" id="id" name="id" value="<%= id %>" placeholder="아이디">
					</div>
					
					<div id="id-output"></div>
					
					<div class="box">
						<input type="password" id="pwd" name="password" placeholder="비밀번호">
					</div>
					
					<div id="pwd-output"></div>
					<div id="login-output"></div>
					
					<input type="button" value="로그인" id="login">
				</form>
			</div>
			
			<div id="chk_wrap">
				<input type="checkbox" id="save-id">아이디 저장
				<a href="#" style="float: right; color: black;">일회용 로그인</a>
			</div>
			
			<div id="line"></div>
			
			<ul id="info_wrap">
				<li><a href="" class="info_a">아이디 찾기</a></li>
				<li><a href="" class="info_a">비밀번호 찾기</a></li>
				<li><a href="/Naver/registerForm.jsp" class="info_a">회원가입</a></li>
			</ul>
		</div>
		
		<jsp:include page="footer.jsp" />
	</div>
</body>
<script>
	$(document).ready(function() {
		$('#login').click(function() {
			$('#id-output').empty().removeClass('.warning');
			$('#pwd-output').empty().removeClass('.warning');
			$('#login-output').empty().removeClass('.warning');
			
			var id = $('#id').val();
			var pwd = $('#pwd').val();
			
			if(id.length == 0)
				$('#id-output').text('아이디를 입력해주세요.').addClass('warning');
			
			else if(pwd.length == 0)
				$('#pwd-output').text('비밀번호를 입력해주세요.').addClass('warning');
			
			else {
				if($('#save-id').is(':checked'))
					$.cookie('id', id);
				
				$('#loginForm').submit();
			}
		});
	});
</script>
</html>