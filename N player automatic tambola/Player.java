import java.util.Random;
import java.util.*;



public class Player implements Runnable {

	private int id;	
	private Random rand = new Random();
	private Data data;				
			
	private final static int ticketSize = 10;		
	
	private ArrayList<Integer> ticket = new ArrayList<Integer>();
			
	public Player(Data data, int id) { 
		
		this.id = id; 		
		this.data = data;	
		
		for(int i = 0; i < ticketSize; i++) {
			int p = rand.nextInt(50)+1;
			if(!ticket.contains(p))ticket.add(p);
			else i--;
		}
		
		System.out.println( id+1+" Player " +ticket);
		
	}
	
	public void run() {
		
		synchronized(data.lock1) {			
			while(!data.gameCompleteFlag) {
			  while(!data.noAnnouncedFlag || data.playerChanceFlag.get(id)) {
					try {
						data.lock1.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			if(!data.gameCompleteFlag) {					
				for(int i=0;i<ticket.size();i++) {		
					if(ticket.get(i)==data.announcedNumber){
						ticket.remove(i);
					    break;}
						}
					
				if(ticket.size()<=7) {
				   data.playerSuccessFlag.set(this.id,true);						
					}
					
				data.playerChanceFlag.set(this.id,true);
				data.lock1.notifyAll();
				
				}
			}
		}
	}
 }

