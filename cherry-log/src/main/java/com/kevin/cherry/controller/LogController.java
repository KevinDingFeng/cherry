package com.kevin.cherry.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class LogController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String outLog() {
		for(int i = 0 ; i < 10 ; i ++) {
			log.info("=========" + i + "===================");
		}
		
		return "ok";
	}
}
