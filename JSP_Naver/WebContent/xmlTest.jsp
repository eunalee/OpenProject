<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@ page import="model.MemberInfo" %>
<%@ page import="service.BoardListView" %>
<%@ page import="service.GetMemberListService" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%
	GetMemberListService getMemberListService = GetMemberListService.getInsatnce();
	List<MemberInfo> memberList = getMemberListService.getList();
%>
<?xml version="1.0" encoding="UTF-8"?>
<members>
	<%
		for(MemberInfo member : memberList) {
	%>
		<member>
			<memberId><%= member.getId() %></memberId>
			<memberPassword><%= member.getPassword() %></memberPassword>
			<memberName><%= member.getName() %></memberName>
			<memberBirthdate><%= member.getYear() + "-" + member.getMonth() + "-" + member.getDay() %></memberBirthdate>
			<memberGender><%= member.getGender() %></memberGender>
			<memberEmail><%= member.getEmail() %></memberEmail>
			<memberPhone><%= member.getPhone() %></memberPhone>
			<memberPhoto><%= member.getPhoto() %></memberPhoto>
		</member>
	<%
		}
	%>
</members>