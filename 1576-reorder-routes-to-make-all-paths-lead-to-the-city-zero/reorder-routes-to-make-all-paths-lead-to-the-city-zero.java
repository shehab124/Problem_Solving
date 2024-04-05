class Solution {

    private class Edge {
        public int destination;
        public int weight;

        Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    public int res = 0;

    public void dfs(int vertex, HashMap<Integer, ArrayList<Edge>> graph, int[] visited) {
        if (visited[vertex] == 0) {
            visited[vertex] = 1;

            ArrayList<Edge> neighbors = graph.get(vertex);
            for (Edge e : neighbors) {
                if (visited[e.destination] == 0) {
                    if (e.weight == 0)
                        res++;
                    dfs(e.destination, graph, visited);
                }
            }
        }
    }

    public int minReorder(int n, int[][] connections) {
        HashMap<Integer, ArrayList<Edge>> graph = new HashMap<>();

        // create graph
        for (int i = 0; i < n - 1; i++) {
            int from = connections[i][0];
            int to = connections[i][1];

            if (!graph.containsKey(from)) {
                ArrayList<Edge> list = new ArrayList<>();
                list.add(new Edge(to, 0));
                graph.put(from, list);
            } else {
                ArrayList<Edge> list = graph.get(from);
                list.add(new Edge(to, 0));
            }

            if (!graph.containsKey(to)) {
                ArrayList<Edge> list = new ArrayList<>();
                list.add(new Edge(from, 1));
                graph.put(to, list);
            } else {
                ArrayList<Edge> list = graph.get(to);
                list.add(new Edge(from, 1));
            }
        }

        int[] visited = new int[n];
        dfs(0, graph, visited);

        return res;
    }
}   