package me.scylla.fframework.model.entity;

public class Module extends AbstractEntity {

	private static final long serialVersionUID = 164978059549571668L;
	private String developer;

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	@Override
	public String toExtString() {
		return "";
	}
}
