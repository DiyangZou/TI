package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestAscendingSubsequenceII {

	public int[] longest(int[] a) {
		// Write your solution here
		
		if(a == null || a.length == 0) {
			return new int[0];
		}
		
		List<List<Integer>> results = new ArrayList<>();
		List<Integer> res = new ArrayList<>();
		helper(a, results, res, 0);
		
		List<Integer> resultList = new ArrayList<>();
		for(List<Integer> r: results) {
			if(r.size()> resultList.size()) {
				resultList = r;
			}
		}
		
		int[] result = new int[resultList.size()];
		for(int i = 0; i < resultList.size(); i++) {
			result[i] = resultList.get(i);
		}
		return result;
	}
	
	private void helper(int[] a, List<List<Integer>> result, List<Integer> res, int index) {
		if(index >= a.length) {
			result.add(new ArrayList<Integer>(res));
			return;
		}
		
		
		for(int i = index; i < a.length; i++) {
			if(res.size() == 0 || res.get(res.size()- 1) < a[i]) {
				res.add(a[i]);
				helper(a, result, res, i+1);
				res.remove(res.size() - 1);
			}else {
				helper(a, result, res, i+1);
			}
		}
	}
	
	public static void main(String[] args) {
		LongestAscendingSubsequenceII s = new LongestAscendingSubsequenceII();
		int[] result = s.longest(new int[]{1,1,1,3,5,2});
		
		System.out.print(Arrays.toString(result));
	}

}
