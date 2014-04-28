package me.scylla.fframework.model.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import me.scylla.fframework.model.business.AbstractModuleService;
import me.scylla.fframework.model.entity.AbstractModuleEntity;
import me.scylla.fframework.model.entity.Module;
import me.scylla.fframework.utils.Exception.BindingException;
import me.scylla.fframework.utils.date.DateTimeEditor;
import me.scylla.fframework.utils.db.ModulePage;
import me.scylla.fframework.utils.http.SessionHelper;
import me.scylla.fframework.utils.json.JsonHelper;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

public abstract class AbstractModuleController<E extends AbstractModuleEntity<E>>
		extends ModuleGroupSupport<E> implements IModuleController<E> {

	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		DateTimeEditor dateEditor = new DateTimeEditor();
		binder.registerCustomEditor(Date.class, dateEditor);
	}

	public void checkBindingResult(BindingResult result)
			throws BindingException {
		if (result.getErrorCount() > 0) {
			throw new BindingException(result.getAllErrors());
		}
	}

	@Override
	public String toAddPage(Model model, E elem, BindingResult result) {
		return getEditView();
	}

	@Override
	public String postAddData(Model model, E elem, BindingResult result) {
		try {
			getService().insertItem(elem);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonHelper.getFailJsonString(e.getMessage());
		}
		return JsonHelper.getSuccessJsonString("id", elem.getId());
	}

	@Override
	public String toListPage(Model model, E elem, BindingResult result) {
		return getListView();
	}

	@Override
	public String getListData(Model model, ModulePage<E> paging,
			BindingResult result) {
		try {
			String json = getService().listItemsInJson(paging);
			return json;
		} catch (Exception e) {
			e.printStackTrace();
			return JsonHelper.getFailJsonString(e.getMessage());
		}
	}

	@Override
	public String toEditPage(Model model, E elem, BindingResult result) {
		elem = getService().getItemById(elem.getId());
		model.addAttribute("item", elem);
		return getEditView();
	}

	@Override
	public String postEditData(Model model, E elem, BindingResult result) {
		try {
			getService().updateItem(elem);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonHelper.getFailJsonString(e.getMessage());
		}

		return JsonHelper.getSuccessJsonString("id", elem.getId());
	}

	@Override
	public String postRemoveData(Model model, E elem, BindingResult result) {
		try {
			getService().removeItem(elem.getId());
			return JsonHelper.getSuccessJsonString();
		} catch (Exception ex) {
			return JsonHelper.getFailJsonString(ex.getMessage());
		}
	}

	protected abstract AbstractModuleService<E> getService();

	void setPageModule(ModulePage<E> paging) {
		paging.setModule(getModule());
	}

	@Override
	public void setModule(Module module) {

	}

	public Module getModule() {
		Module module = SessionHelper.getModule();
		return module;
	}
}
