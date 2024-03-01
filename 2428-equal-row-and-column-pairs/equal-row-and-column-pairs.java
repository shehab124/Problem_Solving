class Solution {
    public int equalPairs(int[][] grid) {
        int res = 0;
        HashMap<String, Integer> rows = new HashMap<>();
        ArrayList<String> columns = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            int[] row = grid[i];
            int[] column = new int[grid.length];

            for (int j = 0; j < grid.length; j++) {
                column[j] = grid[j][i];
            }
            columns.add(Arrays.toString(column));
            String rowStr = Arrays.toString(row);
            rows.put(rowStr, (rows.getOrDefault(rowStr, 0) + 1));
        }

        for (int i = 0; i < columns.size(); i++) {
            String col = columns.get(i);

            if (rows.containsKey(col))
                res += rows.get(col);
        }

        return res;
    }
}