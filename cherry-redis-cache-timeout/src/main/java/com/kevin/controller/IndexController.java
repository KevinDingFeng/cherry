package com.kevin.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		
		return "lll";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestParam(value = "name") String name) {
		UsernamePasswordToken token = new UsernamePasswordToken(name, name);
		token.setRememberMe(true);
		SecurityUtils.getSubject().login(token);
		return "kkk";
	}
}
