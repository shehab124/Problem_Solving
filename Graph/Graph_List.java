package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Graph_List {

    private static class Edge {
        int destination;
        int weight;

        Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    private Map<Integer, List<Edge>> adjacencyList;

    Graph_List() {
        this.adjacencyList = new HashMap<>();
    }

    public void addVertex(int vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(int source, int destination, int weight) {
        if (!adjacencyList.containsKey(source))
            addVertex(source);
        if (!adjacencyList.containsKey(destination))
            addVertex(destination);

        adjacencyList.get(source).add(new Edge(destination, weight));
    }

    public List<Edge> getNeighbors(int vertex) {
        return adjacencyList.get(vertex);
    }

    public void printGraph() {
        for (Integer vertex : adjacencyList.keySet()) {
            System.out.print("Vertex " + vertex + " -> ");
            List<Edge> edges = adjacencyList.get(vertex);
            for (Edge edge : edges) {
                System.out.print("(" + edge.destination + ", " + edge.weight + ") ");
            }
            System.out.println();
        }
    }

    private void dfsHelper(int vertex, int[] visited) {
        if (visited[vertex] == 0) {
            visited[vertex] = 1;
            System.out.println(vertex);

            for (int i = 0; i < adjacencyList.get(vertex).size(); i++) {
                if (visited[adjacencyList.get(vertex).get(i).destination] == 0)
                    dfsHelper(adjacencyList.get(vertex).get(i).destination, visited);
            }
        }
    }

    public void DFS(int startingVertex) {
        int[] visited = new int[adjacencyList.size() + 1];
        dfsHelper(startingVertex, visited);
    }

    public void BFS(int startingVertex) {
        int[] visited = new int[adjacencyList.size() + 1];
        Queue<Integer> queue = new LinkedList<>();

        visited[startingVertex] = 1;
        System.out.println(startingVertex);
        queue.add(startingVertex);

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int i = 0; i < adjacencyList.get(u).size(); i++) {
                if (visited[adjacencyList.get(u).get(i).destination] == 0) {
                    System.out.println(adjacencyList.get(u).get(i).destination);
                    visited[adjacencyList.get(u).get(i).destination] = 1;
                    queue.add(adjacencyList.get(u).get(i).destination);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph_List graph = new Graph_List();

        graph.addEdge(1, 2, 5);
        graph.addEdge(1, 3, 3);
        graph.addEdge(1, 4, 2);
        graph.addEdge(2, 1, 6);
        graph.addEdge(2, 3, 7);
        graph.addEdge(3, 2, 7);
        graph.addEdge(3, 1, 7);
        graph.addEdge(3, 4, 7);
        graph.addEdge(4, 1, 7);
        graph.addEdge(4, 3, 7);
        graph.addEdge(4, 5, 7);
        graph.addEdge(3, 5, 7);
        graph.addEdge(5, 4, 0);

        // System.out.println("Directed Weighted Graph:");
        // graph.printGraph();
        graph.BFS(1);
    }

}
