package jooq.util.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jooq.util.Settings;
import jooq.util.Value;
import jooq.util.config.Configuration;

public class ConnectionManager {
	private static Configuration config;

	static {
		Settings.disableSelfAd();
	}
	
	public static void setConfiguration(Configuration config) {
		ConnectionManager.config = config;
	}

	public static DSLConnection getConnection() throws SQLException {
		Value.assertThrow(config, 
				() -> new IllegalStateException("ConnectionManager is missing configuration"));
		Connection con = getGenericConnection();
		return new DSLConnection(con, config.dialect);
	}

	private static Connection getGenericConnection() throws SQLException {
		return DriverManager.getConnection(config.url, config.user, config.password);
	}
}
