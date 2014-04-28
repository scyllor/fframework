package me.scylla.fframework.utils.db;

import me.scylla.fframework.model.entity.AbstractModuleEntity;
import me.scylla.fframework.model.entity.Module;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ModulePage<E extends AbstractModuleEntity<E>> extends Page<E> {
	private Module module;

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public String toJsonString(PageRowConverter<E> converter) {
		JSONArray arr = new JSONArray();
		for (E elem : this.getElems()) {
			JSONObject row = new JSONObject();
			row.accumulate("id", elem.getId());
			JSONArray fs = new JSONArray();
			Object[] values = converter.convert(elem);
			for (Object value : values) {
				fs.add(value);
			}
			row.accumulate("cell", fs);
			arr.add(row);
		}
		JSONObject json = new JSONObject();
		json.accumulate("page", getPageNo());
		json.accumulate("total", getTotalCount());
		json.accumulate("rows", arr);
		return json.toString();
	}
}
