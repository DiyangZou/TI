package Easy;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class CourseScheduleII {

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] degree = new int[numCourses], result = new int[numCourses];
		for (int[] p : prerequisites) {
			degree[p[0]]++;
		}

		Queue<Integer> q = new LinkedList<>();
		Set<Integer> v = new HashSet<>();
		for (int i = 0; i < numCourses; ++i) {
			if (degree[i] == 0)
				q.offer(i);
		}

		int idx = 0, count = numCourses;
		while (idx < numCourses && !q.isEmpty()) {
			int cur = q.poll();
			v.add(cur);
			result[idx++] = cur;
			for (int[] p : prerequisites) {
				if (p[1] == cur) {
					degree[p[0]]--;
				}
				if (!v.contains(p[0]) && degree[p[0]] == 0) {
					q.offer(p[0]);
					v.add(p[0]);
				}
			}
			count--;
		}
		return count == 0 ? result: new int[0];
	}
	
	public static void main(String[] args) {
		CourseScheduleII s = new CourseScheduleII();
		int[] res = s.findOrder(3, new int[][] {{1, 0}});
	}
}
