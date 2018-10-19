package com.kevin.ehcache.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class TestUserService {

	/**
	 * kevin 方法可行
	 * 	使用简单的原生缓存，所以 cacheNames 可以自定义
	 * 	cacheNames 在理论上等同于 value 但是在实践中发现，并不是，可能是因为版本的原因。
	 * 	cacheNames 可以通过 @CacheConfig(cacheNames = "xxx") 的形式，放到类的头部，作为整个类的缓存 name 的定义 
	 * @param key
	 * @return
	 */
	@Cacheable(cacheNames = "users", key = "#key")
	public String getValue(String key) {
		System.out.println("key = " + key + " ; value + Kevin");
		return "Kevin";
	}
	
	
	/**
	 * kevin 方法可行
	 * 	使用 整合后的 ehcache ， cacheNames 需要和 xml 配置文件中的 name 一致
	 * 	cacheNames 在理论上等同于 value 但是在实践中发现，并不是，可能是因为版本的原因。
	 * 	cacheNames 可以通过 @CacheConfig(cacheNames = "xxx") 的形式，放到类的头部，作为整个类的缓存 name 的定义 
	 * @param key
	 * @return
	 */
	@Cacheable(cacheNames = "sms_code", key = "#key")
	public String getValue2(String key) {
		System.out.println("key = " + key + " ; value + Kevin");
		return "Kevin";
	}
	
}
