package Hard;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * Given an array points containing the coordinates of points on a 2D plane, 
 * sorted by the x-values, where points[i] = [xi, yi] 
 * such that xi < xj for all 1 <= i < j <= points.length. You are also given an integer k.
 * Find the maximum value of the equation yi + yj + |xi - xj| 
 * where |xi - xj| <= k and 1 <= i < j <= points.length. 
 * It is guaranteed that there exists at least one pair of points that satisfy the constraint |xi - xj| <= k.
*/

public class MaxValueofEquation {
	public int findMaxValueOfEquation(int[][] points, int k) {
		if(points == null || points.length == 0) return 0;
		
		Queue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
			@Override
			public int compare(int[] e1, int[] e2) {
				int a = e1[1] - e1[0], b = e2[1] - e2[0];
				return b - a;
			}
		});
		
		int result = Integer.MIN_VALUE;
		for(int i = 0; i < points.length; i++) {
			while(!pq.isEmpty() && pq.peek()[0] < points[i][0] - k) {
				pq.poll();
			}
			if(!pq.isEmpty()) {
				result = Math.max(result, points[i][1] + pq.peek()[1] - pq.peek()[0] + points[i][0]);
			}
			pq.offer(points[i]);
		}
		return result;

	}
}
