<%@page import="com.javalec.guestbook.vo.GuestBookVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SelectOne</title>
</head>
<body>
<a href="getguestbooklist.do"><img src=gb2.png></a>
	<%
		GuestBookVO vo = (GuestBookVO) request.getAttribute("vo");
		request.getParameter("no");
	%>

	<table border='1px' cellspacing='1' cellpadding='2px' width='500' style="text-align:center">
		<tr>
			<td>[<%=vo.getNo()%>]
			</td>
			<td><%=vo.getName()%></td>
			<td><%=vo.getReg_date()%></td>

			<th><form action="deleteform.do" method="post">
					<input type="submit" value="삭제">
				</form></th>

			<th><form action="updatecon.jsp" method="post">
					<input type="submit" value="수정">
				</form></th>
		</tr>

		<tr>
			<td colspan="5"><%=vo.getContent()%></td>

		</tr>
	</table>
	<br />

 <a href ="getguestbooklist.do"> 메인으로 돌아가기</a>


</body>
</html>