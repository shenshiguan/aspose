package org.ssg.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 加载system.properties配置信息
 */
public final class ConfigUtil {
	private static final Logger logger = LoggerFactory.getLogger(ConfigUtil.class);
	private static final Properties properties = load();

	private static final Properties load() {
		String envTarget = System.getProperty("envTarget");
		String config = "config/system-" + envTarget + ".properties";
		try {
			Properties properties = new Properties();
			InputStream in = ConfigUtil.class.getClassLoader().getResourceAsStream(config);
			properties.load(in);
			return properties;
		} catch (IOException e) {
			logger.error("Config file " + config + " load error \n" + e.getMessage());
		}
		return new Properties();
	}

	public static String get(String name) {
		return properties.getProperty(name);
	}

	public static String get(String name, String defaultValue) {
		String value = properties.getProperty(name);
		return value == null ? defaultValue : value;
	}
}
