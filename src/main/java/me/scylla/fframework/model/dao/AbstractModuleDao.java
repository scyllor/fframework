package me.scylla.fframework.model.dao;

import me.scylla.fframework.model.entity.AbstractModuleEntity;
import me.scylla.fframework.model.mapper.IModuleMapper;
import me.scylla.fframework.utils.db.ModulePage;

/**
 * @author scylla
 * 
 */
public abstract class AbstractModuleDao<E extends AbstractModuleEntity<E>>
		implements IModuleDao<E> {

	protected abstract IModuleMapper<E> getMapper();

	@Override
	public ModulePage<E> getItems(ModulePage<E> paging) {
		beforeListItems(paging);
		paging.setElems(getMapper().listItems(paging));
		paging.setTotalCount(getMapper().getItemsCount(paging));
		afterListItems(paging);
		return paging;
	}

	protected void beforeListItems(ModulePage<E> paging) {
		int pageNo = paging.getPageNo();
		int pageSize = paging.getPageSize();
		int offset = pageSize * (pageNo - 1);
		paging.setOffset(offset);
	}

	protected void afterListItems(ModulePage<E> paging) {
		int totalCount = paging.getTotalCount();
		int pageSize = paging.getPageSize();
		int pageCount = totalCount / paging.getPageSize();
		if (totalCount % pageSize > 0) {
			pageCount++;
		}
		paging.setPageCount(pageCount);
	}

	@Override
	public int getItemsCount(ModulePage<E> paging) {
		return getMapper().getItemsCount(paging);
	}

	@Override
	public void insertItem(E e) {
		getMapper().insertItem(e);
	}

	@Override
	public E getItemById(int id) {
		return getMapper().getItemById(id);
	}

	@Override
	public void removeItemById(int id) {
		getMapper().removeItemById(id);
	}

	@Override
	public void updateItem(E e) {
		getMapper().updateItem(e);
	}
}
