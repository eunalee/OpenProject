<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.MemberInfo" %>
<%@ page import="service.GetMemberListService" %>
<%@ page import="service.InvalidLoginException" %>
<% request.setCharacterEncoding("UTF-8"); %> 
<jsp:useBean id="memberInfo" scope="session" class="model.MemberInfo" />
<jsp:setProperty name="memberInfo" property="*" />
<%
	boolean invalidLogin = false;
	
	try {
		GetMemberListService getMemberListService = GetMemberListService.getInsatnce();
		MemberInfo member = getMemberListService.getList(memberInfo.getId(), memberInfo.getPassword());
	} catch(InvalidLoginException e) {
		invalidLogin = true;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
	
	#info {
		border-collapse: collapse;
		width: 100%;
    }
    
    #info tr, #info td {
    	padding: 8px;
    	text-align: center;
    }
    
    #info tr:first-Child {
    	font-weight: bold;
    	
    	color: red;
    }
    
    #info td a {
    	text-decoration: none;
		
		font-weight: bold;
		font-size: 24px;
		
		color: #4CAF50;
    }
</style>
</head>
<body>
	<div id="container">
		<jsp:include page="header2.jsp" />
		
		<div id="content">
			<div id="content_wrap">
			<%
				if(!invalidLogin) {
					session.setAttribute("memberInfo", memberInfo);
					response.sendRedirect("/Naver/index.jsp");
				}
				else {
					session.invalidate();
			%>
			
			<table id="info">
				<tr>
					<td colspan="2">아이디 또는 비밀번호를 다시 확인하세요.<br>네이버에 등록되지 않은 아이디이거나, 아이디 또는 비밀번호를 잘못 입력하셨습니다.</td>
				</tr>
				
				<tr>
					<td></td><td></td>
				</tr>
				
				<tr>
					<td><a href="/Naver/loginForm.jsp">LOGIN</a></td><td><a href="/Naver/index.jsp">HOME</a></td>
				</tr>
				</table>
			</div>
			<%
				}
			%>
		</div>
		
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>