<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="service.EditService" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="boardInfo" class="model.BoardInfo" />
<jsp:setProperty name="boardInfo" property="*" />
<%
	EditService editService = EditService.getInstance();
	editService.edit(boardInfo.getBoard_id(), boardInfo.getTitle(), boardInfo.getContent());
	response.sendRedirect("/Naver/mypage.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>