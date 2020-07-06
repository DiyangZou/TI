package Hard;

public class FormLargestIntegerWithDigitsThatAdduptoTarget {
//	public String largestNumber(int[] cost, int target) {
//
//		int nums = cost.length;
//		long[] result = new long[] {0};
//		helper(result, 0, nums, cost, target);
//		return Long.toString(result[0]) ;
//	}
//	
//	private void helper(long[] result, long num, int nums, int[] cost, int target) {
//		if(target < 0) {
//			return;
//		}
//		if(target == 0) {
//			result[0] = Math.max(result[0], num);
//			return;
//		}
//		
//		for(int i = 1; i <= nums; i++) {
//			num = num * 10 + i;
//			helper(result, num, nums, cost, target - cost[i-1]);
//			num /= 10;
//		}
//		
//	}
	
	public String largestNumber(int[] cost, int target) {
        int[] dp = new int[target + 1];
        for (int t = 1; t <= target; ++t) {
            dp[t] = -10000;
            for (int i = 0; i < 9; ++i) {
                if (t >= cost[i])
                    dp[t] = Math.max(dp[t], 1 + dp[t - cost[i]]);
            }
        }
        if (dp[target] < 0) return "0";
        StringBuilder res = new StringBuilder();
        for (int i = 8; i >= 0; --i) {
            while (target >= cost[i] && dp[target] == dp[target - cost[i]] + 1) {
                res.append(1 + i);
                target -= cost[i];
            }
        }
        return res.toString();
    }
	
	public static void main(String[] args) {
		FormLargestIntegerWithDigitsThatAdduptoTarget s = new FormLargestIntegerWithDigitsThatAdduptoTarget();
		String res = s.largestNumber(new int[] {1,1,1,1,1,1,1,3,2}, 10);
		System.out.println(res);
	}
}
