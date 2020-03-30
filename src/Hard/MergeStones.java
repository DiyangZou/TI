package Hard;

public class MergeStones {

	public int minCost(int[] stones) {
		// Write your solution here
		int n = stones.length;
		int[] prefix = new int[n+1];
        for (int i = 0; i <  n; i++) {
            prefix[i + 1] = prefix[i] + stones[i];
        }

        int[][] dp = new int[n][n];
        
        for(int m=2; m<=n; m++) {
        	for(int i = 0; i <= n - m; i++) {
        		int j = i + m -1;
        		dp[i][j] = Integer.MAX_VALUE;
        		for(int mid = i; mid < j; mid++) {
        			dp[i][j] = Math.min(dp[i][j], dp[i][mid] + dp[mid+1][j] + prefix[j+1] - prefix[i]);
        		}
        	}
        }
        

        return dp[0][n - 1];
	}
	
	public static void main(String[] args) {
		MergeStones s = new MergeStones();
		int result = s.minCost(new int[] {4,3,3});
		
		System.out.println(result);
	}
}
