package LeetCode30April;

import java.util.Arrays;

public class MoveZeros {
	
//	public void moveZeroes(int[] nums) {
//		if(nums == null || nums.length == 0) {
//			return;
//		}
//		
//		int left = 0, right = 1;
//		while(right < nums.length) {
//			if(nums[left] == 0) {
//				while(right < nums.length && nums[right] == 0) {
//					right++;
//				}
//				if(right >= nums.length) {
//					break;
//				}else {
//					swap(nums, left, right);
//				}
//			}else {
//				left++;
//				right = right > left ? right: left + 1;
//			}
//		}
//	}
	public void moveZeroes(int[] nums) {
		if(nums == null || nums.length == 0) {
			return;
		}
		
		int curZero = 0;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] != 0) {
				swap(nums, curZero, i);
				curZero++;
			}
		}
	}
	
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args) {
		MoveZeros s = new MoveZeros();
		int[] result = new int[] {2,1};
		s.moveZeroes(new int[] {2,1});
		System.out.println(Arrays.toString(result));
	}

}
