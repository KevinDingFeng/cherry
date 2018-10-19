package com.kevin.ehcache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kevin.ehcache.service.TestEhcacheService;

@RestController
@RequestMapping(value = "/ehcache")
public class TestEhcacheController {

//	@Autowired
//	private TestEhcacheService ehcacheService;//按照 service 里的做法，不可以
//	
//	@RequestMapping(value = "/find", method = RequestMethod.GET)
//	public String find() {
//		String v = ehcacheService.find("Kevin");
//		return v;
//	}
}
