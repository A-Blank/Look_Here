<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${ pageContext.request.contextPath }/user/doLogin" method="post">
		<li>用户名</li>
		<li><input type="text" name="username"></li>
		<li>密码</li>
		<li><input type="password" name="password"></li>
		<li><input type="submit" value="登录"></li>
</form>
</body>
</html>