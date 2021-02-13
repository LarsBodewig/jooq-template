package jooq.util.config;

public class ConfigurationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ConfigurationException(String property) {
		super("Configuration is missing property: "
				+ property
				+ System.lineSeparator()
				+ "Configuration could not be build because property was null at build-time. "
				+ "Use the setters to provide a value.");
	}
}
