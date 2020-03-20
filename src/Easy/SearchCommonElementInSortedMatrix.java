package Easy;

public class SearchCommonElementInSortedMatrix {
	public int search(int[][] matrix) {
		// Write your solution here
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return -1;
		}
		int m = matrix.length, n = matrix[0].length;
		for (int i = 0; i < n; i++) {
			int cur = matrix[0][i], count = 1;
			for (int j = 1; j < m; j++) {
				int start = 0, end = matrix[j].length-1;
				while (start <= end) {
					int mid = start + (end - start) / 2;
					if (matrix[j][mid] == cur) {
						count++;
						break;
					} else if (matrix[j][mid] < cur) {
						start++;
					} else {
						end--;
					}
				}

				if (count == m) {
					return cur;
				}
				if (count != j + 1) {
					j = m;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// {1,2,3,4,9,9,10,11},{5,6,7,8},{2,3,5,8,9,10,11,12}
		SearchCommonElementInSortedMatrix s = new SearchCommonElementInSortedMatrix();
		int result = s.search(new int[][] {{1,2,3,4,9,9,10,11},{5,6,7,8},{2,3,5,8,9,10,11,12}});
		System.out.print(result);
	}

}
