package TI;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
	public String minWindow(String source, String target) {
	    // Write your solution here
		// corner cases
		char[] s = source.toCharArray();
		char[] t = target.toCharArray();
		
		int count = 0, k = t.length, start = 0, minstart = 0, minLen = Integer.MAX_VALUE;
		int[] res = new int[] {-1,-1};
		Map<Character, Integer> map = new HashMap<>();
		for(char c : t) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		
		for(int i = 0; i < s.length; i++) {
			if(map.containsKey(s[i])) {
				map.put(s[i], map.get(s[i]) - 1);
				if(map.get(s[i]) >= 0) {
					count++;
				}
				while(count == k) {
					if(minLen > i - start) {
						minLen = i - start;
						minstart = start;
					}
//					if(map.containsKey(s[start])) {
//						map.put(s[start], map.get(s[start]) + 1);
//						count--;
//					}
					if(map.containsKey(s[start])) {
						map.put(s[start], map.get(s[start]) + 1);
						if(map.get(s[start]) > 0) {
							count--;
						}
					}
					start++;
				}
			}
		}
		return source.substring(minstart, minLen + minstart + 1);
	  }
	
	public static void main(String[] args) {
		MinimumWindowSubstring s = new MinimumWindowSubstring();
		String result = s.minWindow("AEFBGFCMNDCUIBA","ABCD");
		System.out.print(result);
	}
}
