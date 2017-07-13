<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商城首页</title>
</head>
<body>

	<div class="wrap">
		<c:import url="/header.action"/>
		<%-- <jsp:include page="header.jsp" /> --%>

		<div class="main">
			<div class="content">

				<div class="content_top">
					<div class="heading">
						<h3>热销推荐</h3>
					</div>
					<div class="clear"></div>
				</div>

				<div class="section group">

					<c:forEach var="p" items="${ products }" varStatus="status">
						<div class="listview_1_of_2 images_1_of_2"
							<c:if test="${status.count%4==1}">style="margin-left: 0;"</c:if>>
							<div class="listimg listimg_2_of_1">
								<a href="detail.action?productid=${ p.id }"> <img
									src="./${p.cover}" alt="" /></a>
							</div>
							<div class="text list_2_of_1">
								<h3>
									<a href="detail.action?productid=${ p.id }">${p.name}</a>
								</h3>
								<p>
									<span style="color: red;">${p.price}</span>
								</p>
								<div class="button">
									<span><a href="javascript:buy(${p.id});">加入购物车</a></span>
								</div>
							</div>
						</div>

					</c:forEach>
				</div>
			</div>
		</div>

	</div>
	<jsp:include page="footer.jsp" />

</body>
</html>