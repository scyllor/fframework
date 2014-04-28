package me.scylla.fframework.model.entity;


public abstract class AbstractModuleEntity<E extends AbstractModuleEntity<E>>
		extends AbstractEntity implements ModuleSupport{
	private static final long serialVersionUID = -4836490132249760684L;

	private Module module;

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}
}
