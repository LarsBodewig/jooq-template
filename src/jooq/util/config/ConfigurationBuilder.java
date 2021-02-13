package jooq.util.config;

import org.jooq.SQLDialect;
import org.jooq.Schema;

public class ConfigurationBuilder extends Configuration {

	private ConnectionUrlBuilder urlBuilder;
	
	public ConfigurationBuilder setUrlBuilder(ConnectionUrlBuilder urlBuilder) {
		this.urlBuilder = urlBuilder;
		return this;
	}
	
	public ConfigurationBuilder setUser(String user) {
		this.user = user;
		return this;
	}
	
	public ConfigurationBuilder setPassword(String password) {
		this.password = password;
		return this;
	}
	
	public ConfigurationBuilder setIp(String ip) {
		this.ip = ip;
		return this;
	}
	
	public ConfigurationBuilder setPort(String port) {
		this.port = port;
		return this;
	}
	
	public ConfigurationBuilder setSchema(Schema schema) {
		this.schema = schema;
		return this;
	}
	
	public ConfigurationBuilder setDialect(SQLDialect dialect) {
		this.dialect = dialect;
		return this;
	}

	public Configuration build() {
		assertProperty("user", user);
		assertProperty("password", password);
		assertProperty("ip", ip);
		assertProperty("urlBuilder", urlBuilder);
		assertProperty("dialect", dialect);
		this.url = urlBuilder.build(this.ip, this.port, this.schema);
		return this;
	}
}
