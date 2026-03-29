import lejos.nxt.*;

public class PathTraversal {

	/**
	 * Name: Hannah Marcotte
	 * Class:AI & Robotics
	 * File: PathTraversal
	 * Description:
	 * This program uses Depth First Search(DFS) to find a path
	 * from node A to a destination node using NXT
	 * @param args
	 */
	
	// graph using adjacency list
	static String[] nodes = {
        "A","B","C","D","E","F","G","H","I","J","K","L","M"
    };

    // Adjacency list using indices
    static int[][] graph = {
        {1, 2},      // A -> B, C
        {3, 4},      // B -> D, E
        {4},         // C -> E
        {5},         // D -> F
        {5, 6},      // E -> F, G
        {7},         // F -> H
        {7},         // G -> H
        {8, 9},      // H -> I, J
        {10},        // I -> K
        {11, 12},    // J -> L, M
        {12},        // K -> M
        {12},        // L -> M
        {}           // M
    };

    static boolean[] visited = new boolean[13];
    static int[] path = new int[13];
    static int pathIndex = 0;
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// change destination here
		String destination = "E";
		int destIndex = getIndex(destination);
		for(int i = 0; i< visited.length;i++){
			visited[i] = false;
		}
		pathIndex=0;
		LCD.clear();
		LCD.drawString("Dest: " + destination, 0, 0);
		if (destIndex == -1) {
	        LCD.drawString("Invalid Dest", 0, 1);
	    } else if (dfs(0, destIndex)) {
	        displayPath();
	    } else {
	        LCD.drawString("No Path Found", 0, 2);
	    }

	    Button.waitForPress();

	}
	
	public static boolean dfs(int current, int destination){
		visited[current] = true;
        path[pathIndex] = current;
        pathIndex++;

        if (current == destination) {
            return true;
        }

        for (int i = 0; i < graph[current].length; i++) {
            int neighbor = graph[current][i];

            if (!visited[neighbor]) {
                if (dfs(neighbor, destination)) {
                    return true;
                }
            }
        }

        // Backtrack
        pathIndex--;
        return false;
	}
	
	// covert node letter to index
	public static int getIndex(String node){
		if (node == null || node.length() != 1) {
            return -1;
        }

        char c = node.charAt(0);

        if (c >= 'A' && c <= 'M') {
            return c - 'A';   
        }

        return -1;
	}
	
	
	public static void displayPath() {

		LCD.drawString("Path:", 0, 2);

        String output = "";

        for (int i = 0; i < pathIndex; i++) {
            output += nodes[path[i]];
            if (i != pathIndex - 1) {
                output += "->";
            }
        }

        // Handle screen width (16 chars)
        if (output.length() > 16) {
            LCD.drawString(output.substring(0, 16), 0, 3);
            LCD.drawString(output.substring(16), 0, 4);
        } else {
            LCD.drawString(output, 0, 3);
        }
    }

}
