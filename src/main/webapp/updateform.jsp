<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UPDATE FORM</title>
</head>
<body>
<a href="getguestbooklist.do"><img src=gb2.png></a>
<%String no = request.getParameter("no");%>
<%String name = request.getParameter("name");%>
<%String password = request.getParameter("password");%>
<%String content = request.getParameter("content");%>

<form action="update.do" method="post">

	<table border='1px' cellspacing='1' cellpadding='2px'>
		<tr>
			<td> 이름 </td> <td><input type="text" name="name" value="<%=name%>"></td>
			<td> 비밀번호 </td> <td><input type = "text" name="password" value="<%=password%>"></td>
		</tr>
		<tr>
			<td colspan="4">
			<textarea name = "content" rows="10" cols="50"><%=content %></textarea>	
			
			</td>
		</tr>
		<tr>
			<td colspan="4" align=right>
			<input type="submit" value="수정">
			
		</td>
		</tr>
	</table> <br/>
</form>

</body>
</html>