class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashSet<Character> set = new HashSet<Character>();

        // rows
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                if(board[i][j] == '.')
                    continue;
                boolean flag = set.add(board[i][j]);
                if(!flag || !( board[i][j] >= '1' && board[i][j] <= '9'))
                    return false;
            }
            set.clear();
        }

        // columns
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                if(board[j][i] == '.')
                    continue;
                boolean flag = set.add(board[j][i]);
                if(!flag || !( board[j][i] >= '1' && board[j][i] <= '9'))
                    return false;
            }
            set.clear();
        }
///////////////////////////////////////////////////////////////////////////
        
        // sub box 0 0
        for (int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++) {
                if (board[i][j] == '.')
                    continue;
                boolean flag = set.add(board[i][j]);
                if (!flag || !(board[i][j] >= '1' && board[i][j] <= '9'))
                    return false;
            }
        }
        set.clear();

        // sub box 0 1
        for (int i = 0; i < 3; i++)
        {
            for(int j = 3; j < 6; j++)
            {
                if(board[i][j] == '.')
                    continue;
                boolean flag = set.add(board[i][j]);
                if(!flag || !( board[i][j] >= '1' && board[i][j] <= '9'))
                    return false;
            }
        }
        set.clear();

        // sub box 0 2
        for (int i = 0; i < 3; i++)
        {
            for(int j = 6; j < 9; j++)
            {
                if(board[i][j] == '.')
                    continue;
                boolean flag = set.add(board[i][j]);
                if(!flag || !( board[i][j] >= '1' && board[i][j] <= '9'))
                    return false;
            }
        }
        set.clear();
///////////////////////////////////////////////////////////////////

        // sub box 1 0
        for (int i = 3; i < 6; i++)
        {
            for(int j = 0; j < 3; j++) {
                if (board[i][j] == '.')
                    continue;
                boolean flag = set.add(board[i][j]);
                if (!flag || !(board[i][j] >= '1' && board[i][j] <= '9'))
                    return false;
            }
        }
        set.clear();

        // sub box  1 1
        for (int i = 3; i < 6; i++)
        {
            for(int j = 3; j < 6; j++)
            {
                if(board[i][j] == '.')
                    continue;
                boolean flag = set.add(board[i][j]);
                if(!flag || !( board[i][j] >= '1' && board[i][j] <= '9'))
                    return false;
            }
        }
        set.clear();

        // sub box 1 2
        for (int i = 3; i < 6; i++)
        {
            for(int j = 6; j < 9; j++)
            {
                if(board[i][j] == '.')
                    continue;
                boolean flag = set.add(board[i][j]);
                if(!flag || !( board[i][j] >= '1' && board[i][j] <= '9'))
                    return false;
            }
        }
        set.clear();
        
////////////////////////////////////////////////////////////////////////////

        // sub box 1 0
        for (int i = 6; i < 9; i++)
        {
            for(int j = 0; j < 3; j++) {
                if (board[i][j] == '.')
                    continue;
                boolean flag = set.add(board[i][j]);
                if (!flag || !(board[i][j] >= '1' && board[i][j] <= '9'))
                    return false;
            }
        }
        set.clear();

        // sub box  1 1
        for (int i = 6; i < 9; i++)
        {
            for(int j = 3; j < 6; j++)
            {
                if(board[i][j] == '.')
                    continue;
                boolean flag = set.add(board[i][j]);
                if(!flag || !( board[i][j] >= '1' && board[i][j] <= '9'))
                    return false;
            }
        }
        set.clear();

        // sub box 1 2
        for (int i = 6; i < 9; i++)
        {
            for(int j = 6; j < 9; j++)
            {
                if(board[i][j] == '.')
                    continue;
                boolean flag = set.add(board[i][j]);
                if(!flag || !( board[i][j] >= '1' && board[i][j] <= '9'))
                    return false;
            }
        }
        set.clear();

        return true;
    }
}
