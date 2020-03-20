package TI;

import java.util.SortedSet;
import java.util.TreeSet;

public class ContainsDuplicateIII {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		// Write your solution here
		if (nums == null || nums.length <= 1 || k < 0 || t < 0) {
			return false;
		}
		// for(int i = 0; i < nums.length - 1; i++){
		// int j = i + 1;
		// while(j < nums.length){
		// if(Math.abs(nums[i] - nums[j]) <= t && Math.abs(i - j) <= k){
		// return true;
		// }
		// j++;
		// }
		// }

		TreeSet<Long> set = new TreeSet<Long>();
		for (int i = 0; i < nums.length; i++) {
			long curr = (long) nums[i];

			long leftBoundary = (long) curr - t;
			long rightBoundary = (long) curr + t + 1; // right boundary is exclusive, so +1
			SortedSet<Long> sub = set.subSet(leftBoundary, rightBoundary);
			if (sub.size() > 0)
				return true;

			set.add(curr);

			if (i >= k) { // or if(set.size()>=k+1)
				set.remove((long) nums[i - k]);
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		ContainsDuplicateIII s = new ContainsDuplicateIII();
		boolean result = s.containsNearbyAlmostDuplicate(new int[] {1,6,9,12}, 5, 4);
		System.out.print(result);
	}
}
