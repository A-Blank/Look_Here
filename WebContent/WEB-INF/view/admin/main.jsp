<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商城后台管理</title>
</head>
<frameset rows="52,*,23" frameborder="no" border="0" framespacing="0">
  <frame src="${pageContext.request.contextPath}/admin/top.action" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" />
  <frame src="${pageContext.request.contextPath}/admin/center.action" name="centerFrame" id="mainFrame" />
  <frame src="${pageContext.request.contextPath}/admin/down.action" name="downFrame" scrolling="No" noresize="noresize" id="bottomFrame" />
</frameset>
<noframes>
<body>
</body>
</noframes>
</html>