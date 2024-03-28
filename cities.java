import java.util.ArrayList;
import java.util.List;

class Ayhaga {
    int ans;
    List<List<int[]>> g;

    public void dfs(int start, int par) {
        for (int[] u : g.get(start)) {
            if (u[0] == par)
                continue;
            else {
                if (u[1] == 1)
                    ans++;
                dfs(u[0], start);
            }
        }
    }

    public int minReorder(int n, int[][] connections) {
        ans = 0;
        g = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }

        // adjacency list
        for (int i = 0; i < connections.length; i++) {
            int from = connections[i][0];
            int to = connections[i][1];
            g.get(from).add(new int[] { to, 1 }); // original
            g.get(to).add(new int[] { from, 0 }); // artificial
        }

        // print
        for (int i = 0; i < n; i++) {
            System.out.print("Node " + i + ": ");
            for (int[] neighbor : g.get(i)) {
                System.out.print("(" + neighbor[0] + "," + neighbor[1] + ") ");
            }
            System.out.println();
        }

        dfs(0, -1);
        return ans;
    }

    public static void main(String[] args) {
        Ayhaga solution = new Ayhaga();

        int n = 6;
        int[][] connections = {
                { 0, 1 },
                { 1, 3 },
                { 2, 3 },
                { 4, 0 },
                { 4, 5 }
        };

        int result = solution.minReorder(n, connections);
    }
}
