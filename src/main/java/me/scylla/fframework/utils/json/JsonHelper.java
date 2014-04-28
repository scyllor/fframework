package me.scylla.fframework.utils.json;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

public class JsonHelper {
	public static String getSuccessJsonString() {
		return getJsonString(true, null, null, null);
	}

	public static String getSuccessJsonString(String msg) {
		return getJsonString(true, null, null, msg);
	}

	public static String getSuccessJsonString(String key, Object value) {
		Map<String, Object> map = new HashMap<String, Object>(1);
		map.put(key, value);
		return getJsonString(true, null, map, null);
	}

	public static String getSuccessJsonString(String key, Object value,
			String msg) {
		Map<String, Object> map = new HashMap<String, Object>(1);
		map.put(key, value);
		return getJsonString(true, null, map, msg);
	}

	public static String getFailJsonString(String err) {
		return getJsonString(false, err, null, null);
	}

	public static String getJsonString(Map<String, ?> map) {
		return getJsonString(true, null, map, null);
	}

	public static String getJsonString(String err, Map<String, ?> map) {
		return getJsonString(false, err, map, null);
	}

	public static String getJsonString(Boolean success, String err,
			Map<String, ?> map) {
		return getJsonString(success, err, map, null);
	}

	public static String getJsonString(String key, Object value, String msg) {
		Map<String, Object> map = new HashMap<String, Object>(1);
		map.put(key, value);
		return getJsonString(null, null, map, msg);
	}

	public static String getJsonString(Boolean success, String err,
			Map<String, ?> map, String msg) {
		JSONObject obj = new JSONObject();
		if (success != null) {
			obj.accumulate("success", success);
		}
		if (msg != null && msg.length() > 0) {
			obj.accumulate("msg", msg);
		}
		if (err != null && err.length() > 0) {
			obj.accumulate("err", err);
		}
		if (map != null) {
			for (String key : map.keySet()) {
				Object value = map.get(key);
				System.out.println("value.class=" + value.getClass().getName());
				if (value instanceof Integer) {
					obj.accumulate(key, (Integer) value);
				} else if (value instanceof Long) {
					obj.accumulate(key, (Long) value);
				} else if (value instanceof Float) {
					obj.accumulate(key, (Float) value);
				} else if (value instanceof Double) {
					obj.accumulate(key, (Double) value);
				} else if (value instanceof Boolean) {
					obj.accumulate(key, (Boolean) value);
				} else {
					obj.accumulate(key, String.valueOf(value));
				}
			}
		}
		return obj.toString();
	}

}