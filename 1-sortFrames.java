// Write a program to sort frames using appropriate sorting techniques.

import java.util.Scanner;
import java.util.Random;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class sortFrames{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("\nEnter the number of frames: ");
		int n=sc.nextInt();
		List<int[]> frame=new ArrayList<>();
		
		for(int i=0;i<n;i++){
			Random rand=new Random();
			int seqNum=rand.nextInt(1000)+1;
			System.out.printf("Enter data for frame %d: ",i+1);
			int data=sc.nextInt();
			frame.add(new int[]{seqNum,data});
		}
		
		System.out.println("\n\nBefore Sorting: ");
		for(int[] i:frame){
			System.out.printf("seqNum->%d, data->%d\n", i[0],i[1]);
		}
		
		frame=sort(frame);
		
		System.out.println("\n\nAfter Sorting: ");
		for(int[] i:frame){
			System.out.printf("seqNum->%d, data->%d\n", i[0],i[1]);
		}
		
		System.out.println();
	}
	public static List<int[]> sort(List<int[]> frame){
		Collections.sort(frame,(a,b)->Integer.compare(a[0],b[0]));
		return frame;
	}
}


/*
Output:

Enter the number of frames: 
3
Enter data for frame 1: 12
Enter data for frame 2: 56
Enter data for frame 3: 89


Before Sorting: 
seqNum->426, data->12
seqNum->636, data->56
seqNum->683, data->89


After Sorting: 
seqNum->426, data->12
seqNum->636, data->56
seqNum->683, data->89

*/
