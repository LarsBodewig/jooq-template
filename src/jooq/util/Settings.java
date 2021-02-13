package jooq.util;

public class Settings {

	public static void apply() {
		disableSelfAd();
	}

	public static void disableSelfAd() {
		System.getProperties().setProperty("org.jooq.no-logo", "true");
	}
}
