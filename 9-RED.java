//

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
		
		for(int i=0;i<n;i++){
			if(queueLen>=queueSize)
				System.out.println("Packet-"+i+" dropped (Queue full)");
			else if(rand.nextFloat()<dropProb){
				System.out.println("Packet-"+i+" dropped (Random)");
				dropProb+=(maxProb-minProb)/(n-1);
			}
			else{
				System.out.println("Packet accepted");
				queueLen++;
				dropProb=minProb;
			}	
		}
	}
}
				
		
/*
Output:
------------------------------
Enter the queue size: 
10
Enter the number of packets: 
12
Packet-0 dropped (Random)
Packet accepted
Packet accepted
Packet accepted
Packet accepted
Packet accepted
Packet accepted
Packet accepted
Packet accepted
Packet-9 dropped (Random)
Packet-10 dropped (Random)
Packet accepted
-------------------------------
Enter the queue size: 
10
Enter the number of packets: 
15
Packet accepted
Packet accepted
Packet-2 dropped (Random)
Packet accepted
Packet accepted
Packet-5 dropped (Random)
Packet accepted
Packet-7 dropped (Random)
Packet accepted
Packet accepted
Packet accepted
Packet accepted
Packet-12 dropped (Random)
Packet accepted
Packet-14 dropped (Queue full)
-------------------------------
*/
