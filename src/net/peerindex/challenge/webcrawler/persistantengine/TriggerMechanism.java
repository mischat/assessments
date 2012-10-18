package net.peerindex.challenge.webcrawler.persistantengine;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Timer;
import java.util.TimerTask;

import net.peerindex.challenge.webcrawler.keyvaluestore.KeyValueStore;


public class TriggerMechanism extends TimerTask {
	private static final String PATH = "C:\\";
	private KeyValueStore keyValueStore;
	
	public TriggerMechanism(KeyValueStore store) {
		Timer timer = new Timer();
		timer.schedule(this, 1000*60);
		keyValueStore = store;
	}
	
	@Override
	public void run() {
		ObjectInputStream srl = null;
		try {
			srl= new ObjectInputStream(new FileInputStream(new File(PATH)));
			
			//now we need to get the internal data structure contained into the KeyvalueStore implmenentation, otherwise we could serialize the object per se
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(srl!=null) {
				try {
					srl.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		//srl.get
	}

}
