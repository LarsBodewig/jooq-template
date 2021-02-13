package jooq.util;

import java.util.function.Supplier;

public abstract class Value {

	public static <T> T fallback(T object, T fallback) {
		return object == null ? fallback : object;
	}

	public static void assertThrow(Object object, Supplier<RuntimeException> excSupply) {
		if (object == null) {
			throw excSupply.get();
		}
	}
}
