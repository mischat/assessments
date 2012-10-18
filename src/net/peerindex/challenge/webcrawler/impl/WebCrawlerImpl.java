package net.peerindex.challenge.webcrawler.impl;

import java.net.URL;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import net.peerindex.challenge.webcrawler.WebCrawler;
import net.peerindex.challenge.webcrawler.keyvaluestore.KeyValueStore;
import net.peerindex.challenge.webcrawler.urlRunnable.UrlRunnable;

public class WebCrawlerImpl implements WebCrawler {
	
	private static final int NUM_OF_THREADS = 5;
	KeyValueStore keyValueService;
	Iterator<URL> iteratorUrls;
	
	@Override
	public void setKeyValueStore(KeyValueStore store) {
		this.keyValueService = store;
	}

	@Override
	public void setURLStream(Iterator<URL> iterator) {
		this.iteratorUrls = iterator;
	}

	@Override
	public void execute() {
		ExecutorService executor=Executors.newFixedThreadPool(NUM_OF_THREADS);
		
		while(iteratorUrls.hasNext()) {
			URL url = iteratorUrls.next();
			
			executor.execute(new UrlRunnable(keyValueService, url));
		}
		
		
		try {
			executor.awaitTermination(3000, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void shutdown() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initialise() {
		// TODO Auto-generated method stub
		
	}

}
