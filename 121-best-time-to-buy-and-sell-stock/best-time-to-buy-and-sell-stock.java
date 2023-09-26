class Solution {
    public int maxProfit(int[] prices) {
        int leastPrice = Integer.MAX_VALUE; 
        int profit = 0; 
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < leastPrice) {
                leastPrice = prices[i]; 
            }
            if ((prices[i] - leastPrice) > profit) {
                profit = prices[i] - leastPrice;
            }
        }
        return profit; 
    }
}