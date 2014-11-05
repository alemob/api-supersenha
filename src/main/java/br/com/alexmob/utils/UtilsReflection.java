package br.com.alexmob.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by alexandre on 04/11/14.
 */
public class UtilsReflection {

	//TODO: Implementar

	/**
	 * Usado para invocar métodos privados.
	 *
	 * @param object
	 * @param methodName
	 * @param methodParameters Utilizar tipos de parametros exatos,
	 *                         ou seja, se inteiro primitivo usar a própria constante primitiva, senão converter (Integer.valueOf(), Boolean.valueOf()), etc.
	 * @return retorna o valor da execução do método.
	 */
	public static Object invokeMethod (Object object, String methodName, Object... methodParameters) {
		Class<?>[] pTypes = new Class[methodParameters.length];
		int i = 0;
		for (Object o : methodParameters) {
			pTypes[i++] = getCorrectType (o);
		}
		Method method = getMethod (object, methodName, pTypes);
		try {
			return method.invoke (object, methodParameters);
		} catch (IllegalAccessException e) {
			throw new RuntimeException (e.getMessage ());
		} catch (InvocationTargetException e) {
			throw new RuntimeException (e.getMessage ());
		}
	}

	private static Method getMethod (Object object, String methodName, Class<?>[] pTypes) {
		Method method;
		try {
			method = object.getClass ().getMethod (methodName, pTypes);
			object.getClass ().getMethods ();
			if (! method.isAccessible ()) {
				method.setAccessible (true);
			}
			return method;
		} catch (NoSuchMethodException e) {
			e.printStackTrace ();
		}
		return null;
	}

	private static Class<?> getCorrectType (Object o) {
		try {
			final Field type = o.getClass ().getDeclaredField ("TYPE");
			return (Class<?>) type.get (o.getClass ());
		} catch (NoSuchFieldException e) {
			return o.getClass ();
		} catch (IllegalAccessException e) {
			e.printStackTrace ();
		}
		return null;
	}
}
