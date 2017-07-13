package com.ssh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssh.entity.Category;
import com.ssh.entity.Product;
import com.ssh.service.ProductService;

@Controller
public class IndexController {

	
	@Autowired private ProductService productService; 
	
	@RequestMapping(value="/index")
	public String index(Model model){
		List<Product> products=productService.getProducts();
		model.addAttribute("products",products);
		return "/index/index";
	}
	
	@RequestMapping(value="/header")
	public String header(Model model){
		List<Category> categories=productService.getCategory();
		model.addAttribute("categories", categories);
		return "/index/header";
	}
	
	@RequestMapping(value="categoryProducts")
	public String getProductsByCategory(String categoryName,Model model){
		List<Product> products=productService.findProductByCategory(categoryName);
		model.addAttribute("categoryProducts", products);
		model.addAttribute("categoryName",categoryName);
		return "/index/categoryProducts";
	}
	
}
