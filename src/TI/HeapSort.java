package TI;

import java.util.Arrays;

public class HeapSort {
	public int[] heapsort(int nums[]) {
		heapify(nums);
		for (int i = nums.length - 1; i >= 0; i--) {
			swap(nums, 0, i);
			perculateDown(nums, 0, i);// 挡板i物理意义：[i, nums.length - 1]为已排序部分
		}
		return nums;
	}

	// O(N) heapify成最大堆
	private void heapify(int nums[]) {
		for (int i = nums.length / 2 - 1; i >= 0; i--) {
			perculateDown(nums, i, nums.length);
		}
	}

	// O(logN)
	// len是perculateDown所影响到的数组的长度，即“挡板”左边未排序的部分
	private void perculateDown(int nums[], int index, int len) {
		while (index <= len / 2 - 1) {
			int leftChildIndex = 2 * index + 1;
			int rightChildIndex = 2 * index + 2;
			int childToBeSwapped = leftChildIndex;
			if (rightChildIndex < len && nums[leftChildIndex] < nums[rightChildIndex]) {
				childToBeSwapped = rightChildIndex;
			}
			if (nums[index] < nums[childToBeSwapped]) {
				swap(nums, index, childToBeSwapped);
			}
			index = childToBeSwapped;
		}
	}

	private void swap(int nums[], int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	  public static void main(String[] args) {
		  HeapSort s = new HeapSort();
		  //int[] result = s.heapsort(new int[] {1,2,3});
		  //System.out.println(Arrays.toString(result));
		  int[] res = s.heapsort(new int[] {2,1,3,4, 5});
		  System.out.println(Arrays.toString(res));
	}
}
