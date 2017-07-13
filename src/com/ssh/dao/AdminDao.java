package com.ssh.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.ssh.entity.Admin;

@Repository
public class AdminDao extends HibernateDaoSupport{

	public Admin checkAdmin(Admin admin) {
		List<Admin> admins=(List<Admin>) this.getHibernateTemplate().find("from Admin where username=? and password=?", admin.getUsername(),admin.getPassword());
		if(admins.size()>0){
			return admins.get(0);
		}
		return null;
	}

	
}
