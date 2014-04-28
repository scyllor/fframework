package me.scylla.fframework.model.mapper;

import java.util.List;

import me.scylla.fframework.model.entity.AbstractModuleEntity;
import me.scylla.fframework.utils.db.ModulePage;

/**
 * @author scylla
 * 
 */
public interface IModuleMapper<E extends AbstractModuleEntity<E>> {
	List<E> listItems(ModulePage<E> paging);

	int getItemsCount(ModulePage<E> paging);

	void insertItem(E e);

	void updateItem(E e);

	E getItemById(int id);

	void removeItemById(int id);
}
