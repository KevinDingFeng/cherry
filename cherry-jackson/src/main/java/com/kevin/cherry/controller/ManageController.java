package com.kevin.cherry.controller;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.kevin.cherry.model.KevinUser;
import com.kevin.cherry.utils.JsonUtil;

@RestController
public class ManageController {
	
	private final static String STR_KEY = "test-set-jackson-str";
	private final static String OBJ_KEY = "test-set-jackson-obj";

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@RequestMapping(value = "/set_str", method = RequestMethod.GET)
	public JSONObject setString() {
		ValueOperations<String, Object> operations = redisTemplate.opsForValue();
		operations.set(STR_KEY, "asdflkjsdfalkjhasdf");
		redisTemplate.expire(STR_KEY, 300, TimeUnit.SECONDS);
		return JsonUtil.getSuccessJSONObject();
	}

	@RequestMapping(value = "/get_str", method = RequestMethod.GET)
	public JSONObject getString() {
		ValueOperations<String, Object> operations = redisTemplate.opsForValue();
		String result = (String) operations.get(STR_KEY);
		System.out.println(result);//asdflkjsdfalkjhasdf 没有引号
		return JsonUtil.getSuccessJSONObject(result);
	}

	@RequestMapping(value = "/set_obj", method = RequestMethod.GET)
	public JSONObject setObject() {
		ValueOperations<String, Object> operations = redisTemplate.opsForValue();
		operations.set(OBJ_KEY, this.getUser());
		redisTemplate.expire(OBJ_KEY, 300, TimeUnit.SECONDS);
		return JsonUtil.getSuccessJSONObject();
	}
	private KevinUser getUser() {
		KevinUser ku = new KevinUser();
		ku.setId(2L);
		ku.setName("小强");
		return ku;
	}

	@RequestMapping(value = "/get_obj", method = RequestMethod.GET)
	public JSONObject getObject() {
		ValueOperations<String, Object> operations = redisTemplate.opsForValue();
		KevinUser result = (KevinUser) operations.get(OBJ_KEY);
		return JsonUtil.getSuccessJSONObject(result);
	}

	@RequestMapping(value = "/keys", method = RequestMethod.GET)
	public JSONObject keys() {
		JSONObject json = new JSONObject();
		Set<String> keys = redisTemplate.keys("*");
		json.put("keys", keys);

		return json;
	}

	@RequestMapping(value = "/clear", method = RequestMethod.GET)
	public JSONObject clear() {
		redisTemplate.delete(STR_KEY);
		redisTemplate.delete(OBJ_KEY);
		return JsonUtil.getSuccessJSONObject();
	}

}
