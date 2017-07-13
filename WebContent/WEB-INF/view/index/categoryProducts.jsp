<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品列表</title>
</head>
<body>

<div class="wrap">

	<c:import url="/header.action"/>

	<div class="main">
		<div class="content">
		
			<div class="content_top">
			
				<div class="heading">
					<h3>
						<c:if test="${categoryProducts!=null}">${ categoryName }</c:if>
						<c:if test="${categoryProducts==null}">全部商品</c:if>
					</h3>
				</div>
				
				<div class="page-no">${pageTool}</div>
				
				<div class="clear"></div>
			</div>
			
			<div class="section group">
			
				<c:forEach items="${categoryProducts}" var="product" varStatus="stauts">
					<div class="listview_1_of_2 images_1_of_2" <c:if test="${status.count%4==1}">style="margin-left: 0;"</c:if>>
						<div class="listimg listimg_2_of_1">
							 <a href="detail.action?productid=${ product.id }">
								<img src="${ pageContext.request.contextPath }/${ product.cover }" alt="${ product.name }"/>
							</a>
						</div>
						<div class="text list_2_of_1">
							<h3><a href="detail.action?productid=${ product.id }">${ product.name }</a></h3>
						<!-- 	<p><s:property value="showtext"/></p> -->
							<p><span style="color:red;">${ product.price }</span></p>
							<div class="button">
								<span><a href="javascript:buy(${ product.id });">加入购物车</a></span>
							</div>
					   </div>
				   </div>	
				</c:forEach>
				
				<div class="clear"></div>
				
			</div>
			
    	</div>
    	
	</div>

<jsp:include page="footer.jsp"/>

</div>

</body>
</html>