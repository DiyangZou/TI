package LeetCode30April;

import java.util.HashSet;
import java.util.Set;

public class CountingElements {

	public int countElements(int[] arr) {
		if(arr == null || arr.length <= 1) {
			return 0;
		}
		Set<Integer> seen = new HashSet<>();
		int result = 0;
		for(int i : arr) {
			seen.add(i);
		}
		for(int i: arr) {
			if(seen.contains(i+1)){
				result++;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		CountingElements s = new CountingElements();
		System.out.print(s.countElements(new int[] {1,3,2,3,5,0}));
	}

}
