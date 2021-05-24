class Solution {
    public int[][] generateMatrix(int n) {
        if(n == 0) return null;
        if(n == 1) return new int[][]{{1}};
        int[][] matrix = new int[n][n];

        //ArrayList<Integer> res = new ArrayList<Integer>();
        //if (matrix.length == 0 || matrix[0].length == 0) return res;
        //int n = matrix.length, m = matrix[0].length, row = 0, col = -1;
        int m = n, row = 0, col = -1, count = 1;
        while (true) {
            for (int i = 0; i < m; ++i){
                matrix[row][++col] = count;
                count++;
            }
            if (--n == 0) break;
            for (int i = 0; i < n; ++i) {
                matrix[++row][col] = count;
                count++;
            }
            if (--m == 0) break;
            for (int i = 0; i < m; ++i){
                matrix[row][--col] = count;
                count++;
            }
            if (--n == 0) break;
            for (int i = 0; i < n; ++i){
                matrix[--row][col] = count;
                count++;
            }
            if (--m == 0) break;
        }

        return matrix;


    }
}
