package Medium;

public class LeastInsertionsToFormAPalindrome {
	public int leastInsertion(String input) {
		// Write your solution here
		if(input == null || input.length() == 0) {
			return 0;
		}
		int n = input.length();
		char[] in = input.toCharArray();
		int[][] dp = new int[n][n];
		for(int m = 1; m < n; m++) {
			for(int i = 0; i < n - m; i++) {
				int j = i+ m;
				if(in[i] == in[j]) {
					dp[i][j] = dp[i+1][j-1];
				}else {
					dp[i][j] = Math.min(dp[i][j-1] + dp[i+m][j], dp[i][j - m] + dp[i+1][j]) + 1;
				}
			}
		}
		return dp[0][n-1];
	}
	
	public static void main(String[] args) {
		LeastInsertionsToFormAPalindrome s = new LeastInsertionsToFormAPalindrome();
		System.out.println(s.leastInsertion("abcb"));
	}
}
