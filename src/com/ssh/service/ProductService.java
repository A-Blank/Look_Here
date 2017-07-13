package com.ssh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.IndexDao;
import com.ssh.dao.ProductDao;
import com.ssh.entity.Category;
import com.ssh.entity.Product;

@Service
@Transactional
public class ProductService {

	@Autowired private ProductDao productDao ;

	public List<Product> getProducts() {
		return productDao.getProducts();
	}
	
	public Product findProductById(int id){
		return productDao.findProductById(id);
	}

	public List<Category> getCategory() {
		return productDao.getCategories();
	}

	public List<Product> findProductByCategory(String categoryName) {
		return productDao.findProductByCategory(categoryName);
	}

	public void save(Product product) {
		productDao.save(product);
	}

	public void update(Product product) {
		productDao.update(product);
	}

	public void deleteById(int productId) {
		productDao.deleteById(productId);
	}
	
}
