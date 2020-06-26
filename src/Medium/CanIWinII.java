package Medium;

public class CanIWinII {

	public int canWin(int[] nums) {
		int[][] M = new int[nums.length][nums.length];
		// M[i][j] represents [from the i-th pizza to the j-th pizza], the largest total
		// sum of all pizza
		// you can pick assuming you start first.
		for (int j = 0; j < nums.length; j++) {
			for (int i = j; i >= 0; i--) {
				if (i == j) {
					M[i][j] = nums[j];
				} else if (i + 1 == j) {
					M[i][j] = Math.max(nums[i], nums[j]);
				} else {
					int temp1 = nums[i];
					if (nums[i + 1] < nums[j]) {
						temp1 += M[i + 1][j - 1];
					} else if (nums[i + 1] > nums[j]) {
						temp1 += M[i + 2][j];
					} else {
						int a = i + 2, b = j - 1;
						while (a < b) {
							if (nums[a] > nums[b]) {
								temp1 += M[i + 1][j - 1];
								break;
							} else if (nums[a] < nums[b]) {
								temp1 += M[i + 2][j];
								break;
							} else {
								a++;
								b--;
							}
						}
						if (a >= b) {
							temp1 += Math.min(M[i + 1][j - 1], M[i + 2][j]);
						}
					}
					int temp2 = nums[j];
					if (nums[j - 1] < nums[i]) {
						temp2 += M[i + 1][j - 1];
					} else if (nums[j - 1] > nums[i]) {
						temp2 += M[i][j - 2];
					} else {
						int a = i + 1, b = j - 2;
						while (a < b) {
							if (nums[a] > nums[b]) {
								temp2 += M[i][j - 2];
								break;
							} else if (nums[a] < nums[b]) {
								temp2 += M[i + 1][j - 1];
								break;
							} else {
								a++;
								b--;
							}
						}
						if (a >= b) {
							temp2 += Math.min(M[i + 1][j - 1], M[i][j - 2]);
						}
					}
					M[i][j] = Math.max(temp1, temp2);
				}
			}
		}

		return M[0][nums.length - 1];

	}

	public static void main(String[] args) {
		CanIWinII s = new CanIWinII();
//		System.out.println(s.canWin(new int[] { 11, 2, 19, 99, 23, 48, 97, 2, 85, 71 }));// 513
//		System.out.println(s.canWin(new int[] { 62, 92, 47, 65, 26, 47, 86 }));// 251
//		System.out.println(s.canWin(new int[] { 77, 47, 84, 31, 67, 38, 34, 56, 33, 52, 31, 99, 32, 98, 82, 85, 60 }));// 620
//		System.out.println(s.canWin(new int[] { 6, 95, 10, 77, 17, 75, 80, 87, 87, 73, 88, 6, 27, 39, 15 }));// 366
//		System.out.println(s.canWin(new int[] { 92, 47, 65, 26, 47 }));// 165
//		System.out.println(s.canWin(new int[] { 47, 65, 26, 47, 86 }));// 159
		System.out.println(s.canWin(new int[] { 2, 98, 97, 2, 85 }));// 184
		System.out.println(s.canWin(new int[] { 2, 96, 97, 2, 85 }));// 184

		System.out.println(s.canWin(new int[] { 2, 96, 2, 85 }));// 184
	}
}
