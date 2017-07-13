package com.ssh.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.entity.Indent;
import com.ssh.entity.Item;
import com.ssh.entity.Product;
import com.ssh.entity.User;
import com.ssh.service.IndentService;
import com.ssh.service.ProductService;
import com.ssh.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {

	@Autowired private UserService userService;
	@Autowired private ProductService productService;
	@Autowired private IndentService indentService;
	
	/**
	 * 登录界面
	 */
	@RequestMapping(value="/login")
	public String login(){
		return "/index/login";
	}
	
	/**
	 * 登录
	 */
	@RequestMapping(value="/doLogin")
	public String doLogin(User user,HttpSession httpSession){
		User existUser=userService.login(user);
		if(existUser!=null){
			httpSession.setAttribute("user", existUser);
			return "redirect:/index.action";
		}
		return "redirect:/login";
	}
	
	/**
	 * 注销
	 */
	@RequestMapping(value="logout")
	public String logout(HttpSession httpSession){
		httpSession.removeAttribute("user");
		return "redirect:/index.action";
	}
	
	/*
	 * 注册界面
	 */
	@RequestMapping(value="/register")
	public String register(){
		return "/index/register";
	}
	
	/*
	 * 注册
	 */
	@RequestMapping(value="/doRegister")
	public String doRegister(User user,Model model){
		System.out.println(user.getName());
		if(user.getName().equals("")||user.getPassword().equals("")||user.getPhone().equals("")){
			model.addAttribute("message", "用户信息未填写完善");
			return "/index/register";
		}
		if(!userService.register(user)){
			model.addAttribute("message", "注册失败");
			return "/index/register";
		}
		return "/index/login";
	}
	
	/*
	 * 
	 */
	@RequestMapping(value="/addUser")
	public void addUser(User user){
		userService.addUser(user);
	}
	
	public void updateUser(User user){
		userService.updateUser(user);
	}
	
	@RequestMapping(value="/getUsers")
	public List<User> getUsers(){
		System.out.println("hello world");
		return userService.getUsers();
	}
	
	public User getUserById(String id){
		return userService.getUserById(id);
	}
	
	/*
	 * 加入购物车
	 */
	@RequestMapping(value="buy")
	@ResponseBody
	public String buy(int productId,HttpSession httpSession){
		System.out.println("ProductId"+productId);
		Product product=productService.findProductById(productId);
		Indent indent = (Indent) httpSession.getAttribute("indent");
		if (indent==null) {
			httpSession.setAttribute("indent", indentService.createIndent(product));
		}else {
			indentService.addItem(indent, product);
		}
		return "ok";
	}
	
	/*
	 * 查看购物车
	 */
	@RequestMapping(value="cart")
	public String cart() {
		System.out.println("cart");
		return "/index/cart";
	}
	
	/*
	 * 提交订单
	 */
	@RequestMapping(value="indentSubmit")
	public String indentSubmit(HttpSession httpSession,Model model){
		User user=(User) httpSession.getAttribute("user");
		Indent indent=(Indent) httpSession.getAttribute("indent");
		if(user==null){
			model.addAttribute("message", "请登录后再提交订单");
			return "/index/login";
		}else if(indent!=null){
			indent.setUser(user);
			indentService.saveIndent(indent);
			httpSession.removeAttribute("indent");
			model.addAttribute("message", "订单提交成功");
		}else{
			model.addAttribute("message", "当前暂无订单");
		}
		return "/index/cart";
	}
	
	/*
	 * 查看订单
	 */
	@RequestMapping(value="indent")
	public String indent(HttpSession httpSession, Model model){
		String userId=((User)httpSession.getAttribute("user")).getId();
		List<Indent> indents=indentService.findIndentsByUserId(userId);
		for (Indent indent : indents) {
			int id=indent.getId();
			List<Item> items=indentService.findItemsByIndentID(id);
			indent.setItems(items);
			System.out.println("time="+indent.getSystime());
		}
		model.addAttribute("indents", indents);
		return "/index/indent";
	}
	
}
