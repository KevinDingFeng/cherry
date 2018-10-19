package com.kevin.ehcache.service;

import org.springframework.stereotype.Service;

/**
 * 使用 spring mvc 的方式测试 ehcache 的使用方法，不可行
 * 	会出现 Ehcache 实体没有注册使用的问题，需要主动导入 @Bean 
 * @author kevin
 *
 */
@Service
public class TestEhcacheService {
//
//	@Autowired
//	@Qualifier("sms_code")
//	private Ehcache ehcache;
//	/**
//	 * 配置和 TestUserService 的一致
//	 * 	不可行
//	 * @param name
//	 * @return
//	 */
//	public String find(String name) {
//		String value = name + "Value";
//		Element element = ehcache.get(name);
//		if(element == null) {
//			System.out.println("缓存不存在");
//			ehcache.put(new Element(name, value));
//			return value;
//		}else {
//			System.out.println("存在缓存");
//			String k = (String) element.getObjectKey();
//			String v = (String) element.getObjectValue();
//			return k + " : " + v;
//		}
//	}
	
	
	
	
}
