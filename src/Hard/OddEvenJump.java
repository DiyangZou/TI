package Hard;

import java.util.Map;
import java.util.TreeMap;

public class OddEvenJump {
	public int oddEvenJumps(int[] A) {
		int n = A.length, res = 1;
		boolean[] high = new boolean[n], low = new boolean[n];
		high[n-1] = low[n-1] = true;
		TreeMap<Integer, Integer> map = new TreeMap<>();
		map.put(A[n-1], n-1);
		for(int i = n -2; i >=0; --i) {
			Map.Entry<Integer, Integer> hi = map.ceilingEntry(A[i]), lo = map.floorEntry(A[i]);
			if(hi != null) high[i] = low[(int)hi.getValue()];
			if(lo != null) low[i]= high[(int)lo.getValue()];
			if(high[i]) res++;
			map.put(A[i], i);
		}
		return res;
	}
}
