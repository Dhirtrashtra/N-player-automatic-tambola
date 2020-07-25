

import java.util.*;
import java.util.Random;

public class Moderator implements Runnable {
	
	private ArrayList<Integer> nlist= new ArrayList<Integer>();
	private Data data; 
	private Random rand = new Random();
	private int i=0;
	private String s="";
	
	public Moderator(Data data) {
		this.data = data;	
		for(int i=0;i<10;i++) {
			int number = rand.nextInt(50)+1;
			nlist.add(number);
		}		
	}
	public void run() {
		
		synchronized(data.lock1) {			
			while (!data.playerSuccessFlag.contains(true)) {
				data.noAnnouncedFlag = false;
				
				for(int k=0;k<data.playerChanceFlag.size();k++) {
				data.playerChanceFlag.set(k,false);}
		
				synchronized(data.lock2){			
					try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
				}
				
				if(!nlist.isEmpty()) {	int i=0;
				data.announcedNumber = nlist.get(i);
				System.out.println(data.announcedNumber);}
			else break;
				
				nlist.remove(i);
				data.noAnnouncedFlag = true;
				data.lock1.notifyAll();
				
				while(data.playerChanceFlag.contains(false)) {
					try {
						data.lock1.wait(); 
                        } catch (InterruptedException e) {
						 e.printStackTrace();
					}
				}				
			}
			
			for(int j=0; j<data.playerChanceFlag.size();j++) {
				if(data.playerSuccessFlag.get(j)) { 
					System.out.printf("won %d Player \n",j+1);
					break;}
				if(nlist.isEmpty() && j==(data.playerChanceFlag.size()-1)) { s ="no one won";		}}
			
			 	System.out.println(s);

			data.gameCompleteFlag = true;  
			
			data.lock1.notifyAll(); 		
		}		
	}

	
}
