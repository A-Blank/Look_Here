package com.ssh.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.ssh.entity.Admin;
import com.ssh.entity.Category;
import com.ssh.entity.Product;
import com.ssh.service.AdminService;
import com.ssh.service.CategoryService;
import com.ssh.service.ProductService;
import com.ssh.utils.UploadUtil;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "top")
	public String top() {
		return "/admin/top";
	}

	@RequestMapping(value = "center")
	public String center() {
		return "/admin/center";
	}

	@RequestMapping(value = "down")
	public String down() {
		return "/admin/down";
	}

	@RequestMapping(value = "right")
	public String right() {
		return "/admin/right";
	}

	@RequestMapping(value = "left")
	public String left() {
		return "/admin/left";
	}

	@RequestMapping(value = "/login")
	public String login() {
		return "/admin/login";
	}

	@RequestMapping(value = "/doLogin")
	public String doLogin(Admin admin, HttpSession httpSession, Model model) {
		Admin existAdmin = adminService.checkAdmin(admin);
		if (existAdmin == null) {
			model.addAttribute("massage", "用户名或密码错误");
			return "/admin/login";
		} else {
			httpSession.setAttribute("admin", existAdmin);
			return "/admin/main";
		}
	}

	@RequestMapping(value = "/productAdd")
	public String productAdd(Model model) {
		List<Category> categories = categoryService.getCategories();
		model.addAttribute("categories", categories);
		return "/admin/pages/product-add";
	}

	@RequestMapping(value = "/doProductAdd")
	public String doProductAdd(@RequestParam CommonsMultipartFile[] files, Product product,
			HttpServletRequest request) {
		try {
			String cover = UploadUtil.photoUpload(request);
			product.setCover(cover);
			product.setIsNew(true);
			productService.save(product);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/admin/productList.action";
	}

	@RequestMapping(value = "/productList")
	public String productList(Model model) {
		List<Product> products = productService.getProducts();
		model.addAttribute("products", products);
		return "/admin/pages/product-list";
	}

	@RequestMapping(value = "/productUpdate")
	public String productUpdate(int productId, Model model) {
		Product product = productService.findProductById(productId);
		List<Category> categories = categoryService.getCategories();
		model.addAttribute("product", product);
		model.addAttribute("categories", categories);
		return "/admin/pages/product-update";
	}

	@RequestMapping(value = "/doProductUpdate")
	public String doProductUpdate(@RequestParam CommonsMultipartFile[] files, Product product,
			HttpServletRequest request) {
		try {
			String cover = UploadUtil.photoUpload(request);
			if (!cover .equals("/pictures/")) {
				product.setCover(cover);
			}
			product.setIsNew(true);
			productService.update(product);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/admin/productList.action";
	}
	
	@RequestMapping(value = "/productDelete")
	public String productDelete(int productId) {
		productService.deleteById(productId);
		return "redirect:/admin/productList.action";
	}

}
