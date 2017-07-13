<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${ pageContext.request.contextPath }/index/css/style.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="${ pageContext.request.contextPath }/index/css/slider.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="${ pageContext.request.contextPath }/index/css/menu.css"
	rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript"
	src="${ pageContext.request.contextPath }/index/js/jquery.min.js"></script>
<script type="text/javascript"
	src="${ pageContext.request.contextPath }/index/js/script.js"></script>
<script type="text/javascript"
	src="${ pageContext.request.contextPath }/index/js/nav.js"></script>
<script type="text/javascript"
	src="${ pageContext.request.contextPath }/index/js/easing.js"></script>
<script type="text/javascript"
	src="${ pageContext.request.contextPath }/index/js/nav-hover.js"></script>
<script type="text/javascript">
	$(document).ready(function($) {
		$('#dc_mega-menu-orange').dcMegaMenu({
			rowItems : '4',
			speed : 'fast',
			effect : 'fade'
		});
	});
</script>
</head>
<body>
	<div class="header">
		<div class="header_top">
			<div class="logo">
				<a href="${pageContext.request.contextPath }/index.action"><img
					src="${pageContext.request.contextPath }/index/images/logo.png"
					alt="" /></a>
			</div>
			<div class="header_top_right">
				<div class="search_box">
					<form action="search.action" method="post">
						<input type="text" name="search" value="${search}"
							placeholder="输入要搜索内容..."> <input type="submit" value="搜索">
					</form>
				</div>
				<div class="shopping_cart">
					<div class="cart">
						<a href="${pageContext.request.contextPath }/user/cart.action" title="查看购物车" rel="nofollow"> <strong 
							class="opencart"> </strong> <span class="cart_title">购物车</span> <span
							class="no_product">(${indent.amount==null ? 0 :indent.amount})</span>
						</a>
					</div>
				</div>

				<div class="login">
					<span> <c:if test="${sessionScope.user==null}">
							<a href="login.jsp"><img
								src="${pageContext.request.contextPath }/index/images/login.png"
								alt="" title="" /></a>
							<a href="${pageContext.request.contextPath }/user/login.action">点击登录</a>
						</c:if> <c:if test="${sessionScope.user!=null}">
							<a href="my.action"><img
								src="${pageContext.request.contextPath }/index/images/login.png"
								alt="" title="" />&nbsp;${sessionScope.user.name}</a>
							<a href="${pageContext.request.contextPath }/user/logout.action" style="float: right;">注销</a>
						</c:if>
					</span>
				</div>
				<div class="clear"></div>
			</div>
			<div class="clear"></div>
		</div>


		<div class="menu">
			<ul id="dc_mega-menu-orange" class="dc_mm-orange">
				<li><a href="${pageContext.request.contextPath }/index.action">商城首页</a></li>
				<li><a>商品分类</a>
					<ul>
						<c:forEach items="${ categories }" var="category">
							<li><a href="${ pageContext.request.contextPath }/categoryProducts.action?categoryName=${ category.name  }">${ category.name }</a></li>
						</c:forEach>
					</ul></li>
				<li><a href="${pageContext.request.contextPath }/index.action">热销推荐</a></li>
				<li><a href="${pageContext.request.contextPath }/index.action">特价促销</a></li>
				<li><a href="${pageContext.request.contextPath }/index.action">最新上架</a></li>
				<c:if test="${sessionScope.user!=null}">
					<li><a href="${pageContext.request.contextPath }/user/indent.action">我的订单</a></li>
				</c:if>
				<div class="clear"></div>
			</ul>
		</div>
	</div>

</body>
</html>