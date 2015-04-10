package com.wesovi.ms.at.util;

import java.util.HashMap;
import java.util.Map;

public class CucumberStore {

	private static CucumberStore instance = null;
	
	private static Map<String,Object> store;
	
	private CucumberStore(){
		store = new HashMap<>();
	}
	
	public static CucumberStore getInstance(){
		if(instance==null){
			instance = new CucumberStore();
		}
		return instance;
	}
	
	public void store(String key,Object value){
		store.put(key, value);
	}
	
	@SuppressWarnings("unchecked")
	public <T>T get(String key,Class<T> clazz){
		Object value = store.get(key);
		if(value==null){
			return null;
		}
		return (T)value; 
	}
}
