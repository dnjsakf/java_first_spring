<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/general.css"/></head>
<body>
	<jsp:include page="./contents/frame/main_header.jsp"/>
	<section id="main_section">
		<section id="left_section">
			<a>ī�װ�</a>
			<ul>
				<li><a href="./main">����</a>
				<li><a href="./bbs/list">�Խ���</a></li>
				<li><a href="./notice">��������</a></li>
			</ul>
		</section>
		<section id="right_section">
			<a>Viewer</a>
		</section>
	</section>
	<footer id="main_footer">
		<h1>Footer</h1>
	</footer>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="./js/ajax.js"></script>
</body>
</html>