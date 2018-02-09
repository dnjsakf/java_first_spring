<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ page import="DTO.BBS_dto" %>
<%@ page import="java.util.ArrayList" %>

<% response.setCharacterEncoding("EUC-KR"); %>
<%
	ArrayList<BBS_dto> btos = (ArrayList<BBS_dto>) request.getAttribute("list");
	boolean hasNextPage = false;
	if( request.getParameter("hasNextPage") != null ){
		hasNextPage = true;
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
			<% for( int i = 0 ; i < btos.size(); i++ ){ %>
			<tr>
				<td><%=btos.get(i).getBbsID()%></td>
				<td><%=btos.get(i).getBbsTitle()%></td>
				<td><%=btos.get(i).getUserID()%></td>
				<td><%=btos.get(i).getBbsDate()%></td>
			</tr>
			<% } %>
		</tbody>
	</table>
	<div class="table-remote">
		<div><a href="/bbs/list">목록</a></div>
		<a><%= %></a>
		<!-- 
		<div>
			<a href="/bbs/list?page=1">1</a>
			<a href="/bbs/list?page=2">2</a>
			<a href="/bbs/list?page=3">3</a>
			<a href="/bbs/list?page=1">1</a>
		</div>
		 -->
		<div><a href="/bbs/write">글쓰기</a></div>
	</div>
	<a>List size <%= btos.size() %></a>
</body>
</html>