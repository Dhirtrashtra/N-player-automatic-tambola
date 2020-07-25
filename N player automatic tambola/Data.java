
import java.util.*;

public class Data {
	public int announcedNumber ;	 
	public boolean gameCompleteFlag = false;	
	public boolean noAnnouncedFlag = false;
	public ArrayList<Boolean> playerSuccessFlag;
	public ArrayList<Boolean> playerChanceFlag ;
	public Data(int lmn){
		 playerSuccessFlag= new ArrayList<Boolean>();
		 playerChanceFlag= new ArrayList<Boolean>();
		for(int i=0;i<lmn;i++) {playerSuccessFlag.add(false);playerChanceFlag.add(false);}
	}
	public Object lock1 = new Object();
	public Object lock2 = new Object();
}
