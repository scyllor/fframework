package me.scylla.fframework.utils.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

/**
 * @author scylla
 *
 */
public class BaseFreeMarkerView extends FreeMarkerView {
	private static final String CONTEXT_PATH = "base"; 
	@Override
	protected void exposeHelpers(Map<String, Object> model,
			HttpServletRequest request) throws Exception {
		model.put(CONTEXT_PATH, request.getContextPath());
		super.exposeHelpers(model, request);
	}

}
