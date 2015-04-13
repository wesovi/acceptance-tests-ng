package com.wesovi.ms.at.util;


import java.io.IOException;
import java.util.Properties;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ConfigurationProperties {

	private static final String CONF_PATH = "configuration.properties";
	
	private static ConfigurationProperties instance = null;
	
	private final Properties properties = new Properties();
	
	private ConfigurationProperties() throws IOException{
		properties.load(this.getClass().getClassLoader().getResourceAsStream(CONF_PATH));
        log.debug("Properties already loeaded");
	}
	
	public static ConfigurationProperties getInstance(){
		if(instance==null){
			try {
				instance=new ConfigurationProperties();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
	
	@SuppressWarnings("unchecked")
	public <T>T getProperty(String key,Class<T> clazz){
		Object value = properties.get(key);
		if(value!=null){
			return clazz.cast(value);
		}
		return null;
	}
	
	
}
