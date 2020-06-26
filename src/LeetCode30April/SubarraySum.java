package LeetCode30April;

import java.util.HashMap;

public class SubarraySum {

	public int subarraySum(int[] nums, int k) {

		int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) { 
            prefix[i] = prefix[i - 1] + nums[i];
        }
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(prefix[i] - k)) {
                count += map.get(prefix[i] - k);
            }
            map.put(prefix[i], map.getOrDefault(prefix[i], 0) + 1);
        }
        return count;
	}
	
	public static void main(String[] args) {
		SubarraySum s = new SubarraySum();
		System.out.println(s.subarraySum(new int[] {1,1,1}, 2));
	}
}
