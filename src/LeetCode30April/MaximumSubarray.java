package LeetCode30April;

public class MaximumSubarray {
//	public int maxSubArray(int[] nums) {
//		if(nums == null || nums.length == 0) {
//			return 0;
//		}
//		
//		int sum = 0, result = Integer.MIN_VALUE;
//		for(int i = 0; i < nums.length; i++) {
//			sum += nums[i];
//			result = Math.max(result, sum);
//			if(sum < 0) {
//				sum = 0;
//			}
//		}
//		return result;
//	}
	public int maxSubArray(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		
		int max = nums[0];
		for(int i = 1; i < nums.length; i++) {
			if(nums[i-1] > 0) {
				nums[i] += nums[i-1];
			}
			max = Math.max(max, nums[i]);
		}
		return max;
	}
	
//	public int maxSubArray(int[] nums) {
//		if(nums == null || nums.length == 0) {
//			return 0;
//		}
//		int[] result = new int[] {Integer.MIN_VALUE};
//		helper(nums, result, 0, 0);
//		return result[0];
//	}
//	
//	private void helper(int[] nums, int[] result, int curSum, int index) {
//		if(index >= nums.length) return;
//		
//		curSum += nums[index];
//		result[0] = Math.max(curSum, result[0]);
//		if(curSum < 0) {
//			helper(nums, result, 0, index + 1);
//		}else {
//			helper(nums, result, curSum, index + 1);
//		}
//	}
	
//	public int maxSubArray(int[] nums) {
//		if (nums == null || nums.length == 0) {
//			return 0;
//		}
//		int max = nums[0], sum = nums[0], left = 0, right = 1;
//		
//		while(right < nums.length && left < nums.length) {
//			if(sum + nums[right] < nums[right]) {
//				left = right;
//				sum = nums[right];
//			}else {
//				sum += nums[right];
//			}
//			if(sum > max) {
//				max = sum;
//			}
//			right++;
//		}
//		
//		return max;
//	}
	
	
	
	public static void main(String[] args) {
		MaximumSubarray s = new MaximumSubarray();
		System.out.print(s.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
	}
}
