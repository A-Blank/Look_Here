<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

	<form action="${pageContext.request.contextPath}/admin/doProductAdd.action" method="post" enctype="multipart/form-data">

		封面：<input type="file" name="files" size="12"/><br>
		名称：<input type="text" name="name"/><br>
		价格：<input type="text" name="price"/><br>
		介绍：<input type="text" name="intro"/><br>
		分类：<select name="category">
						<c:forEach items="${categories}" var="category">
							<option value="${category.name}">${category.name}</option>
						</c:forEach>
				   </select>
		<input type="submit" value="添加"/>
		
	</form>
	
</body>
</html>
