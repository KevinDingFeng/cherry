package com.kevin.cherry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.kevin.system.entity.SysUser;
import com.kevin.system.service.SysUserService;

@RestController
@RequestMapping(value = "/user")
public class TestUserController {
	
	//Consider defining a bean of type 'com.kevin.system.service.SysUserService' in your configuration.
	//kevin :
	//	SysUserService 的包名 "com.kevin.system.service" ，本项目启动类 CherryTestApplication 的包名 "com.kevin.cherry"
	//	上述两个类所在的包不存在主从关系， 主类加载不到 @Service 注解
	@Autowired
	private SysUserService sysUserService; 
	

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public JSONObject findOne(@PathVariable(value = "id") Long id) {
		SysUser sysUser = sysUserService.findById(id);
		
		JSONObject json = new JSONObject();
		json.put("sysUser", sysUser);
		return json;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public JSONObject save(@RequestParam(value = "name") String name) {
		SysUser sysUser = new SysUser();
		sysUser.setName(name);
		sysUser.setAccount(name);
		sysUser.setPassword(name);
		sysUser = sysUserService.save(sysUser);
		JSONObject json = new JSONObject();
		
		json.put("sysUser", sysUser);
		return json;
	}
	
}
