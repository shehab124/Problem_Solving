class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        int[] visited = new int[n];
        visited[0] = 1;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < rooms.get(0).size(); i++) {
            queue.add(rooms.get(0).get(i));
            visited[rooms.get(0).get(i)] = 1;
        }

        while (!queue.isEmpty()) {
            int vertex = queue.poll();

            for (int i = 0; i < rooms.get(vertex).size(); i++) {
                if (visited[rooms.get(vertex).get(i)] == 0) {
                    visited[rooms.get(vertex).get(i)] = 1;
                    queue.add(rooms.get(vertex).get(i));
                }
            }
        }
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0)
                return false;
        }
        return true;
    }
}