<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
</head>
<body>

<div class="wrap">

<jsp:include page="header.jsp" />

<div class="main">
    <div class="content">
    	<div class="login_panel"  style="width:600px">	
    	
    		<h2 style="color: red;">${message}</h2>
        	<c:if test="${sessionScope.indent != null}">
        	
				<h3>我的购物车</h3>
				
				<table class="cart_table">
				
					<c:forEach items="${sessionScope.indent.items}" var="item">
						<tr class="cart_title">
							<td>
								<a href="detail.action?productid=${item.product.id}">
									<img src="../${item.product.cover}" class="cart_thumb" border="0"/>
								</a>
							</td>
							<td>${item.product.name}</td>
							<td>${item.product.price}</td>
							<td>x ${item.amount}</td>
							<td>${item.total}</td>
							<td>
								<a href="javascript:buy(${product.id});">[添加]</a>
								<a href="javascript:lessen(${product.id});">[减少]</a>
								<a href="javascript:deletes(${product.id});">[删除]</a>
							</td>
						</tr>			
					</c:forEach>
					
	          		<tr>
			            <td colspan="4" class="cart_total"><span class="red">总价: </span></td>
			            <td>${sessionScope.indent.total}</td>
	          		</tr>
	        	</table>
        	
	            <div class="buttons">
	            	<div style="float:right; padding-top: 20px">
	            		<button class="grey" onclick="location.href='${pageContext.request.contextPath }/user/indentSubmit.action'">提交订单</button>
	            	</div>
	            </div>
	            
            </c:if>
            
            <div class="clear"></div>
		</div>
       <div class="clear"></div>
    </div>
 </div>

<jsp:include page="footer.jsp"/>

</div>

</body>
</html>