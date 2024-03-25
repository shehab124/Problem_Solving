class Solution {

    public void helper(int vertex, int[] visited, int[][] isConnected) {

        if (visited[vertex] == 0) {
            visited[vertex] = 1;

            for (int i = 0; i < visited.length; i++) {
                if (isConnected[vertex][i] == 1 && visited[i] == 0)
                    helper(i, visited, isConnected);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int[] visited = new int[isConnected.length];
        int count = 0;

        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i] == 0) {
                helper(i, visited, isConnected);
                count++;
            }
        }
        return count;        
    }
}