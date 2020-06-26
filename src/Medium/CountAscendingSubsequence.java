package Medium;

public class CountAscendingSubsequence {

	public int numIncreasingSubsequences(int[] a) {
		// Write your solution here
		if(a == null || a.length == 0) return 0;
		
		int[] dp = new int[a.length];
		dp[0] = 1;
		for(int i= 1; i < dp.length; i++) {
			dp[i] = 1;
			for(int j = 0; j < i; j++) {
				if(a[i] > a[j]) {
					dp[i] += dp[j];
				}
			}
		}
		
		int result = 0;
		for(int i: dp) {
			result += i;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		CountAscendingSubsequence s = new CountAscendingSubsequence();
		System.out.print(s.numIncreasingSubsequences(new int[] {1,2,3, 3}));
	}

}
