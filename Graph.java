
/*
 * Undirected graph using adjacency matrix
 */
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    private int[][] adjacencyMatrix;
    private int numVertices;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjacencyMatrix = new int[numVertices][numVertices];

        for (int i = 0; i < numVertices; i++)
            for (int j = 0; j < numVertices; j++)
                adjacencyMatrix[i][j] = 0;
    }

    public void addEdge(int source, int destination, int weight) {
        adjacencyMatrix[source][destination] = weight;
        adjacencyMatrix[destination][source] = weight;
    }

    public void removeEdge(int source, int destination) {
        adjacencyMatrix[source][destination] = 0;
        adjacencyMatrix[destination][source] = 0;
    }

    public boolean hasEdge(int source, int destination) {
        if (adjacencyMatrix[source][destination] == 1)
            return true;
        else
            return false;
    }

    public int getWeight(int source, int destination) {
        return adjacencyMatrix[source][destination];
    }

    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public void printAdjacencyMatrix() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void BFS(int startingVertex) {
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[numVertices];

        visited[startingVertex] = 1;
        queue.add(startingVertex);
        System.out.println(startingVertex);

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int i = u; i < numVertices; i++) {
                if (adjacencyMatrix[u][i] == 1 && visited[i] == 0) {
                    System.out.println(i);
                    queue.add(i);
                    visited[i] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(8);

        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 1);
        graph.addEdge(1, 4, 1);
        graph.addEdge(2, 3, 1);
        graph.addEdge(3, 4, 1);
        graph.addEdge(3, 5, 1);
        graph.addEdge(4, 5, 1);
        graph.addEdge(5, 6, 1);
        graph.addEdge(5, 7, 1);

        // graph.printAdjacencyMatrix();

        graph.BFS(1);
    }

}
