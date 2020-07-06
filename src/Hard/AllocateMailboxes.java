package Hard;

import java.util.Arrays;

public class AllocateMailboxes {
	public int minDistance(int[] houses, int k) {
		Arrays.sort(houses);
		int n = houses.length, sum[] = new int[n + 1], dp[] = new int[n];
		for(int i = 0; i < n; i++) {
			sum[i+1] = sum[i] + houses[i];
			dp[i] = (int)1e6;
		}
		
		for(int mail = 1; mail <= k; ++mail) {
			for(int j = n-1; j > mail - 2; --j) {
				for(int i = k - 2; i < j; ++i) {
					int m1 = (i + j + 1) / 2, m2 = (i + j + 2) / 2;
					int last = (sum[j + 1] - sum[m2]) - (sum[m1 + 1] - sum[i + 1]);
					dp[j] = Math.min(dp[j], (i>= 0 ? dp[i]:0) + last);
				}
			}
		}
		return dp[n-1];
	}
}
