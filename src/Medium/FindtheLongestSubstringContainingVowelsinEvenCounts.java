package Medium;

import java.util.Arrays;

public class FindtheLongestSubstringContainingVowelsinEvenCounts {
//	public int findTheLongestSubstring(String s) {
//		int res = 0, cur = 0, n = s.length();
//		HashMap<Integer, Integer> seen = new HashMap<>();
//		seen.put(0, -1);
//		for (int i = 0; i < n; ++i) {
//			cur ^= 1 << ("aeiou".indexOf(s.charAt(i)) + 1) >> 1;
//			seen.putIfAbsent(cur, i);
//			res = Math.max(res, i - seen.get(cur));
//		}
//		return res;
//	}
	
	char[] c_m = {1,0,0,0,2,0,0,0,4,0,0,0,0,0,8,0,0,0,0,0,16,0,0,0,0,0};
	public int findTheLongestSubstring(String s) {
	    int mask = 0, res = 0;
	    int[] m = new int[32];
	    Arrays.fill(m, -1);
	    for (int i = 0; i < s.length(); ++i) {
	        mask ^= c_m[s.charAt(i) - 'a'];
	        if (mask != 0 && m[mask] == -1)
	            m[mask] = i;
	        res = Math.max(res, i - m[mask]);
	    }
	    return res;
	}
	
	public static void main(String[] args) {
		FindtheLongestSubstringContainingVowelsinEvenCounts s = new FindtheLongestSubstringContainingVowelsinEvenCounts();
		s.findTheLongestSubstring("eleetminicoworoep");
	}
}
