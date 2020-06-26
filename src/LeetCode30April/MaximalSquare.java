package LeetCode30April;

public class MaximalSquare {
	public int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;

		int m = matrix.length, n = matrix[0].length, result = 0;
		int[][] dp = new int[m][n];
		
		for(int i = 0; i < m; i++) {
			dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
		}
		
		for(int i = 0; i < n; i++) {
			dp[0][i] = matrix[0][i] == '1' ? 1 : 0;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == '1' && dp[i - 1][j] > 0 && dp[i][j - 1] > 0) {
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.max(dp[i - 1][j], dp[i][j - 1])) + 1;
					result = Math.max(result, dp[i][j]);
				} else {
					dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
					result = Math.max(result, dp[i][j]);
				}
			}
		}
		return result * result;
	}
	
	public static void main(String[] args) {
		MaximalSquare m = new MaximalSquare();
		System.out.println(m.maximalSquare(new char[][]
				{{'0','0','0','1'},{'1','1','0','1'},{'1','1','1','1'},{'0','1','1','1'},{'0','1','1','1'}}
				));
	}
}
