package LeetCode30May;

public class UncrossedLines {
	public int maxUncrossedLines(int[] A, int[] B) {

		int m = A.length, n = B.length;
		int[][] dp = new int[m+1][n+1];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (A[i-1] == B[j-1]) {
					dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, Math.max(dp[i][j - 1], dp[i - 1][j]));
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}
		return dp[m][n];
	}
	public static void main(String[] args) {
		UncrossedLines s = new UncrossedLines();
		System.out.println(s.maxUncrossedLines(new int[] {1,4,2}, new int[] {1,2,4}));
	}
}
