package net.peerindex.challenge.webcrawler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.peerindex.challenge.webcrawler.keyvaluestore.KeyValueStore;
import net.peerindex.challenge.webcrawler.keyvaluestore.impl.KeyValueConcurrent;

/**
 * Factory.
 */
public class Factory {
	private final static String PATH="C:\\Users\\developer\\Assessments\\resources";
    
	public static KeyValueStore createKeyValueStore() {
        return new KeyValueConcurrent(); //TODO
    }

    public static WebCrawler createWebCrawler() {
        return null; //TODO
    }

    public static Iterator<URL> createURLIterator() {
    	List<URL> urls = new ArrayList<URL> ();
    	FileInputStream stream=null;
    	try {
    		stream = new FileInputStream(new File(PATH));
			
    		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
    		
    		String line="";
    		
				while( (line=reader.readLine()) !=null) {
					urls.add(new URL(line.substring(line.indexOf(":\""), line.indexOf(line.indexOf("\"")))));
				}
    		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e1 ) {
			e1.printStackTrace();
		} finally{
			if(stream!=null) {
				try {
					stream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
    	
    	return urls.iterator();
    }

}
