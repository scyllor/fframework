package me.scylla.fframework.utils.Exception;

import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.validation.ObjectError;

public class BindingException extends AbstractModuleException {
	private static final long serialVersionUID = -541424023411828662L;
	List<ObjectError> allErrors;

	public BindingException(List<ObjectError> allErrors) {
		super();
		this.allErrors = allErrors;
	}
	
	public String getJsonString(){
		JSONObject obj = new JSONObject();
		obj.accumulate("success", false);
		obj.accumulate("err", this.getMessage());
		return obj.toString();
	}
}
