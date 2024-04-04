import java.util.*;

public class GraphAdjMatrix {
    private int V;
    private int[][] adjMatrix;

    public GraphAdjMatrix(int vertices){
        V = vertices;
        adjMatrix = new int[V][V];
    }

    public void addEdge(int source, int destination, int weight){
        adjMatrix[source][destination] = weight;
        adjMatrix[destination][source] = weight;
    }

    public void printGraph(){
        for(int i = 0; i < V; i++) {
            for(int j = 0; j < V; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isConnected() {
        boolean[] visited = new boolean[V];
        DFSUtil(0, visited);
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                return false;
            }
        }
        return true;
    }

    private void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        for (int i = 0; i < V; i++){
            if(adjMatrix[v][i] != 0 && !visited[i]) {
                DFSUtil(i, visited);
            }
        }
    }


    public int[] shortestPath(int source) {
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, visited);
            visited[u] = true;

            for (int v = 0; v < V; v++) {
                if (!visited[v] && adjMatrix[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + adjMatrix[u][v] < dist[v]) {
                    dist[v] = dist[u] + adjMatrix[u][v];
                }
            }
        }

        return dist;
    }

    private int minDistance(int[] dist, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }

        return minIndex;
    }



    public static void main(String[] args) {
        // Create a graph with 5 vertices
        GraphAdjMatrix graph = new GraphAdjMatrix(5);

        // Add edges with weights
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 4, 1);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 5);
        graph.addEdge(1, 4, 2);
        graph.addEdge(2, 3, 1);
        graph.addEdge(3, 4, 4);

        // Print the adjacency matrix representation of the graph
        System.out.println("Adjacency Matrix Representation:");
        graph.printGraph();

        // Check if the graph is connected
        System.out.println("Is connected: " + graph.isConnected());

        // Find shortest paths from vertex 0
        int[] shortestPaths = graph.shortestPath(0);
        System.out.println("\nShortest paths from vertex 0:");
        for (int i = 0; i < shortestPaths.length; i++) {
            System.out.println("Vertex " + i + ": " + shortestPaths[i]);
        }
    }


}
