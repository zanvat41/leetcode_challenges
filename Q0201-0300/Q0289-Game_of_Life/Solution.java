class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int neighbors = 0; // live neighbors

                // top
                if(i - 1 >=0 && board[i-1][j] % 10 == 1) neighbors++;
                // bottom
                if(i + 1 < m && board[i+1][j] % 10 == 1) neighbors++;
                // left
                if(j - 1 >=0 && board[i][j-1] % 10 == 1) neighbors++;
                // right
                if(j + 1 < n && board[i][j+1] % 10 == 1) neighbors++;
                // top left
                if(i - 1 >=0 && j-1 >= 0 && board[i-1][j-1] % 10 == 1) neighbors++;
                // top right
                if(i - 1 >=0 && j+1 < n && board[i-1][j+1] % 10 == 1) neighbors++;
                // bottom left
                if(i + 1 < m && j-1 >= 0 && board[i+1][j-1] % 10 == 1) neighbors++;
                // bottom right
                if(i + 1 < m && j+1 < n && board[i+1][j+1] % 10 == 1) neighbors++;

                // 11 means live now but dead next
                if((neighbors < 2 || neighbors > 3) && board[i][j] == 1) board[i][j] = 11;
                // 10 means dead now but live next
                if(neighbors == 3 && board[i][j] == 0) board[i][j] = 10;
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 10) board[i][j] = 1;
                if(board[i][j] == 11) board[i][j] = 0;
            }
        }

    }
}