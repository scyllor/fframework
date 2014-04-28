package me.scylla.fframework.model.dao;

import me.scylla.fframework.model.entity.AbstractModuleEntity;
import me.scylla.fframework.utils.db.ModulePage;

public interface IModuleDao<E extends AbstractModuleEntity<E>> {

	ModulePage<E> getItems(ModulePage<E> paging);

	int getItemsCount(ModulePage<E> paging);

	void insertItem(E e);

	void updateItem(E e);

	E getItemById(int id);

	void removeItemById(int id);

}