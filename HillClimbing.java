import lejos.nxt.*;

import java.util.*;

class Node{
	String name;
	int x, y;
	List<Node> neighbors;
	
	Node(String name, int x, int y){
		this.name = name;
		this.x = x;
		this.y = y;
		neighbors = new ArrayList<Node>();
	}
	void addNeighbor(Node n){
		neighbors.add(n);
	}
}
public class HillClimbing {
	public static double distance(Node a, Node b){
		return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
		
	}
	
	public static void main(String[] args){
		 Node A = new Node("A", 0, 0);
	     Node B = new Node("B", -10, 20);
	     Node C = new Node("C", -15, 20);
	     Node D = new Node("D", 0, 20);
	     Node E = new Node("E", 0, 30);
	     Node F = new Node("F", -15, 30);
	     Node G = new Node("G", 10, 20);
	     Node H = new Node("H", 10, 10);
	     
	     A.addNeighbor(B);
	     A.addNeighbor(D);

	     B.addNeighbor(A);
	     B.addNeighbor(C);

	     C.addNeighbor(B);
	     C.addNeighbor(F);

	     D.addNeighbor(A);
	     D.addNeighbor(E);
	     D.addNeighbor(H);

	     E.addNeighbor(D);
	     E.addNeighbor(F);

	     F.addNeighbor(C);
	     F.addNeighbor(E);

	     G.addNeighbor(H);

	     H.addNeighbor(D);
	     H.addNeighbor(G);
	     
	     Node current = A;
	     Node goal = E;
	     
	     while (!current.name.equals(goal.name)) {

	            Node best = null;
	            double bestDistance = Double.MAX_VALUE;

	            // Check all neighbors and pick closest to goal
	            for (Node neighbor : current.neighbors) {
	                double d = distance(neighbor, goal);

	                if (d < bestDistance) {
	                    bestDistance = d;
	                    best = neighbor;
	                }
	            }
	            
	            if (best == null) {
	                LCD.clear();
	                LCD.drawString("No path found", 0, 2);
	                Button.waitForPress();
	                return;
	            }

	            // -----------------------------
	            // DISPLAY NEXT MOVE
	            // -----------------------------
	            LCD.clear();
	            LCD.drawString("Next Node: " + best.name, 0, 0);
	            LCD.drawString("Coord:", 0, 1);
	            LCD.drawString("(" + best.x + "," + best.y + ")", 0, 2);
	            LCD.drawString("Press ENTER", 0, 4);

	            // Wait for user input
	            Button.waitForPress();
	            current = best;
	     }
	        LCD.clear();
	        LCD.drawString("Arrived at " + goal.name, 0, 2);
	        LCD.drawString("(" + goal.x + "," + goal.y + ")", 0, 3);
	        Button.waitForPress();
	        
	}

}
