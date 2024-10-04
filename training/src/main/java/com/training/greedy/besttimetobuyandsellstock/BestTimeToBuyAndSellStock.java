package com.training.greedy.besttimetobuyandsellstock;


class BestTimeToBuyAndSellStock {

  public int maxProfit(int[] prices) {
    if (prices.length <= 1) {
      return 0;
    }

    int maxProfit = 0;
    int init = 0;
    for (int x = 1; x < prices.length; x++) {
      if (prices[init] > prices[x]) {
        init = x;
      }

      int currentProfit = prices[x] - prices[init];
      if (currentProfit > maxProfit) {
        maxProfit = currentProfit;
      }
    }
    return maxProfit;
  }
}
