
/*
 * Undirected graph using adjacency matrix
 */
import java.util.Arrays;
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
                adjacencyMatrix[i][j] = Integer.MAX_VALUE;
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
            int u = queue.poll(); // node to explore

            // exploring
            for (int i = u; i < numVertices; i++) {
                if (adjacencyMatrix[u][i] == 1 && visited[i] == 0) {
                    // visit nodes
                    System.out.println(i);
                    queue.add(i);
                    visited[i] = 1;
                }
            }
        }
    }

    public void DFS(int startingVertex) {
        int[] visited = new int[numVertices];
        DFSRecursive(startingVertex, visited);
    }

    private void DFSRecursive(int vertex, int[] visited) {
        if (visited[vertex] == 0) {
            System.out.println(vertex);
            visited[vertex] = 1;

            for (int i = 0; i < numVertices; i++) {
                if (adjacencyMatrix[vertex][i] == 1 && visited[i] == 0)
                    DFSRecursive(i, visited);
            }
        }
    }

    public int[][] Prim() {
        int[] near = new int[numVertices];
        int[][] t = new int[2][numVertices - 2]; // not counting zero (numVertices - 1) if counting 0

        // initialise near array with max value
        for (int i = 0; i < numVertices; i++)
            near[i] = Integer.MAX_VALUE;

        // find smallest edge
        int u = 0, v = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < numVertices; i++) {
            for (int j = i; j < numVertices; j++) {
                if (adjacencyMatrix[i][j] < min) {
                    u = i;
                    v = j;
                    min = adjacencyMatrix[i][j];
                }
            }
        }

        // set first column of t
        t[0][0] = u;
        t[1][0] = v;

        // set picked edges to 0 since we won't update them again
        near[u] = 0;
        near[v] = 0;

        // fill near array using first edge
        for (int i = 1; i < numVertices; i++) {
            if (near[i] != 0 && adjacencyMatrix[u][i] < adjacencyMatrix[v][i])
                near[i] = u;
            else
                near[i] = v;
        }

        // repeating steps
        for (int i = 1; i < numVertices - 2; i++) {

            // find min in near array
            min = Integer.MAX_VALUE;
            for (int j = 1; j < numVertices; j++) {
                if (near[j] != 0 && adjacencyMatrix[j][near[j]] < min) {
                    min = adjacencyMatrix[j][near[j]];
                    u = j;
                    v = near[j];
                }
            }

            // update near array and t
            near[u] = 0;
            t[0][i] = u;
            t[1][i] = v;
            for (int j = 1; j < numVertices; j++) {
                if (near[j] != 0 && adjacencyMatrix[j][u] < adjacencyMatrix[j][v])
                    near[j] = u;
            }

        }
        return t;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(8);

        graph.addEdge(1, 2, 25);
        graph.addEdge(1, 6, 5);
        graph.addEdge(2, 7, 10);
        graph.addEdge(2, 3, 12);
        graph.addEdge(3, 4, 8);
        graph.addEdge(4, 5, 16);
        graph.addEdge(4, 7, 14);
        graph.addEdge(5, 7, 18);
        graph.addEdge(5, 6, 20);

        int[][] t = graph.Prim();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < t[0].length; j++) {
                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }
    }

}
