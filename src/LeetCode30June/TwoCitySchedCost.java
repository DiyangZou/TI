package LeetCode30June;

import java.util.Arrays;

public class TwoCitySchedCost {
	public int twoCitySchedCost(int[][] costs) {
		if(costs == null) return 0;
		
		int[] refund = new int[costs.length];
		int result = 0;
		for(int i = 0; i < refund.length; i++) {
			refund[i] = costs[i][1] - costs[i][0];
			result += costs[i][0];
		}
		Arrays.sort(refund);
		for(int i = 0; i < costs.length / 2; i++) {
			result += refund[i];
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		TwoCitySchedCost s = new TwoCitySchedCost();
		System.out.println(s.twoCitySchedCost(new int[][] {{10,20},{30,200},{400,50},{30,20}}));
	}
}
