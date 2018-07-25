<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="service.WriteService" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="boardInfo" class="model.BoardInfo" />
<jsp:setProperty name="boardInfo" property="*" />
<%
	WriteService writeService = WriteService.getInstance();
	writeService.write(boardInfo);
	response.sendRedirect("/Naver/mypage.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
</head>
<body>

</body>
</html>