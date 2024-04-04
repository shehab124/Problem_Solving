class Solution {

    private class Edge {
        public String destination;
        public double weight;

        Edge(String destination, double weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    public double dfs(String src, String dst, Map<String, List<Edge>> graph, Set<String> visited) {

        if (src.equals(dst))
            return 1;

        visited.add(src);
        for (int i = 0; i < graph.get(src).size(); i++) {
            if (!visited.contains(graph.get(src).get(i).destination)) {
                double result = dfs(graph.get(src).get(i).destination, dst, graph, visited);
                if (result != -1) {
                    return result * graph.get(src).get(i).weight;
                }
            }
        }
        return -1;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] ans = new double[queries.size()];
        Map<String, List<Edge>> list = new HashMap<>();

        // create graph
        for (int i = 0; i < equations.size(); i++) {
            String from = equations.get(i).get(0);
            String to = equations.get(i).get(1);
            double weight = values[i];

            if (!list.containsKey(from))
                list.put(from, new ArrayList<>());

            list.get(from).add(new Edge(to, weight));

            if (!list.containsKey(to))
                list.put(to, new ArrayList<>());

            list.get(to).add(new Edge(from, 1.0 / weight));
        }

        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dst = queries.get(i).get(1);
            if (!list.containsKey(src) || !list.containsKey(dst))
                ans[i] = -1;
            else {
                Set<String> visited = new TreeSet<>();
                ans[i] = dfs(src, dst, list, visited);

            }
        }
        return ans;
    }
}