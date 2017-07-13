package com.ssh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssh.dao.CategoryDao;
import com.ssh.entity.Category;

@Service
public class CategoryService {

	
	@Autowired private CategoryDao categoryDao;
	
	public List<Category> getCategories() {
		return categoryDao.getCategories();
	}

}
