package com.ssh.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.ssh.entity.User;

@Repository
public class UserDao extends HibernateDaoSupport{

	@Resource
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addUser(User user) {
		this.getSession().save(user);
	}

	public void deleteUser(User user) {
		this.getSession().delete(user);
	}

	public void updateUser(User user) {
		this.getSession().update(user);
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<User> getUsers() {
		return this.getSession().createCriteria(User.class).list();
	}

	public User getUserById(String id) {
		return (User) this.getSession().createQuery("from User where id=?").setParameter(0, id).uniqueResult();
	}

	public boolean register(User user) {
		User existUser = (User) this.getSession().createQuery("from User where phone=?").setParameter(0,user.getPhone()).uniqueResult();
		if (existUser != null) {
			return false;
		}
		this.getSession().save(user);
		return true;
	}

	public User login(User user) {
		
		List<User> users= (List<User>) this.getHibernateTemplate().find("from User where phone=? and password=?", user.getPhone(),user.getPassword());
		if(users.size()>0){
			return users.get(0);
		}
		return null;
	}
	

}
