package problems.algo.array;

/**
 * 
 * 	Say you have an array for which the ith element is the price of a given stock on day i.

	If you were only permitted to complete at most one transaction 
	(i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
	
	Note that you cannot sell a stock before you buy one.
	
	Example 1:
	
	Input: [7,1,5,3,6,4]
	Output: 5
	Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
	             Not 7-1 = 6, as selling price needs to be larger than buying price.
	Example 2:
	
	Input: [7,6,4,3,1]
	Output: 0
	Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 */
public class Stocks {
	
    public int maxProfit(int[] prices) {
    	
    	int maxProfit = 0;
    	int len = prices.length;
    	
    	for (int i = 0; i < len -1 ; i++) {
			int byuPrice = prices[i];
    		for (int j = i+1 ; j < len ; j++) {
    			
    			int profit = prices[j] - byuPrice;
    			if (profit > 0) {
    				if(profit > maxProfit) {
    					maxProfit = profit;
    				}
    			}
    		}
    	}
    	
    	return maxProfit;
        
    }

    public int maxProfitOnePass(int[] prices) {
    	
    	int maxProfit = 0;
    	int minPrice = Integer.MAX_VALUE;
    	int len = prices.length;
    	
    	for (int i = 0; i < len; i++) {
    		
    		//set min price
    		if (prices[i] < minPrice) {
    			minPrice = prices[i];
    		} else {
    			//set max profit
    			if(prices[i] - minPrice > maxProfit) {
    				maxProfit = prices[i] - minPrice;
    			}
    		}
    	}
    	
    	return maxProfit;
        
    }

    public static void main(String[] args) {
		
		Stocks s = new Stocks();
		
		int [] prices1 = new int [] {7,1,5,3,6,4};
		System.out.println("Max Profit 1 : "+s.maxProfit(prices1));
		System.out.println("Max Profit 1 OnePass : "+s.maxProfitOnePass(prices1));
		int [] prices2 = new int [] {7,6,4,3,1};
		System.out.println("Max Profit 2 : "+s.maxProfit(prices2));
		System.out.println("Max Profit 2 OnePass : "+s.maxProfitOnePass(prices2));

	}

}
