package Hard;

public class BuyStockIV {

//	public int maxProfit(int[] array, int k) {
//		// Write your solution here
//		if(array == null || array.length < 2 || k == 0) {
//			return 0;
//		}
//		int[] mp = new int[] {0};
//		helper(array, k, 0, 0, 0, mp);
//		return mp[0];
//	}
//
//	private void helper(int[] array, int k, int index, int curS, int curP, int[] maxP) {
//		if (index >= array.length || k == 0) {
//			maxP[0] = Math.max(curP, maxP[0]);
//			return;
//		}
//		
//		if(curS == 0) {
//			helper(array, k, index + 1, array[index], curP, maxP);
//		}else {
//			if(array[index] > curS) {
//				helper(array, k-1, index + 1, 0, curP + array[index] - curS, maxP);
//			}
//		}
//		helper(array, k, index + 1, curS, curP, maxP);
//		
//		
//	}
	
	public int maxProfit(int[] prices, int k) {
		// Write your solution here
		if(prices == null || prices.length < 2 || k == 0) {
			return 0;
		}
		int len = prices.length;
        if (k >= len / 2) return quickSolve(prices);
        
        int[][] t = new int[k + 1][len];
        for (int i = 1; i <= k; i++) {
            int tmpMax =  -prices[0];
            for (int j = 1; j < len; j++) {
                t[i][j] = Math.max(t[i][j - 1], prices[j] + tmpMax);
                tmpMax =  Math.max(tmpMax, t[i - 1][j - 1] - prices[j]);
            }
        }
        return t[k][len - 1];
    }
    

    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }
	
	public static void main(String[] args) {
		BuyStockIV s = new BuyStockIV();
//		int result = s.maxProfit(new int[] {3,4,1,2,6,2,3,5,1,7,3,8}, 4);
		int result = s.maxProfit(new int[] {2,3, 2, 1, 4, 5, 2, 11}, 3);
		System.out.println(result);
	}

}
