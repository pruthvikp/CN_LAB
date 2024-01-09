// Write a program to find the shortest path between vertices using bellman-ford algorithm.

import java.util.*;

public class bellmanFord{
	private static int n;
	private static int[][] graph;
	
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of vertices");
		n=sc.nextInt();
		System.out.println("Enter the weighted matrix:");
		graph=new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				graph[i][j]=sc.nextInt();
			}
		}
		System.out.println("Enter the source vertex:");
		int src=sc.nextInt();
		BellmanFord(src-1);
	}
	
	public static void BellmanFord(int src){
		int[] dist=new int[n];
		Arrays.fill(dist,Integer.MAX_VALUE);
		dist[src]=0;
		
		for(int i=0;i<n;i++){
			for(int u=0;u<n;u++){
				for(int v=0;v<n;v++){
					if(graph[u][v]!=0 && dist[u]!=Integer.MAX_VALUE && dist[u]+graph[u][v]<dist[v]){
						dist[v]=dist[u]+graph[u][v];
					}
				}
			}
		}
		
		for(int u=0;u<n;u++){
			for(int v=0;v<n;v++){
				if(graph[v][u]!=0 && dist[u]!=Integer.MAX_VALUE && dist[u]+graph[u][v]<dist[v]){
					System.out.println("Negative weight cycle detected");
					return;
				}
			}
		}
	
		System.out.println("Vertex\t\tDistance from source");
		for(int i=0;i<n;i++){
			System.out.println((i+1)+"\t\t"+(dist[i]));
		}
    
	}
  
}

		
/*
Output:
------------------------------------
Enter the number of vertices
4
Enter the weighted matrix:
0 8 5 0
0 0 0 1
0 2 0 4
0 0 0 0
Enter the source vertex:
1
Vertex		Distance from source
1		0
2		7
3		5
4		8
-------------------------------------
Enter the number of vertices
4
Enter the weighted matrix:
0 -2 0 2
0 0 -3 0
0 0 0 -1
0 0 0 0
Enter the source vertex:
1
Negative weight cycle detected
-------------------------------------
*/
