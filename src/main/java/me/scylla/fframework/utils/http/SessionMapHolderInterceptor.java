package me.scylla.fframework.utils.http;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Ray Liu
 * 
 */
public class SessionMapHolderInterceptor implements HandlerInterceptor {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		logger.debug("handler={}@{}", handler.getClass().getSimpleName(),
				handler.hashCode());
		HttpSession session = request.getSession();
		if (session != null) {
			Enumeration<?> names = session.getAttributeNames();
			while (names.hasMoreElements()) {
				String name = (String) names.nextElement();
				Object value = session.getAttribute(name);
				logger.debug("SessionHolder.setObject({})", name);
				SessionHelper.setObject(name, value);
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		Map<String, Object> map = SessionHelper.getSessionMap();
		HttpSession session = request.getSession();
		if (map != null) {
			if (session != null) {
				for (String key : map.keySet()) {
					if (map.get(key) == null) {
						session.removeAttribute(key);
						logger.debug("HttpSession.remove({})", key);
					} else {
						session.setAttribute(key, map.get(key));
						logger.debug("HttpSession.set({})", key);
					}
				}
			} else {
				for (String key : map.keySet()) {
					if (map.get(key) != null) {
						if (session == null) {
							session = request.getSession(true);
							logger.debug("HttpSession.new!!!");
						}
						session.setAttribute(key, map.get(key));
						logger.debug("HttpSession.set({})", key);
					}
				}
			}
		} else {
			if (session != null) {
				// session.setMaxInactiveInterval(0);
				session.invalidate();
			}
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		SessionHelper.clearObjects();
		logger.debug("SessionHolder.clearObjects!");
	}
}
