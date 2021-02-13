package jooq.util.config;

import org.jooq.Schema;

import jooq.util.Value;

public interface ConnectionUrlBuilder {

	String build(String ip, String port, Schema schema);

	public static ConnectionUrlBuilder MYSQL = (ip, port, schema) -> {
		String optPort = Value.fallback(port, "3306");
		String optSchema = schema == null ? "" : schema.getName();
		return "jdbc:mysql://" + ip + ":" + optPort + "/" + optSchema;
	};
}
