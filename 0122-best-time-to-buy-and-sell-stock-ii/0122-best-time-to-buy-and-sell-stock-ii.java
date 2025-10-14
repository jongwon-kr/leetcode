class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int total = 0;
        int buyPrice = -1;
        for (int i = 0; i < prices.length; i++) {
            if (i < prices.length - 1) {
                if (buyPrice == -1 && prices[i] < prices[i + 1]) {
                    buyPrice = prices[i];
                } else if (buyPrice != -1 && prices[i] > prices[i + 1]) {
                    total += prices[i] - buyPrice;
                    buyPrice = -1;
                }
            } else {
                if (buyPrice != -1) {
                    total += prices[i] - buyPrice;
                }
            }
        }
        return total;
    }
}