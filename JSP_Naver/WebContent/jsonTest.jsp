<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@ page import="model.MemberInfo" %>
<%@ page import="service.BoardListView" %>
<%@ page import="service.GetMemberListService" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%
	GetMemberListService getMemberListService = GetMemberListService.getInsatnce();
	List<MemberInfo> memberList = getMemberListService.getList();
%>[
<%
	for(MemberInfo member : memberList) {
%>	{
    		"memberId" : "<%= member.getId() %>",
    		"memberPassword" : "<%= member.getPassword() %>",
		"memberName" : "<%= member.getName() %>",
		"memberBirthdate" : "<%= member.getYear() + "-" + member.getMonth() + "-" + member.getDay() %>",
		"memberGender" : "<%= member.getGender() %>",
		"memberEmail" : "<%= member.getEmail() %>",
		"memberPhone" : "<%= member.getPhone() %>",
		"memberPhoto" : "<%= member.getPhoto() %>"
	}, 
<%
	}
%>]