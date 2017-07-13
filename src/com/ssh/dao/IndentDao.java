package com.ssh.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.ssh.entity.Indent;
import com.ssh.entity.Item;

@Repository
public class IndentDao extends HibernateDaoSupport{

	public int save(Object object) {
		return (int) this.getHibernateTemplate().save(object);
	}

	public List<Indent> findIndentsByUserId(String userId) {
		return (List<Indent>) this.getHibernateTemplate().find("from Indent where user_id=?", userId);
	}

	public List<Item> findItemsByIndentID(int id) {
		return (List<Item>) this.getHibernateTemplate().find("from Item where indent_id=?", id);
	}

}
