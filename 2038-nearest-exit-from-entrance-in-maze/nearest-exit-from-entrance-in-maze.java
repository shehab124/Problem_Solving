class Solution {
   public class Node implements Comparable<Node> {
        public int x, y;
        public int level;

        public Node(int x, int y, int level) {
            this.x = x;
            this.y = y;
            this.level = level;
        }

        // Implementing equals() method to define equality based on x and y only
        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Node)) {
                return false;
            }
            Node other = (Node) obj;
            return this.x == other.x && this.y == other.y;
        }

        // Implementing hashCode() method to generate hash code based on x and y only
        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + x;
            result = 31 * result + y;
            return result;
        }

        @Override
        public int compareTo(Node other) {
            if (this.x != other.x) {
                return Integer.compare(this.x, other.x);
            }
            // Compare only the y field
            return Integer.compare(this.y, other.y);
        }
    }

    public ArrayList<Node> getNeighbors(Node node, char[][] maze) {
        ArrayList<Node> list = new ArrayList<>();

        // up
        if (node.x - 1 >= 0 && maze[node.x - 1][node.y] == '.')
            list.add(new Node(node.x - 1, node.y, node.level + 1));

        // down
        if (node.x + 1 < maze.length && maze[node.x + 1][node.y] == '.')
            list.add(new Node(node.x + 1, node.y, node.level + 1));

        // right
        if (node.y + 1 < maze[0].length && maze[node.x][node.y + 1] == '.')
            list.add(new Node(node.x, node.y + 1, node.level + 1));

        // left
        if (node.y - 1 >= 0 && maze[node.x][node.y - 1] == '.')
            list.add(new Node(node.x, node.y - 1, node.level + 1));

        return list;
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<Node> queue = new LinkedList<>();
        Node start = new Node(entrance[0], entrance[1], 0);

        Set<Node> visited = new TreeSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            ArrayList<Node> neighbors = getNeighbors(current, maze);
            for (Node neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                    if (neighbor.x == 0 || neighbor.y == 0 || neighbor.x == maze.length - 1
                            || neighbor.y == maze[0].length - 1)
                        return neighbor.level;
                }

            }
        }

        return -1;
    }
}