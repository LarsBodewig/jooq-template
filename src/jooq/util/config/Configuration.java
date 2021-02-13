package jooq.util.config;

import org.jooq.SQLDialect;
import org.jooq.Schema;

import jooq.util.Value;

public abstract class Configuration {
	public String user;
	public String password;
	public String ip;
	public String port;
	public Schema schema;
	public String url;
	public SQLDialect dialect;

	public static ConfigurationBuilder create() {
		return new ConfigurationBuilder();
	}

	public static void assertProperty(String name, Object value) {
		Value.assertThrow(value, () -> new ConfigurationException(name));
	}
}
