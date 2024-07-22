class Solution {
        private static boolean isValid(List<StringBuilder> grid, int n, int row, int column) {
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
    
    

    public static void solve(int row, int n, List<StringBuilder> board, List<List<String>> result)
    {
        if (row == n) 
        {
            List<String> boardCopy = new ArrayList<>();
            for (StringBuilder sb : board) {
                boardCopy.add(sb.toString());
            }
            result.add(boardCopy);
            return;
        }

        for(int i = 0; i < n; i++)
        {
            if(isValid(board, n, row, i))
            {
                board.get(row).setCharAt(i, 'Q');
                
                solve(row + 1, n, board, result);
                
                board.get(row).setCharAt(i, '.');
            }
        }
    }
    

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        
        List<StringBuilder> board = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            StringBuilder row = new StringBuilder();
            row.repeat(".", n);
            board.add(row);
        }

        solve(0, n, board, result);

        return result;
    }
}