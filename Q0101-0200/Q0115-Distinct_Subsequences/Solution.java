class Solution {
    public int numDistinct(String s, String t) {
        int M = s.length();
        int N = t.length();

        int[] dp = new int[N];

        int prev;

        for(int i = M - 1; i >= 0; i--){
            prev = 1;
            for(int j = N - 1; j >= 0; j--){
                int last_dpj = dp[j];

                if(s.charAt(i) == t.charAt(j)) {
                    dp[j] += prev;
                }

                prev = last_dpj;
            }

        }
        return dp[0];
    }
}
