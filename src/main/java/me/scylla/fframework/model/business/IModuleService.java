package me.scylla.fframework.model.business;

import me.scylla.fframework.model.entity.AbstractModuleEntity;
import me.scylla.fframework.utils.db.ModulePage;

public interface IModuleService<E extends AbstractModuleEntity<E>> {

	public abstract void insertItem(E elem);

	public abstract String listItemsInJson(ModulePage<E> paging);

	public abstract E getItemById(int id);

	public abstract void updateItem(E group);

	public void removeItem(int id);
}