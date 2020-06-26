package Hard;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithEqualNumberOf {
	
	public int longest(int[] array) {
	    // Write your solution here
		if(array == null || array.length <= 1) return 0;
		
		int n = array.length, result = 0;
		
		System.out.print(n);
		
		int[] sumleft = new int[n + 1];
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < n; i++) {
			if(array[i] == 0) {
				sumleft[i+1] += sumleft[i] - 1; 
			}else {
				sumleft[i + 1] += sumleft[i] + 1; 
			}
			
			if(sumleft[i + 1] == 0) {
				result = Math.max(result, i+1);
			}
			
			if(map.containsKey(sumleft[i+1])) {
				
				result = Math.max(result, i - map.get(sumleft[i+1]));
			}else {
				map.put(sumleft[i+1], i);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		LongestSubarrayWithEqualNumberOf s = new LongestSubarrayWithEqualNumberOf();
		int result = s.longest(new int[] {1,1,0,0,0,0,1,0});
		System.out.print(result);
	}

}
