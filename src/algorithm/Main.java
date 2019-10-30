package algorithm;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		
		int notWised = Integer.MAX_VALUE;
		int graphArr[][] = {{0, 1, notWised, 1, 5},
						 {9, 0, 3, 2, notWised},
						 {notWised, notWised, 0, 4, notWised},
						 {notWised, notWised, 2, 0, 3},
						 {3, notWised, notWised, notWised, 0}};
		/*
		 * 
		 * Show Edges with List
		Node graph[] = new Node[graphArr.length];
		for(int i = 0; i < graph.length; i++) {
			graph[i] = new Node(i);
		}
		for(int i = 0; i < graphArr.length; i++) {
			for(int j = 0; j < graphArr[i].length; j++) {
				if(graphArr[i][j] == 0 || graphArr[i][j] == notWised) continue;
				Edge edge = new Edge(graphArr[i][j], j);
				graph[i].addEdge(edge);
			}
		}
		for(int i = 0; i < graph.length; i++) {
			graph[i].showEdge();
		}
		*/
		
		// Shortest path with Array
		for(int k = 0; k < graphArr.length; k++) {
			for(int i = 0; i < graphArr.length; i++) {
				for(int j = 0; j < graphArr[i].length; j++) {
					if(graphArr[i][k] != notWised && graphArr[k][j] != notWised) {
						graphArr[i][j] = Main.min(graphArr[i][j], graphArr[i][k] + graphArr[k][j]);	
					}
				}
			}
		}
		for(int i = 0 ; i < graphArr.length; i++) {
			for(int j = 0; j < graphArr[i].length; j++) {
				System.out.print(graphArr[i][j] + "\t");
			}
			System.out.println();
		}
	}
	private static int min(int num1, int num2) {
		if(num1 == Integer.MAX_VALUE) {
			return num2;
		}
		return (num1 < num2) ? num1 : num2;
	}
}
