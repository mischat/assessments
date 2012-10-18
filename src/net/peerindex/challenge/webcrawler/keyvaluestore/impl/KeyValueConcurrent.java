package net.peerindex.challenge.webcrawler.keyvaluestore.impl;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import net.peerindex.challenge.webcrawler.keyvaluestore.KeyValueStore;

public class KeyValueConcurrent implements KeyValueStore {

	private ConcurrentMap<String, String> urlToValues = new ConcurrentHashMap<String, String>(); 
	
	@Override
	public boolean contains(String key) {
		return urlToValues.containsKey(key);
	}

	@Override
	public String get(String key) {
		return urlToValues.get(key);
	}

	@Override
	public boolean put(String key, String value) {
		return ( (urlToValues.putIfAbsent(key, value)!=null) ? true : false);   
	}

	@Override
	public boolean delete(String key) {
		if(urlToValues.containsKey(key)) {
			String content = urlToValues.get(key);
		
			return (urlToValues.remove(key, content));
		}
		
		return false;	
	}
}
