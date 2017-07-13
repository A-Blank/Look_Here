<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	
	<form action="${pageContext.request.contextPath}/admin/doProductUpdate.action" method="post" enctype="multipart/form-data">

		<input type="hidden" name="page" value="${param.page}"/>
		
		<input type="hidden" name="id" value="${product.id}"/>
		<input type="hidden" name="cover" value="${product.cover}"/>

		封面：<img src="${pageContext.request.contextPath}/${product.cover}" width="100px" height="150px">
		<br>
		修改: <input type="file" name="files" size="12"/><br>
		书名：<input type="text" name="name" value="${product.name}"/><br>
		价格：<input type="text" name="price" value="${product.price}"/><br>
		介绍：<input type="text" name="introduce" value="${product.introduce}"/><br>
		分类：<select name="category">
						<c:forEach items="${categories}" var="category">
							<option value="${category.name}" <c:if test="${product.category==category.name}">selected="selected"</c:if>>${category.name}</option>
						</c:forEach>
				   </select>
		
		<input type="submit" value="修改"/>
		
	</form>
	
</body>
</html>
