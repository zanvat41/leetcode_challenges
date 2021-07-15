class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        // Your account has 0 at the beginning
        for (int i = 1; i < n; ++i) {
            // If you complete first buy transcation on ith day,
            // your account has buy1
            if(-prices[i] > buy1)
                buy1 = -prices[i];
            // If you complete first sell transcation on ith day,
            // your account has sell1
            if(buy1 + prices[i] > sell1)
                sell1 = buy1 + prices[i];
            // If you complete second buy transcation on ith day,
            // your account has buy2
            if(sell1 - prices[i] > buy2)
                buy2 = sell1 - prices[i];
            // If you complete second sell transcation on ith day,
            // your account has sell2
            if(buy2 + prices[i] > sell2)
                sell2 = buy2 + prices[i];
        }
        return sell2;
    }
}
