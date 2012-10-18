package net.peerindex.challenge.webcrawler.urlRunnable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import net.peerindex.challenge.webcrawler.keyvaluestore.KeyValueStore;

public class UrlRunnable implements Runnable {
	KeyValueStore storeService;
	URL url;
	
	public UrlRunnable(KeyValueStore storeService, URL url) {
		 this.storeService= storeService;
		 this.url=url;
	}
	
	
	@Override
	public void run() {
		URLConnection connection;
		try {
			//read the url
			connection = url.openConnection();
		
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			//TODO: check for mime type
			
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				inputLine+=inputLine;
			}
			
			//replace key with the following value
			storeService.put(url.toString(), inputLine);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
