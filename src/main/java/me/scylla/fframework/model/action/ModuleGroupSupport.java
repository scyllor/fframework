package me.scylla.fframework.model.action;

import me.scylla.fframework.model.entity.AbstractModuleEntity;
import me.scylla.fframework.utils.annotation.ModuleGroup;
import me.scylla.fframework.utils.reflect.GenericHelper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModuleGroupSupport<E extends AbstractModuleEntity<E>> {
	Logger logger = LoggerFactory.getLogger(ModuleGroupSupport.class);
	protected final Class<E> entityClass;
	protected final String moduleName;
	protected final String moduleNames;
	protected final String moduleGroup;

	@SuppressWarnings("unchecked")
	protected ModuleGroupSupport() {
		entityClass = (Class<E>) GenericHelper.getActuralClass(this.getClass());
		String value = null;
		String mn = "";
		String mns = "";
		if (entityClass.isAnnotationPresent(ModuleGroup.class)) {
			ModuleGroup mg = entityClass.getAnnotation(ModuleGroup.class);
			value = mg.value();
			if (!value.endsWith("/")) {
				value += "/";
			}
			mn = mg.moduleName();
			mns = mg.moduleNames();
		}
		moduleGroup = value == null ? "" : value;
		moduleName = mn.length() == 0 ? entityClass.getSimpleName()
				.toLowerCase() : mn;
		moduleNames = mns.length() == 0 ? moduleName + "s" : mns;

	}

	protected String getMyView(String ftl) {
		String viewPath = moduleGroup + moduleNames + "/" + ftl;
		logger.debug(viewPath);
		return viewPath;
	}

	protected String getEditView() {
		return moduleGroup + moduleNames + "/" + moduleName + ".ftl";
	}

	protected String getListView() {
		return moduleGroup + moduleNames + "/" + moduleNames + ".ftl";
	}
}
