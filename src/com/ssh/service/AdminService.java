package com.ssh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.AdminDao;
import com.ssh.entity.Admin;

@Transactional
@Service
public class AdminService {

	@Autowired private AdminDao adminDao;
	
	public Admin checkAdmin(Admin admin) {
		return adminDao.checkAdmin(admin);
	}

}
