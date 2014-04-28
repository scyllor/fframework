package me.scylla.fframework.utils.reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericHelper {
	public static final Class<?> getActuralClass(Class<?> clazz) {
		ParameterizedType klass = ((ParameterizedType) clazz
				.getGenericSuperclass());
		Type[] types = klass.getActualTypeArguments();
		if (types != null && types.length > 0) {
			return (Class<?>) types[0];
		}
		return null;
	}
}
