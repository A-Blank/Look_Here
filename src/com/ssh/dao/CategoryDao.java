package com.ssh.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.ssh.entity.Category;

@Repository
public class CategoryDao extends HibernateDaoSupport{

	public List<Category> getCategories() {
		return (List<Category>) this.getHibernateTemplate().find("from Category");
	}

}
