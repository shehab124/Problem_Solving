class Solution {

    public static void helper(int vertex, List<List<Integer>> rooms, int[] visited) {
        if (visited[vertex] == 0)
            visited[vertex] = 1;

        int n = rooms.get(vertex).size();
        for (int i = 0; i < n; i++) {
            int x = rooms.get(vertex).get(i);
            if (visited[x] == 0)
                helper(rooms.get(vertex).get(i), rooms, visited);
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        int[] visited = new int[n];

        helper(0, rooms, visited);
        for (int i = 0; i < n; i++)
            if (visited[i] == 0)
                return false;
        return true;
    }
}