class Solution {

    static boolean result;

    // prev
    /*
     * 0 up
     * 1 down
     * 2 right
     * 3 left
     */
    private static void helper(char[][] board, String word, StringBuilder current, int currentIndex, int i, int j,
            boolean[][] visited) {
        if (word.equals(current.toString())) {
            result = true;
            return;
        }

        // up
        if (i - 1 >= 0) {
            if (word.charAt(currentIndex) == board[i - 1][j] && visited[i - 1][j] == false) {
                current.append(word.charAt(currentIndex));
                currentIndex++;
                i--;
                visited[i][j] = true;

                helper(board, word, current, currentIndex, i, j, visited);

                current.deleteCharAt(current.length() - 1);
                currentIndex--;
                visited[i][j] = false;
                i++;
            }
        }

        // down
        if (i + 1 < board.length) {
            if (word.charAt(currentIndex) == board[i + 1][j] && visited[i + 1][j] == false) {
                current.append(word.charAt(currentIndex));
                currentIndex++;
                i++;
                visited[i][j] = true;

                helper(board, word, current, currentIndex, i, j, visited);

                current.deleteCharAt(current.length() - 1);
                currentIndex--;
                visited[i][j] = false;
                i--;
            }
        }

        // right
        if (j + 1 < board[0].length) {
            if (word.charAt(currentIndex) == board[i][j + 1] && visited[i][j + 1] == false) {
                current.append(word.charAt(currentIndex));
                currentIndex++;
                j++;
                visited[i][j] = true;

                helper(board, word, current, currentIndex, i, j, visited);

                current.deleteCharAt(current.length() - 1);
                currentIndex--;
                visited[i][j] = false;
                j--;

            }
        }

        // left
        if (j - 1 >= 0) {
            if (word.charAt(currentIndex) == board[i][j - 1] && visited[i][j - 1] == false) {
                current.append(word.charAt(currentIndex));
                currentIndex++;
                j--;
                visited[i][j] = true;

                helper(board, word, current, currentIndex, i, j, visited);

                current.deleteCharAt(current.length() - 1);
                currentIndex--;
                visited[i][j] = false;
                j++;
            }
        }

    }

    public static boolean exist(char[][] board, String word) {
        result = false;
        StringBuilder current = new StringBuilder();
        boolean[][] visited = new boolean[board.length][board[0].length];

        // find first character
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    current.append(board[i][j]);
                    visited[i][j] = true;
                    helper(board, word, current, 1, i, j, visited);
                    current.deleteCharAt(current.length() - 1);
                    visited[i][j] = false;
                    if (result == true)
                        return true;
                }
            }
        }

        return false;
    }
}