package Hard;

public class FindMinimuminRotatedSortedArrayII {
	public int findMin(int[] nums) {
		int left = 0, right = nums.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] > nums[right]) {
				left = mid + 1;
			} else if (nums[mid] == nums[right]) {
				right -= 1;
			} else {
				right = mid;
			}
		}
		return nums[left];
	}
}
