package jooq.util;

public abstract class Settings {

	public static void disableSelfAd() {
		System.getProperties().setProperty("org.jooq.no-logo", "true");
	}
}
