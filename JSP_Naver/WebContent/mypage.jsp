<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@ page import="model.MemberInfo" %>
<%@ page import="model.BoardInfo" %>
<%@ page import="service.BoardListView" %>
<%@ page import="service.GetMemberListService" %>
<%@ page import="service.GetBoardListService" %>
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
	
	a {
		text-decoration: none;
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
	
	#memberInfo {
		border-collapse: collapse;
		width: 100%;
    }
    
    #memberInfo tr, #memberInfo td {
    	padding: 8px;
    	text-align: center;
    	border-bottom: 1px solid #ddd;
    }
    
    #memberInfo tr:first-Child {
    	font-weight: bold;
    }
    
    #memberInfo tr:hover {
    	background-color:#f5f5f5;
    }
    
    #boardInfo {
		border-collapse: collapse;
		width: 100%;
    }
    
    #boardInfo tr, #boardInfo td {
    	padding: 8px;
    	text-align: center;
    	border-bottom: 1px solid #ddd;
    }
    
    #boardInfo tr:first-Child {
    	font-weight: bold;
    }
    
    #boardInfo tr:hover {
    	background-color:#f5f5f5;
    }
    
    .sty {
    	color: black;
    }
    
    input[type=button] {
		margin-top: 30px;
		margin-left: 5px;
		
		width: 480px;
		height: 50px;
		
		font-size: 20px;
		border: none;
		
		color: white;
		background-color: #4CAF50;
	}
    
    #home-wrap {
    	margin: 50px;
    	
    	text-align: center;
    }
    
    #home-wrap a {
		font-weight: bold;
		font-size: 24px;
		
		color: #4CAF50;
    }
    
    #paging {  
    	list-style: none;  
    	float: left;  
    	display: inline; 
    	
    	padding-left: 200px; 
	}
	
	#paging li {  
    	float: left;  
	}
	
	#paging li a {  
		width:15px; 
	
    	float: left; 
    	 
    	padding: 4px;  
    	margin-right: 3px; 
    	 
    	font-weight: bold;  
    	
    	color: black;
    	
    	border: 1px solid #ddd;
    	
    	text-align: center;  
    	text-decoration: none;  
	}  
	
	#paging li a:hover, #paging li a:focus {  
    	color: white;
    	background-color: #4CAF50;  
	}  
    
    #space1 {
		margin: 50px;
	}
	
	#space2 {
		margin: 180%;
	}
</style>
</head>
<body>
	<div id="container">
		<jsp:include page="header2.jsp" />
		
		<div id="content">
			<div id="content_wrap">
			<h3>나의 정보</h3>
 			<table id="memberInfo">
			<%			
				MemberInfo memberInfo = (MemberInfo)session.getAttribute("memberInfo");
			
				if(memberInfo != null) {
					GetMemberListService getMemberListService = GetMemberListService.getInsatnce();
					MemberInfo member = getMemberListService.getList(memberInfo.getId(), memberInfo.getPassword());
			%> 
				<tr>
					<td colspan="4"><img src="file/photo/<%= member.getPhoto() %>" alt="사진" width="100%"/></td>
				</tr>
				<tr>
					<td>이름</td><td>생년월일</td><td>이메일</td><td>전화번호</td>
				</tr>
				<tr>
					<td><%= member.getName() %></td><td><%= member.getYear() + "-" + member.getMonth() + "-" + member.getDay() %></td><td><%= member.getEmail() %></td><td><%= member.getPhone() %></td>
				</tr>
			</table>
			
			<div id="space1"></div>
			
			<h3>내가 쓴 글 목록</h3>
			
			<table id="boardInfo">
				<tr>
					<td>No</td><td>제목</td><td>작성일</td><td>관리</td>
				</tr>
			<%
				String pageNumStr = request.getParameter("page");
			
				int pageNum = 1;
			
				if(pageNumStr != null)
					pageNum = Integer.parseInt(pageNumStr);
			
				GetBoardListService getBoardListService = GetBoardListService.getInstance();
				BoardListView viewData = getBoardListService.getList(memberInfo.getId(), pageNum);
				
				if(viewData.isEmpty()) {
			%>
				<tr>
					<td colspan="4">작성된 글이 없습니다.</td>
				</tr>
			<%
				}
				else {
					int no = (pageNum-1) *5 + 1;
					
					for(BoardInfo boardInfo : viewData.getBoardList()) {
			%>	
					<tr>
						<td><%= no %></td><td><%= boardInfo.getTitle() %></td><td><%= boardInfo.getWritedate() %></td><td><a href="/Naver/editForm.jsp?board_id=<%= boardInfo.getBoard_id() %>" class="sty">확인</a> / <a href="/Naver/delete.jsp?board_id=<%= boardInfo.getBoard_id() %>" class="sty">삭제</a></td>
					</tr>
			<%
					}
					no++;
				}
			%>
			</table>
			
			<ul id="paging">
				<%
					for(int i=1; i<= viewData.getPageTotalCount(); i++) {
				%>
					<li><a href="mypage.jsp?page=<%= i %>"><%= i %></a></li>
				<%
					}
				%>
			</ul>
			<%
				}
				else {
					response.sendRedirect("/Naver/loginForm.jsp");
				}
			%>
			
			<input type="button" value="글쓰기" id="write">
			
			<div id="home-wrap">
				<a href="/Naver/index.jsp">HOME</a>
			</div>
			</div>
		</div>
		
		<div id="space2"></div>
		
		<jsp:include page="footer.jsp" />
	</div>
<script>
	$(document).ready(function() {
		$('#write').click(function() {
			location.href = "/Naver/writeForm.jsp";
		});
	});
</script>
</body>
</html>