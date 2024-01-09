// Write a program to implement random early detection (RED) congestion control algorithm.

import java.util.*;

public class RED{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		Random rand=new Random();
		
		float maxProb=0.7F, minProb=0.3F, dropProb=minProb;
		System.out.println("Enter the queue size: ");
		int queueSize=sc.nextInt();
		System.out.println("Enter the number of packets: ");
		int n=sc.nextInt();
		
		int queueLen=0;
		
		for(int i=1;i<=n;i++){
			if(queueLen>=queueSize)
				System.out.println("Packet-"+i+" dropped (Queue full)");
			else if(rand.nextFloat()<dropProb){
				System.out.println("Packet-"+i+" dropped (Random)");
				dropProb+=(maxProb-minProb)/(n-1);
			}
			else{
				System.out.println("Packet-"+i+" accepted");
				queueLen++;
				dropProb=minProb;
			}	
		}
	}
}


/*
Output:
------------------------------------------
Enter the queue size: 
10
Enter the number of packets: 
12
Packet-1 accepted
Packet-2 accepted
Packet-3 accepted
Packet-4 dropped (Random)
Packet-5 accepted
Packet-6 dropped (Random)
Packet-7 accepted
Packet-8 dropped (Random)
Packet-9 accepted
Packet-10 dropped (Random)
Packet-11 accepted
Packet-12 accepted
-------------------------------------------
Enter the queue size: 
5
Enter the number of packets: 
12
Packet-1 accepted
Packet-2 accepted
Packet-3 accepted
Packet-4 accepted
Packet-5 dropped (Random)
Packet-6 dropped (Random)
Packet-7 accepted
Packet-8 dropped (Queue full)
Packet-9 dropped (Queue full)
Packet-10 dropped (Queue full)
Packet-11 dropped (Queue full)
Packet-12 dropped (Queue full)
------------------------------------------
*/
		
