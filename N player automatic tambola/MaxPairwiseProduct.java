// Java program to calculate  
// last digit of the sum of the  
// fibonacci numbers from M to N 
import java.util.*; 
  
class MaxPairwiseProduct{ 
  
// Calculate the sum of the first  
// N Fibonacci numbers using Pisano 
// period  
static int fib(long n) 
{ 
      
    // The first two Fibonacci numbers 
    int f0 = 0; 
    int f1 = 1; 
  
    // Base case 
    if (n == 0) 
        return 0; 
    if (n == 1) 
        return 1; 
    else
    { 
          
        // Pisano period for % 10 is 60 
        int rem = (int) (n % 60); 
  
        // Checking the remainder 
        if(rem == 0) 
        return 0; 
  
        // The loop will range from 2 to  
        // two terms after the remainder 
        for(int i = 2; i < rem + 3; i++) 
        { 
           int f = (f0 + f1) % 60; 
           f0 = f1; 
           f1 = f; 
        } 
          
        int s = f1 - 1; 
        return s; 
    } 
} 
  
// Driver Code 
public static void main(String args[]) 
{ 
    int m = 10;  
    long n = 200L; 
    int Final = (int)Math.abs(fib(n) -  
                              fib(m - 1)); 
      
    System.out.println(Final % 10); 
} 
} 