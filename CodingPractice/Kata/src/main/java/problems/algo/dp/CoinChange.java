package problems.algo.dp;

/*
 * https://leetcode.com/problems/coin-change/
 */
public class CoinChange {

	public int coinChange(int[] coins, int amount) {
		int [] res = new int[amount + 1];
		
		res[0] = 0;
		for (int i = 1; i <= amount; i++) {
			
			res[i] = amount+1;
			for (int j = 0; j < coins.length; j++) {
				
				if(coins[j] <= i) {
					res[i] = Math.min(1 + res[i - coins[j]], res[i]);
				}
			}
		}

		return res[amount] > amount ? -1 : res[amount];
	}
	public static void main(String[] args) {
		CoinChange c = new CoinChange();
		int [] coins = new int [] {2};
		System.out.println(c.coinChange(coins, 3));

	}

}
