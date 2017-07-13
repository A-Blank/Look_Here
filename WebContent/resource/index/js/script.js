/**
 * 加入购物车
 */
function buy(productid){
	$.post("user/buy.action", {productId:productid}, function(data){
		if(data=="ok"){
			location.reload();
		}else{
			alert("请求失败!");
		}
	});
}
/**
 * 购物车减去
 */
function lessen(productid){
	$.post("lessen.action", {productid:productid}, function(data){
		if(data=="ok"){
			location.reload();
		}else if(data=="login"){
			alert("请登录后操作!");
			location.href="login.jsp";
		}else{
			alert("请求失败!");
		}
	});
}
/**
 * 购物车删除
 */
function deletes(productid){
	$.post("delete.action", {productid:productid}, function(data){
		if(data=="ok"){
			location.reload();
		}else if(data=="login"){
			alert("请登录后操作!");
			location.href="login.jsp";
		}else{
			alert("请求失败!");
		}
	});
}