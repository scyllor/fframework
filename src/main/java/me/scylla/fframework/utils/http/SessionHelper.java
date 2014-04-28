package me.scylla.fframework.utils.http;

import java.util.HashMap;
import java.util.Map;

import me.scylla.fframework.model.entity.Module;

/**
 * @author Ray Liu
 * 
 */
public class SessionHelper {
	public static final String KEY_MODULE = "_app";
	public static final String KEY_PRIVILEGE = "_privilege";
	public static final String KEY_LOGIN_USER = "_login_user";
	public static final String KEY_CART = "_cart";
	private static final ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<Map<String, Object>>();
	private static final Map<String, Object> defaultValues = new HashMap<String, Object>();

	static Map<String, Object> getDefaultvalues() {
		return defaultValues;
	}

	public static void setObject(String key, Object value) {
		if (threadLocal.get() == null) {
			Map<String, Object> map = new HashMap<String, Object>();
			threadLocal.set(map);
		}
		threadLocal.get().put(key, value);
	}

	public static Map<String, Object> getSessionMap() {
		return threadLocal.get();
	}

	public static Object getObject(String key) {
		Map<String, Object> map = threadLocal.get();
		Object value = null;
		if (map != null) {
			value = map.get(key);
		}
		if (value == null) {
			value = defaultValues.get(key);
		}
		return value;
	}

	public static void clearObjects() {
		threadLocal.remove();
	}

	public static void setModule(Module module) {
		setObject(KEY_MODULE, module);
	}

	public static Module getModule() {
		return (Module) getObject(KEY_MODULE);
	}

}