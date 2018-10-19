package com.kevin.ehcache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.kevin.ehcache.service.TestUserService;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

@RestController
@RequestMapping(value = "/cache")
public class TestCacheController {
	
	@Autowired
	private TestUserService userService;

	
	/**
	 * 测试项目自带的 缓存 cache  ，可行
	 * 	properties 中添加了配置： 
	 *		spring.cache.type=SIMPLE
	 * @return
	 */
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public JSONObject find() {
		JSONObject json = new JSONObject();
		String value = userService.getValue("Kevin");
		json.put("data", value);
		return json;
	}

	@Autowired
    CacheManager cacheManager;
	/**
	 * 测试项目整合的 ehcache ，可行
	 * 	properties 中添加了配置： 
	 *		spring.cache.type=ehcache
	 *		spring.cache.ehcache.config=classpath:ehcache.xml
	 *	并添加相应的 xml 配置文件
	 * @return
	 */
	@RequestMapping(value = "/find2", method = RequestMethod.GET)
	public JSONObject find2() {
		System.out.println(cacheManager.toString());//__DEFAULT__
		Cache cache = cacheManager.getCache("sms_code");
		Element element = cache.get("Kevin");
		if(element != null) {
			String k = (String) element.getObjectKey();
			String v = (String) element.getObjectValue();
			System.out.println(k + " : " + v);//Kevin : Kevin
		}
		JSONObject json = new JSONObject();
		String value = userService.getValue2("Kevin");
		json.put("data", value);
		return json;
	}
	
}
