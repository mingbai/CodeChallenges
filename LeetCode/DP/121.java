class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        
        int n = prices.length;
        int[] min_prices  = new int[n];
        int[] max_profit = new int[n];
        min_prices[0] = prices[0];
        max_profit[0] = 0;
        
        for(int i = 1; i < n; i++) {
            min_prices[i] = Math.min(min_prices[i - 1], prices[i]);
            max_profit[i] = Math.max(max_profit[i - 1], prices[i] - min_prices[i - 1]);
        }
        return max_profit[n - 1];
    }
}