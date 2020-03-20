package Hard;

public class BSTCountofRangeSum {
	public int countRangeSum(int[] nums, int lower, int upper) {
		// Write your solution here
		long[] prefixSum = new long[nums.length + 1];

		for (int i = 1; i < prefixSum.length; i++) {
			prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
		}
		return countRangeSumSub(prefixSum, 0, prefixSum.length - 1, lower, upper);
	}

	private int countRangeSumSub(long[] prefixSum, int l, int r, int lower, int upper) {
		if (l >= r)
			return 0;

		int mid = l + (r - l) / 2;
		int count = countRangeSumSub(prefixSum, l, mid, lower, upper)
				+ countRangeSumSub(prefixSum, mid + 1, r, lower, upper);
		
		long[] merge = new long[r - l + 1];
		int i = l, j = mid+1, k = mid + 1, left = 0, right = mid+1;
		
		while(i < mid+1) {
			while(j <= r && prefixSum[j] - prefixSum[i] < lower) j++;
			while(k <= r && prefixSum[k] - prefixSum[i] <= upper) k++;
			count += k - j;
			
			while(right <= r && prefixSum[right] < prefixSum[i]) {
				merge[left++] = prefixSum[right++];
			}
			merge[left++] = prefixSum[i++];
		}
		while(right <= r) {
			merge[left++] = prefixSum[right++];
		}
		int copy = l;
		for(int idx = 0; idx < merge.length; idx++) {
			prefixSum[copy++] = merge[idx];
		}
		return count;

	}
	
	public static void main(String[] args) {
		BSTCountofRangeSum s = new BSTCountofRangeSum();
		int result = s.countRangeSum(new int[] {-2, 5, -3}, 0, 2);
		System.out.print(result);
	}
	
	
}
