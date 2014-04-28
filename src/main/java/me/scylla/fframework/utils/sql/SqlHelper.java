/**
 * Project Name:shoppingcart
 * File Name:SqlHelper.java
 * Package Name:org.ecommerce.framework.utils.sql
 * Date:2014年4月28日下午3:52:55
 * Copyright (c) 2014, chenzhou1025@126.com All Rights Reserved.
 *
 */

package me.scylla.fframework.utils.sql;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:SqlHelper <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2014年4月28日 下午3:52:55 <br/>
 * 
 * @author liurui
 * @version
 * @since JDK 1.6
 * @see
 */
public class SqlHelper {
	public static Map<String, Object> getParamMap(Object... params) {
		Map<String, Object> paramMap = new HashMap<String, Object>(14, 0.7f);
		for (int i = 0; i < params.length; i += 2) {
			paramMap.put((String) params[i], params[i + 1]);
		}
		return paramMap;
	}
}
