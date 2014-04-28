package me.scylla.fframework.model.business;

import me.scylla.fframework.model.dao.IModuleDao;
import me.scylla.fframework.model.entity.AbstractModuleEntity;
import me.scylla.fframework.utils.db.ModulePage;
import me.scylla.fframework.utils.db.PageRowConverter;

public abstract class AbstractModuleService<E extends AbstractModuleEntity<E>>
		implements IModuleService<E> {

	/**
	 * 子类必须实现的方法，返回当前参数类相关的Dao对象
	 * @return 前参数类相关的Dao对象
	 */
	protected abstract IModuleDao<E> getDao(); 
	
	/**
	 * 子类必须实现的方法，将当前实体类对象转换成为flexigrid支持的json列表数据格式
	 * @return 适合当前参数类对象的json列表转换器
	 */
	protected abstract PageRowConverter<E> getJsonConverter();
	
	/**
	 * 默认实现，完成数据插入数据库动作。
	 */
	@Override
	public void insertItem(E elem){
		getDao().insertItem(elem);
	}
	
	/**
	 * 默认实现，完成数据列表查询并返回flexigrid要求的json列表形式。
	 */
	@Override
	public String listItemsInJson(ModulePage<E> paging){
		getDao().getItems(paging);
		return paging.toJsonString(getJsonConverter());
	}
	
	/**
	 * 默认实现，完成获取单一数据功能并返回。
	 */
	@Override
	public E getItemById(int id){
		E elem = getDao().getItemById(id);
		return elem;
	}
	
	/**
	 * 默认实现，完成单一数据更新。
	 */
	@Override
	public void updateItem(E elem){
		getDao().updateItem(elem);
	}

	/**
	 * 默认实现，完成单一数据删除。
	 */
	@Override
	public void removeItem(int id){
		getDao().removeItemById(id);
	}
}
