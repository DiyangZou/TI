package Medium;

public class CanIWin {
//	public int canWin(int[] nums) {
//		// Write your solution here
//		if(nums == null || nums.length == 0) {
//			return 0;
//		}
//		int n = nums.length, sum = 0;;
//		int[][] dp = new int[n][n];
//		
//		for(int i = 0; i < n; i++) {
//			dp[i][i] = nums[i];
//			sum+= nums[i];
//		}
//		
//		for(int m = 1; m < n; m++) {
//			for(int i = 0; i < n - m; i++) {
//				int j = i + m;
//				dp[i][j] = Math.max(nums[j] - dp[i][j-1] , nums[i] - dp[i+1][j]);
//
//			}
//		}
//		int cur = (sum - dp[0][n-1]) /2 + dp[0][n-1];
//		int result = Math.max(cur, sum - cur);
//		return result;
//	}
	
	public int canWin(int[] nums) {
		int[][] M = new int[nums.length][nums.length];
		int sum = 0;
		// M[i][j] represents [from the i-th pizza to the j-th pizza], the largest total
		// sum of all pizza
		// you can pick assuming you start first.
		for (int j = 0; j < nums.length; j++) {
			sum += nums[j];
			for (int i = j; i >= 0; i--) {
				if (i == j) {
					M[i][j] = nums[j];
				} else if (i + 1 == j) {
					M[i][j] = Math.max(nums[i], nums[j]);
				} else {
					int a = M[i + 2][j], b = M[i + 1][j - 1];
					int temp1 = nums[i] + Math.min(M[i + 2][j], M[i + 1][j - 1]);
					int temp2 = nums[j] + Math.min(M[i + 1][j - 1], M[i][j - 2]);
					M[i][j] = Math.max(temp1, temp2);
				}
			}
		}
		
		int result = Math.max(M[0][nums.length - 1], sum - M[0][nums.length - 1]);
		return result;

	}
	
	public static void main(String[] args) {
		CanIWin s = new CanIWin();
		System.out.println(s.canWin(new int[] {2,1,100,3}));
	}
	
	
}
