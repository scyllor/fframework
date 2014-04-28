package me.scylla.fframework.utils.db;

public interface PageRowConverter<E> {
	Object[] convert(E elem);
}
