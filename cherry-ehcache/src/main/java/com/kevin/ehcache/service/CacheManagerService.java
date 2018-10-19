package com.kevin.ehcache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

@Service
public class CacheManagerService {

	
	@Cacheable(cacheNames = "sms_code", key = "#key")
	public String find(String key) {
		System.out.println("key = " + key + " ; value + Kevin");
		return "Kevin";
	}
	
	@Autowired
	private CacheManager cacheManager;
	
	public String get(String k) {
		Cache cache = cacheManager.getCache("sms_code");
		
		Element e = cache.get(k);
		
		if(e != null) {
			return (String) e.getObjectValue();
		}else {
			return null;
		}
		
	}

}
