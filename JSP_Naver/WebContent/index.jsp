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
	
	#container {
		width: 500px;
		
		margin: 0 auto;
	}
	
	#content {
		width: 500px;
		height: 300px;
		
		margin: 0 auto;
	}
	
	#content_wrap {
		margin-top: 50px;
		margin-left: 10px;
		margin-right: 10px;
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
</style>
</head>
<body>
	<div id="container">
		<jsp:include page="header.jsp" />
		
		<div id="content">
			<div id="content_wrap">
				<form>	
				<%
					if(session.getAttribute("memberInfo") != null) {
				%>
					<input type="button" value="로그아웃" id="logout">
				<%
					}
					else {
				%>
					<input type="button" value="로그인" id="login">
				<%
					}
				%>
					<input type="button" value="마이페이지" id="mypage">
				</form>
			</div>
		</div>
		
		<jsp:include page="footer.jsp" />
	</div>
</body>
<script>
	$(document).ready(function() {
		$('#login').click(function() {
			location.href = "/Naver/loginForm.jsp";
		});
		
		$('#logout').click(function() {
			location.href = "/Naver/logout.jsp";
		});
		
		$('#mypage').click(function() {
			location.href = "/Naver/mypage.jsp?";
		});
	});
</script>
</html>