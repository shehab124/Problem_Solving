class Solution {
    Integer count;

    private boolean isValid(List<StringBuilder> grid, int n, int row, int column) {
        // Check row and column
        for (int i = 0; i < n; i++) {
            if (grid.get(row).charAt(i) == 'Q' || grid.get(i).charAt(column) == 'Q') {
                return false;
            }
        }

        // Check the diagonals
        // Top-left to bottom-right
        for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
            if (grid.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        for (int i = row, j = column; i < n && j < n; i++, j++) {
            if (grid.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        // Top-right to bottom-left
        for (int i = row, j = column; i >= 0 && j < n; i--, j++) {
            if (grid.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        for (int i = row, j = column; i < n && j >= 0; i++, j--) {
            if (grid.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        return true;
    }

    public void solve(int row, int n, List<StringBuilder> board) {
        if (row == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isValid(board, n, row, i)) {
                board.get(row).setCharAt(i, 'Q');

                solve(row + 1, n, board);

                board.get(row).setCharAt(i, '.');
            }
        }
    }

    public int totalNQueens(int n) {
        count = 0;

        List<StringBuilder> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder();
            row.repeat(".", n);
            board.add(row);
        }

        solve(0, n, board);

        return count;
    }
}