// Write a program for congestion control using token bucket algorithm.

import java.util.*;

public class tokenBucket{
	public static void main(String[] args){
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the bucket size");
		int bsize=sc.nextInt();
		int tokens=0;
		int tokenrate=3;
		System.out.println("Enter the number of requests");
		int n=sc.nextInt();
		System.out.println("Enter the number of packets in each requests");
		int[] requests=new int[n];
		for(int i=0;i<n;i++){
			requests[i]=sc.nextInt();
		}
		
		for(int i=0;i<n;i++){
			tokens=Integer.min((tokens+tokenrate),bsize);
			System.out.println("\nNumber of tokens present= "+tokens);
		
			if(requests[i]<tokens){
				System.out.println("Number of packets= "+requests[i]);
				System.out.println("Packets accepted");
				tokens-=requests[i];
				System.out.println("Number of tokens remaining="+tokens);
			}
			else{
				System.out.println("Number of packets= "+requests[i]);
				System.out.println("Packets dropped");
				System.out.println("Number of tokens remaining="+tokens);
			}
		}
		
	}
}


/*
Output:

Enter the bucket size
10
Enter the number of requests
3
Enter the number of packets in each requests
4 3 5

Number of tokens present= 3
Number of packets= 4
Packets dropped
Number of tokens remaining=3

Number of tokens present= 6
Number of packets= 3
Packets accepted
Number of tokens remaining=3

Number of tokens present= 6
Number of packets= 5
Packets accepted
Number of tokens remaining=1
*/
