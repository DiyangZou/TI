package Hard;

import java.util.HashSet;
import java.util.Set;

public class FindaValueofaMysteriousFunctionClosesttoTarget {
	public int closestToTarget(int[] arr, int target) {
        int result = Integer.MAX_VALUE, n = arr.length;
        Set<Integer> set1 = new HashSet<>(), set2 = new HashSet<>();
        
        for(int i : arr){
            set2 = new HashSet<>();
            set2.add(i);
            for(int j: set1) {
            	set2.add(j & i);
            }
            for(int j: set2) {
            	result = Math.min(result, Math.abs(j - target));
            }
            set1 = set2;
        }
        return result;
	    }		
}
