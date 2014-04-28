package me.scylla.fframework.model.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;

public abstract class AbstractEntity implements Serializable {

	private static final long serialVersionUID = 4157474894538504508L;
	protected Integer id;
	protected String name;
	protected String description;
	protected boolean disabled;
	protected HashMap<String, String> properties;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public HashMap<String, String> getProperties() {
		return properties;
	}

	public void setProperties(HashMap<String, String> properties) {
		this.properties = properties;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer(this.getClass().getSimpleName())
				.append("@").append(this.hashCode()).append(" {").append("id:")
				.append(this.id).append(", name:").append(this.name)
				.append(", description:").append(this.description)
				.append(", disable:").append(this.disabled);
		if (null != this.properties) {
			Iterator<String> it = this.properties.keySet().iterator();
			while (it.hasNext()) {
				String key = it.next();
				String value = this.properties.get(key);
				sb.append(", ").append(key).append(":").append(value);
			}
		}
		sb.append(", " + this.toExtString()).append("}");
		return sb.toString();
	}

	protected abstract String toExtString();
}