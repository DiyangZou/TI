package Hard;

/*
Q4 There are N pieces of wood, with their lengths (in meters) stored in Bords[N]. k painters are assigned to paint all these wood together.
For each piece of wood, it can only be painted by 1 and only 1 painter, and each painter can only paint contiguous woods.
Each painter can paint wood at the same speed, say 1 meter per minute.
How can we find an assignment such that the total time for painting the wood is minimized.   
return the minimum minutes to finish painting all the wood.
e.g.
k = 2
boards[N] = {3, 6, |  5, 5}
return 10.
*/
public class PaintBoard {

//	public int paintWood(int[] array, int k) {
//		int n = array.length;
//		int[] prefixSum = new int[n+ 1];
//		prefixSum[0] = array[0];
//		int[][] dp = new int[n + 1][k];
//		for (int i = 0; i < n; i++) {
//			prefixSum[i + 1] = prefixSum[i] + array[i];
//			dp[i + 1][0] = dp[i][0] + array[i];
//		}
//		
//		for (int l = 1; l < k; l ++) {
//			for (int i = 1; i <= n; i++) {
//				dp[i][l] = Integer.MAX_VALUE;
//				for (int j = 0; j < i; j++) {
//					int cur = Math.max(dp[j][l - 1], prefixSum[i] - prefixSum[j]);
//					dp[i][l] = Math.min(dp[i][l], cur);
//				}
//			}
//		}
//		return dp[n][k - 1];
//	}

	public int paintWood(int[] array, int k) {
		int max = 0;
		int sum = 0;
	for (int i = 0; i < array.length; i++) {
		max = Math.max(max, array[i]);
		sum += array[i];
	}
	if (k == 1) {
		return max;
	}
	int left = max, right = sum;
	while (left < right) {
		int mid = (right - left) / 2 + left;
		int worker = getPainter(array, mid);
		if (worker > k) {
			left = mid + 1;
		} else {
			right = mid;
		}
	}
	return left;
	}

	private int getPainter(int[] array, int time) {
		int worker = 1;
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			if (sum + array[i] > time) {
				sum = array[i];
				worker++;
			} else {
				sum += array[i];
			}
		}
		return worker;
	}

	public static void main(String[] args) {
		PaintBoard s = new PaintBoard();
		int res = s.paintWood(new int[] { 3, 6, 5 }, 2);
		System.out.print(res);
	}

}
