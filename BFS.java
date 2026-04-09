import lejos.nxt.*;

// Node with coordinates
class Node {
    String name;
    int x, y;

    Node(String n, int xVal, int yVal) {
        name = n;
        x = xVal;
        y = yVal;
    }
}

public class BFS {

    static String[] nodes = {
        "A","B","C","D","E","F","G","H","I","J","K","L","M"
    };

    // Adjacency list using arrays
    static String[][] graph = {
        {"B","C"},     // A
        {"D","E"},     // B
        {"F","G"},     // C
        {},            // D
        {"H"},         // E
        {},            // F
        {"I"},         // G
        {"J","K"},     // H
        {},            // I
        {"L"},         // J
        {"M"},         // K
        {},            // L
        {}             // M
    };

    static Node[] coords = {
        new Node("A",0,0),
        new Node("B",-5,-5),
        new Node("C",5,-5),
        new Node("D",-10,-10),
        new Node("E",0,-10),
        new Node("F",-5,-15),
        new Node("G",5,-15),
        new Node("H",0,-20),
        new Node("I",10,-20),
        new Node("J",-5,-25),
        new Node("K",5,-25),
        new Node("L",-10,-30),
        new Node("M",0,-30)
    };

    static int getIndex(String name) {
        for(int i=0; i<nodes.length; i++) {
            if(nodes[i].equals(name)) return i;
        }
        return -1;
    }

    public static void main(String[] args) {

        String start = "A";
        String goal = "I"; // change this

        int[] path = bfs(start, goal);

        if(path == null) {
            LCD.drawString("No Path",0,0);
            Button.waitForPress();
        } else {
            moveRobot(path);
        }
    }

    
    static int[] bfs(String start, String goal) {

        int startIndex = getIndex(start);
        int goalIndex = getIndex(goal);

        boolean[] visited = new boolean[nodes.length];
        int[] parent = new int[nodes.length];

        for(int i=0;i<parent.length;i++) parent[i] = -1;

        int[] queue = new int[50];
        int front = 0, rear = 0;

        queue[rear++] = startIndex;
        visited[startIndex] = true;

        while(front < rear) {

            int current = queue[front++];

            if(current == goalIndex) {
                return buildPath(parent, startIndex, goalIndex);
            }

            for(int i=0; i<graph[current].length; i++) {
                int next = getIndex(graph[current][i]);

                if(!visited[next]) {
                    visited[next] = true;
                    parent[next] = current;
                    queue[rear++] = next;
                }
            }
        }

        return null;
    }

    // build path
    static int[] buildPath(int[] parent, int start, int goal) {

        int[] temp = new int[50];
        int count = 0;

        int current = goal;

        while(current != -1) {
            temp[count++] = current;
            current = parent[current];
        }

        int[] path = new int[count];

        for(int i=0; i<count; i++) {
            path[i] = temp[count - i - 1];
        }

        return path;
    }

    // move step-by-step
    static void moveRobot(int[] path) {

        for(int i=1; i<path.length; i++) {

            Node n = coords[path[i]];

            LCD.clear();
            LCD.drawString("Next:",0,0);
            LCD.drawString(n.name,0,1);
            LCD.drawString(n.x + "," + n.y,0,2);
            LCD.drawString("ENTER",0,4);

            Button.waitForPress();

            moveTo();
        }

        LCD.clear();
        LCD.drawString("Arrived!",0,2);
        Button.waitForPress();
    }

    // simple movement
    static void moveTo() {

        Motor.A.forward();
        Motor.B.forward();

        try { Thread.sleep(1000); }
        catch(Exception e) {}

        Motor.A.stop();
        Motor.B.stop();
    }
}