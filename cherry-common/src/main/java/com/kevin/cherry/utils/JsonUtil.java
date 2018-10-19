package com.kevin.cherry.utils;

import com.alibaba.fastjson.JSONObject;

public class JsonUtil {

		/**
		 * 获取一个成功的json对象
		 * @return
		 */
		public static JSONObject getSuccessJSONObject() {
			JSONObject json = new JSONObject();
			json.put("code", "200");
			json.put("message", "success");
			return json;
		}
		/**
		 * 获取一个成功的包括数据data的json对象
		 * @param data
		 * @return
		 */
		public static JSONObject getSuccessJSONObject(Object data) {
			JSONObject json = getSuccessJSONObject();
			json.put("data", data);
			return json;
		}
		
		/**
		 * 获取一个失败的json对象
		 * @return
		 */
		public static JSONObject getFailJSONObject() {
			JSONObject json = new JSONObject();
			json.put("code", "400");
			json.put("message", "fail");
			return json;
		}
		
		/**
		 * 获取一个失败的json对象
		 * @return
		 */
		public static JSONObject getFailJSONObject(Object data) {
			JSONObject json = getFailJSONObject();
			json.put("data", data);
			return json;
		}
}
