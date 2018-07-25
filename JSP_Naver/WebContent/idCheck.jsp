<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="service.GetMemberListService" %>
<%@ page import="model.MemberInfo" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%
	GetMemberListService getMemberListService = GetMemberListService.getInsatnce();
	int dataCnt = getMemberListService.getList(request.getParameter("id"));
	
	if(dataCnt > 0)
		out.print(dataCnt);
	else
		out.print(dataCnt);	
%>