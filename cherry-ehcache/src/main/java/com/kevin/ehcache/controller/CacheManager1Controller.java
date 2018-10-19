package com.kevin.ehcache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kevin.ehcache.service.CacheManagerService;
/**
 * 结合 controller CacheManager2Controller 类测试 不同的 controller 使用同一个 cahce 是否可行
 * 	可行
 * @author kevin
 *
 */
@RestController
@RequestMapping(value = "/cc1")
public class CacheManager1Controller {

	@Autowired
	private CacheManagerService ccService;
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public String find() {
		String v = ccService.get("Kevin");
		if(v == null) {
			System.out.println("没有缓存");
		}else {
			System.out.println("存在缓存" + v);
		}
		String k = ccService.find("Kevin");
	
		return k;
	}
}
