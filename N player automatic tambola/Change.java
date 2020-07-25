import java.util.*;
import java.io.*;

public class Change {
    private static int partition3(int[] A) {
    	
    int W=0;
    for(int i=0;i<A.length;i++) {
    W=W+A[i];}	
    if(W%3!=0) return W;
    else { W=W/3;
       
               
        	 
         }
        return 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(partition3(A));
    }
}

