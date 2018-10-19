package com.kevin.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevin.system.dao.SysUserDao;
import com.kevin.system.entity.SysUser;

@Service
public class SysUserService {
	
	@Autowired
	private SysUserDao userDao;


	public SysUser findById(Long id) {
		return userDao.findOne(id);
	}

	public SysUser save(SysUser entity) {
		return userDao.save(entity);
	}
	
}
