package Medium;

import java.util.ArrayDeque;

public class CountSubmatricesWithAllOnes {
	public int numSubmat(int[][] mat) {

		int m = mat.length;
		int n = mat[0].length;

		int result = 0;

		int[] heights = new int[n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				heights[j] = (mat[i][j] == 1 ? heights[j] + 1 : 0);
			}

			result += getNumberOfRectangles(heights);
		}

		return result;
	}

	public int getNumberOfRectangles(int[] heights) {

		int result = 0;

		int[] sum = new int[heights.length];

		ArrayDeque<Integer> stack = new ArrayDeque<>();

		for (int i = 0; i < heights.length; i++) {

			while (!stack.isEmpty() && heights[stack.peek()] > heights[i])
				stack.pop();

			if (!stack.isEmpty()) {
				sum[i] = sum[stack.peek()];
				sum[i] += heights[i] * (i - stack.peek());
			} else {
				sum[i] = heights[i] * (i + 1);
			}

			stack.push(i);
		}

		for (int i : sum)
			result += i;

		return result;
	}
	
	public static void main(String[] args) {
		CountSubmatricesWithAllOnes s = new CountSubmatricesWithAllOnes();
		s.numSubmat(new int[][] {{1,0,1}, {1,1,0},{1,1,0}});
	}
}
