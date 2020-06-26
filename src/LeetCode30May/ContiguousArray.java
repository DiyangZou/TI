package LeetCode30May;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
	public int findMaxLength(int[] nums) {
		if(nums == null || nums.length == 0) {
			return -1;
		}
		
		Map<Integer, Integer> map = new HashMap<>();
		int len = nums.length, sum = 0, res = -1;
		map.put(0, -1);
		for(int i = 0; i < len; i++) {
			if(nums[i] == 0) {
				sum++;
			}else {
				sum--;
			}
			if(map.containsKey(sum)) {
				res = Math.max(res, i - map.get(sum));
			}else {
				map.put(sum, i);
			}
		}
		return res;
	}
}
