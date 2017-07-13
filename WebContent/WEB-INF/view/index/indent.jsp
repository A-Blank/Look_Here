<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的订单</title>
</head>
<body>

<div class="wrap">

<jsp:include page="header.jsp"/>

<div class="main">
    <div class="content">
    	<div class="login_panel"  style="width:600px">	
        	<!-- <s:actionmessage/> -->
        	
        	<c:if test="${indents != null}">
        	
				<h3>我的订单</h3>
        		<c:forEach items="${indents}" var="indent">
        		
					<table class="cart_table">
					
						<tr>
		          			<td>
			          			订单号: ${indent.id}
			          			<c:if test="${indent.status==1}">(未发货)</c:if>
			          			<c:if test="${indent.status==2}">(已发货)</c:if>
		          			</td>
		          			<td colspan="2">下单时间: <fmt:formatDate value="${indent.systime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
				            <td class="cart_total"><span class="red">总价: </span></td>
				            <td>${ indent.total }</td>
		          		</tr>
		          		
						<c:forEach items="${indent.items}" var="item">
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
							</tr>			
						</c:forEach>
						
		          		
		        	</table><br>
	        	
	        	</c:forEach>
        	
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