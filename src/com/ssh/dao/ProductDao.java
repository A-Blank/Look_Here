package com.ssh.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.ssh.entity.Category;
import com.ssh.entity.Product;
import com.ssh.entity.User;

@Repository
public class ProductDao extends HibernateDaoSupport{

	@Resource private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	
	public List<Product> getProducts() {		
		return this.getSession().createCriteria(Product.class).list();
	}
	
	public Product findProductById(int id){
		return this.getHibernateTemplate().get(Product.class, id);
	}


	public List<Category> getCategories() {
		return (List<Category>) this.getHibernateTemplate().find("from Category");
	}


	public List<Product> findProductByCategory(String categoryName) {
		return (List<Product>) this.getHibernateTemplate().find("from Product where category=?", categoryName);
	}


	public void save(Product product) {
		this.getHibernateTemplate().save(product);
	}


	public void update(Product product) {
		this.getHibernateTemplate().update(product);
	}


	public void deleteById(int productId) {
		this.getHibernateTemplate().delete(findProductById(productId));
	}

}
