// Write a program for congestion control using leaky bucket algorithm.

import java.util.*;

public class leakyBucket{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the bucket size");
		int bsize=sc.nextInt();
		System.out.println("Enter the number of packets");
		int n=sc.nextInt();
		System.out.println("Enter the output packet size");
		int opsize=sc.nextInt();
		int filledBufferSize=0;
		int sizeleft=bsize-filledBufferSize;
		
		for(int i=0;i<n;i++){
			System.out.println("\nPacket-"+(i+1));
			System.out.println("Enter packet size");
			int ipsize=sc.nextInt();
			sizeleft=bsize-filledBufferSize;
			if(sizeleft<=bsize){
				System.out.println("Packet-"+(i+1)+" filled into bucket");
				filledBufferSize+=ipsize;
			}
			else{
				System.out.println("Packet-"+(i+1)+" dropped");
			}
			System.out.println("Filled buffersize: "+filledBufferSize);
			filledBufferSize-=opsize;
		}
	
	}
}
				

/*
Output:

Enter the bucket size
5
Enter the number of packets
3
Enter the output packet size
3

Packet-1
Enter packet size
4
Packet-1 filled into bucket
Filled buffersize: 4

Packet-2
Enter packet size
5
Packet-2 filled into bucket
Filled buffersize: 6

Packet-3
Enter packet size
2
Packet-3 filled into bucket
Filled buffersize: 5
*/
