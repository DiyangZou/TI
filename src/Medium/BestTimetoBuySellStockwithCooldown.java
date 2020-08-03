package Medium;

public class BestTimetoBuySellStockwithCooldown {
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length < 2) return 0;
		int[] s0 = new int[2],s1 = new int[2], s2 = new int[2];
		s0[0] = 0;
		s1[0] = -prices[0];
		s2[0] = Integer.MIN_VALUE;
		
		for(int i = 1; i < prices.length; ++i) {
			s0[i % 2] = Math.max(s0[(i-1) % 2], s2[(i-1) % 2]);
			s1[i % 2] = Math.max(s1[(i-1) % 2], s0[(i-1) % 2] - prices[i]);
			s2[i % 2] = s1[(i-1) % 2] + prices[i];
		}
		return Math.max(s0[(prices.length - 1) % 2], 
				s2[(prices.length - 1) % 2]);
		/*
		 * ong noStock = 0, hasStock = Integer.MIN_VALUE, prevNoStock = 0;
        for (int price : prices) {
            long tmp = noStock;
            noStock = Math.max(noStock, hasStock + price);
            hasStock = Math.max(hasStock, prevNoStock - price);
            prevNoStock = tmp;
        }
        return (int)noStock;
		 */
	}
}
