
 import java.util.*;

	public class FibonacciSumLastDigit {
	 
	    
	    private static long getFibonacciSum(long n) {
	    	  ArrayList<Long>  list= new ArrayList<Long>();
	    	  
	    	    list.add(0L); 
	    	    list.add(1L); 
	    	    list.add(1L); 
	    	    long m = n%60;
	    	    int preparedNumbers[] = {0, 1, 2, 4, 7, 2, 0, 3, 4, 8, 3, 
	    	            2, 6, 9, 6, 6, 3, 0, 4, 5, 0, 6, 7, 4, 2, 7, 0, 8, 9, 8, 8, 7, 
	    	            6, 4, 1, 6, 8, 5, 4, 0, 5, 6, 2, 9, 2, 2, 5, 8, 4, 3, 8, 2, 1, 
	    	            4, 6, 1, 8, 0, 9, 0};
	    	    return (long)preparedNumbers[(int)m];
	    	   
	    }
	    
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        long n = scanner.nextLong();
	        scanner.close();
	        long s = getFibonacciSum(n);
	        System.out.println(s);
	    }
	}


