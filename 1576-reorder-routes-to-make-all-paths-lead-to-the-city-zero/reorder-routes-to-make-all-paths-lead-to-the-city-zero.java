import java.util.ArrayList;
import java.util.List;

class Solution {
    int ans;
    List<List<int[]>> g = new ArrayList<>();

    public void dfs(int start, int par) {
        for (int[] u : g.get(start)) {
            if (u[0] == par) continue;
            else {
                if (u[1] == 1) ans++;
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

        for (int[] x : connections) {
            g.get(x[0]).add(new int[]{x[1], 1});
            g.get(x[1]).add(new int[]{x[0], 0});
        }

        dfs(0, -1);
        return ans;
    }
}
