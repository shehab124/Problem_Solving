class Solution {
    public int orangesRotting(int[][] grid) {
                int rows = grid.length;
        int columns = grid[0].length;

        int fresh = 0;
        int maxLevel = 0;
        Queue<int[]> queue = new LinkedList<>();
        int[][] visited = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1)
                    fresh++;
                if (grid[i][j] == 2) {
                    visited[i][j] = 1;
                    int[] rotten = { i, j, 0 };
                    queue.add(rotten);
                }
            }
        }

        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!queue.isEmpty()) {
            int[] current = queue.poll(); // x, y, level

            for (int i = 0; i < 4; i++) {
                int x = current[0] + dirs[i][0];
                int y = current[1] + dirs[i][1];
                int level = current[2] + 1;

                if (x >= 0 && x < rows && y >= 0 && y < columns && visited[x][y] == 0 && grid[x][y] == 1) {
                    visited[x][y] = 1;
                    grid[x][y] = 2;
                    fresh--;
                    queue.add(new int[] { x, y, level });
                    maxLevel = Math.max(maxLevel, level);
                }
            }
        }

        return fresh == 0 ? maxLevel : -1;
    }
}