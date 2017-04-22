package com.weishu.util;


import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class PropertyConfig {
	private static PropertyConfig config;

	public static PropertyConfig getInstance() {
		if (config == null) {
			config = new PropertyConfig();
		}
		return config;
	}

	private Properties properties = null;

	private PropertyConfig() {
		properties = loadFile();
	}

	private Properties loadFile() {
		String fileName = "system-china.properties";
		InputStream in = PropertyConfig.class.getClassLoader().getResourceAsStream(fileName);
		Properties prop = new Properties();
		try {
			prop.load(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
	}

	public String getString(String key) {
		return properties.getProperty(key);
	}

	public int getIntProperty(String key, int defaultValue) {
		String value = getString(key);
		if (value == null) {
			return defaultValue;
		} else {
			try {
				return Integer.parseInt(value.trim());
			} catch (Exception e) {
				return defaultValue;
			}
		}
	}

//	public List<Integer> getIntPropertyList(String key) {
//		String listStr = getString(key);
//		if(StringUtils.isBlank(listStr)){
//			return Collections.emptyList();
//		}
//		return ListUtil.stringToIntegerList(listStr);
//	}
//
//	public List<String> getStringPropertyList(String key) {
//		String listStr = getString(key);
//		if(StringUtils.isBlank(listStr)){
//			return Collections.emptyList();
//		}
//		return ListUtil.stringToStringList(listStr);
//	}


	public void reload() {
		properties = loadFile();
	}
}
