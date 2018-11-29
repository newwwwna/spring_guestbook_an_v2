<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>LOGINFORM</title>
</head>
<body>

<table border='1px' cellspacing='1' cellpadding='2px' width='200'>
<form action="login.do" method="post">
<tr>
<td>ID</td> <td><input type="text" name="id"></td>
</tr>
<tr>
<td>PW</td> <td><input type="password" name="pw"></td>
</tr>
<tr> <td colspan=2 align=right><input type="submit" value="login"></td></tr>
</form>
</table>
</body>
</html>