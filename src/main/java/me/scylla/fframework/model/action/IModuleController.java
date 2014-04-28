package me.scylla.fframework.model.action;

import java.util.logging.Logger;

import me.scylla.fframework.model.entity.AbstractModuleEntity;
import me.scylla.fframework.model.entity.ModuleSupport;
import me.scylla.fframework.utils.db.ModulePage;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

public interface IModuleController<E extends AbstractModuleEntity<E>> extends
		ModuleSupport {
	Logger getLogger();

	String toAddPage(Model model, E elem, BindingResult result);

	String postAddData(Model model, E elem, BindingResult result);

	String toListPage(Model model, E elem, BindingResult result);

	String getListData(Model model, ModulePage<E> paging, BindingResult result);

	String toEditPage(Model model, E elem, BindingResult result);

	String postEditData(Model model, E elem, BindingResult result);

	String postRemoveData(Model model, E elem, BindingResult result);
}