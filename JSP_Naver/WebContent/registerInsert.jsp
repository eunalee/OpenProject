<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@ page import="service.RegisterService" %>
<%
	request.setCharacterEncoding("utf-8");

	String id = "";
	String password = "";
	String name = "";	
	String year = "";
	String month = "";
	String day = "";
	String gender = "";
	String email = "";
	String phone = "";
	String photo = "";
	
	boolean isMultipart = ServletFileUpload.isMultipartContent(request);
	
	if(isMultipart) {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		List<FileItem> items = upload.parseRequest(request);
		Iterator<FileItem> iter = items.iterator();
		
		while(iter.hasNext()) {
			FileItem item = iter.next();
			
			if(item.isFormField()) {
				String data = item.getFieldName();
				
				switch(data) {
					case "id" :
						id = item.getString("utf-8");
					break;
					
					case "password" :
						password = item.getString("utf-8");
					break;
					
					case "name" :
						name = item.getString("utf-8");
					break;
					
					case "year" :
						year = item.getString("utf-8");
					break;
					
					case "month" :
						month = item.getString("utf-8");
					break;
					
					case "day" :
						day = item.getString("utf-8");
					break;
					
					case "gender" :
						gender = item.getString("utf-8");
					break;
					
					case "email" :
						email = item.getString("utf-8");
					break;
					
					default :
						phone = item.getString("utf-8");
					break;
				}
			} 
			
			else {
				String dir = request.getSession().getServletContext().getRealPath("/file/photo");
				
				item.write(new File(dir, item.getName()));
				photo = item.getName();
			}
		}
	}
%>
<jsp:useBean id="memberInfo" class="model.MemberInfo" />
<jsp:setProperty name="memberInfo" property="id" value="<%= id %>"/> 
<jsp:setProperty name="memberInfo" property="password" value="<%= password %>"/> 
<jsp:setProperty name="memberInfo" property="name" value="<%= name %>"/> 
<jsp:setProperty name="memberInfo" property="year" value="<%= year %>"/> 
<jsp:setProperty name="memberInfo" property="month" value="<%= month %>"/> 
<jsp:setProperty name="memberInfo" property="day" value="<%= day %>"/> 
<jsp:setProperty name="memberInfo" property="gender" value="<%= gender %>"/> 
<jsp:setProperty name="memberInfo" property="email" value="<%= email %>"/> 
<jsp:setProperty name="memberInfo" property="phone" value="<%= phone %>"/> 
<jsp:setProperty name="memberInfo" property="photo" value="<%= photo %>"/>
<%
	RegisterService registerService = RegisterService.getInstance();
	int insertCnt = registerService.register(memberInfo);
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
	
	a {
		text-decoration: none;
		
		color: #4CAF50;
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
	
	#registerInfo {
		border-collapse: collapse;
		width: 100%;
    }
    
    #registerInfo tr, #registerInfo td {
    	padding: 8px;
    	text-align: center;
    }
    
    #registerInfo tr:first-Child {
    	font-weight: bold;
    }
</style>
</head>
<body>
	<div id="container">
		<jsp:include page="header2.jsp" />
		
		<div id="content">
			<div id="content_wrap">
			<table id="registerInfo">
				<%
					if(insertCnt > 0) {
				%>
				<tr>
					<td>회원가입 성공!</td>
				</tr>
					
				<tr>
					<td><h3><a href="/Naver/loginForm.jsp">LOGIN</a></h3></td>
				</tr>
				
				<%
					}
					else {
				%>
				<tr>
					<td>회원가입 실패!</td>
				</tr>
					
				<tr>
					<td><h3><a href="/Naver/registerForm.jsp">SIGN UP</a></h3></td>
				</tr>
				
				<%
					}
				%>
				</table>
			</div>
		</div>
		
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>