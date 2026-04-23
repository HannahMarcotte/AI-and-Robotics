import lejos.nxt.*;

import java.util.*;
public class DijkstraRobot {
	
	static int[][] coords = {{0,0},    // 0
        {-10,20}, // 1
        {0,20},   // 2
        {-15,20}, // 3
        {-15,30}, // 4
        {0,30},   // 5
        {10,10},  // 6
        {10,20},  // 7
        {10,30}}; //8
	
	// graph(distance between nodes)
	static int[][] graph = {
        {0,22,20,25,0,0,0,0,0},
        {22,0,10,5,0,0,0,0,0},
        {20,10,0,0,18,10,14,10,18},
        {25,5,0,0,10,18,0,0,0},
        {0,0,18,10,0,15,0,0,0},
        {0,0,10,18,15,0,0,14,10},
        {0,0,14,0,0,0,0,10,0},
        {0,0,10,0,0,14,10,0,10},
        {0,0,18,0,0,10,0,10,0}
    };

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int start = 0;
		int destination = 8; // CHANGE THIS to test different paths
		
		int[] prev = dijkstra(graph, start);
		ArrayList<Integer> path = getPath(prev, destination);
		
		displayPath(path);
		moveRobot(path);
		

	}
	
	public static int[] dijkstra(int[][] graph, int start){
		int n = graph.length;
		int[] dist = new int[n];
		boolean [] visited = new boolean[n];
		int [] prev = new int[n];
		
		for(int i = 0; i < n; i++){
			dist[i] = Integer.MAX_VALUE;
			prev[i] = -1;
		}
		
		dist[start] = 0;
		for(int i = 0; i < n; i++){
			int u = -1;
			for(int j = 0; j < n; j++){
				if(!visited[j]&& (u == -1 || dist[j] < dist[u])){
					u = j;
				}
			}
			
			visited[u] = true;
			
			for(int v = 0; v < n; v++){
				if(graph[u][v] != 0 && dist[u] + graph[u][v] < dist[v]){
					dist[v] = dist[u] + graph[u][v];
					prev[v] = u;
				}
			}
		}
		return prev;
	}
	
	// build path
	public static ArrayList<Integer> getPath(int[] prev, int dest){
		ArrayList<Integer> path = new ArrayList<>();
		
		for(int at = dest; at != -1; at = prev[at]){
			path.add(0, at);
		}
		
		return path;
	}
	
	// display path
	public static void displayPath(ArrayList<Integer> path){
		System.out.print("Path: ");
		for(int node : path){
			System.out.print(node + " ");
		}
		System.out.println();
	}
	
	//robot movement
	public static void moveRobot(ArrayList<Integer> path){
		for(int i = 1; i < path.size(); i++){
			int node = path.get(i);
			
			LCD.clear();
			LCD.drawString("Next Node:", 0, 0);
			LCD.drawString("( " + coords[node][0] + "," + coords[node][1] + ")", 0, 1);
			LCD.drawString("Press Enter", 0, 3);
			
			Button.waitForPress();
			
			moveTo(coords[node][0], coords[node][1]);
		}
		LCD.clear();
		LCD.drawString("Arrived!", 0, 2);
	}
	
	public static void moveTo(int x, int y){
		System.out.println("Moving to: (" + x +"," + y + ")");
		try{
			Thread.sleep(1000);
		}catch(Exception e){}
	}

}
