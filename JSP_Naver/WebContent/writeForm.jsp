<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.MemberInfo" %>
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
		height: 400px;
		
		margin: 0 auto;
	}
	
	#content_wrap {
		margin-top: 30px;
		margin-left: 10px;
		margin-right: 10px;
	}
	
	.titlebox {
		height: 50px;
		
		margin-top: 10px;
		
		border: 1px solid #bfbfbf;
		
		background-color: white;
	}
	
	.contentbox {
		height: 250px;
		
		margin-top: 10px;
		
		border: 1px solid #bfbfbf;
		
		background-color: white;
	}
	
	input[type=text] {
		width: 450px;
		height: 30px;
		
		margin: 10px;
		
		background-color:transparent;
		border: none;
    }
    
    textarea {
		width: 450px;
		
		margin: 10px;
		
		background-color:transparent;
		border: none;
    }
	
	input[type=submit], input[type=reset] {
		margin-top: 30px;
		margin-bottom: 100px;
		margin-left: 5px;
		
		width: 230px;
		height: 50px;
		
		font-size: 20px;
		border: none;
		
		color: white;
		background-color: #4CAF50;
	}
	
	#space1 {
		margin: 50px;
	}
	
	#space2 {
		margin: 100px;
	}
</style>
</head>
</head>
<body>
	<div id="container">
		<jsp:include page="header2.jsp" />
		
		<div id="space1"></div>
		
		<div id="content">
			<div id="content_wrap">
				<form action="/Naver/write.jsp" id="writeForm" method="post">
					<div class="titlebox">
						<input type="text" id="title" name="title" placeholder="제목">
						<%
							MemberInfo memberInfo = (MemberInfo)session.getAttribute("memberInfo");
						%>
						<input type="hidden" name="writer_id" value="<%= memberInfo.getId() %>">
					</div>
					
					<div id="id-output"></div>
					
					<div class="contentbox">
						<textarea name="content" cols="100" rows="15"></textarea>
					</div>
					
					<input type="submit" value="등록">
					<input type="reset" value="취소" id="reset">
				</form>
			</div>
		</div>
		
		<div id="space2"></div>
		
		<jsp:include page="footer.jsp" />
	</div>
	
<script>
	$(document).ready(function() {
		$('#reset').click(function() {
			location.href = '/Naver/mypage.jsp';
		})
	});
</script>
</body>
</html>