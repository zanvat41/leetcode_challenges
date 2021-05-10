class Solution {
    public int uniquePaths(int m, int n) {
        int[] ways = new int[n];
        // last col, all 1's
        for (int i = 0; i < n; i++){
            ways[i] = 1;
        }
        for (int i = m - 1; i > 0; i--){
            for (int j = n-2; j >= 0; j--){
                ways[j] = ways[j+1] + ways[j];
            }
        }
        return ways[0];

    }
}
