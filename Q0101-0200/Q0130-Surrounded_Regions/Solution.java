class Solution {
    int n, m;
    public void solve(char[][] board) {
        n = board.length;
        m = board[0].length;

        // do dfs on all the O's on 2nd and (m-1)th columns
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 1);
            }
            if (board[i][m - 1] == 'O') {
                dfs(board, i, m - 2);
            }
        }

        // do dfs on all the O's on 2nd and (n-1)th rows
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 1, j);
            }
            if (board[n - 1][j] == 'O') {
                dfs(board, n - 2, j);
            }
        }
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    private void dfs(char[][] board, int i, int j) {
        if (i >= n - 1 || i <= 0 || j >= m - 1 || j <= 0 || board[i][j] == 'X' || board[i][j] == '*') {
            return;
        }
        if (board[i][j] == 'O') {
            board[i][j] = '*';
        }
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}
