package LeetCode30April;

public class LongestCommonSubsequence {
	public int longestCommonSubsequence(String text1, String text2) {
		int m = text1.length(), n = text2.length();
		char[] t1 = text1.toCharArray(), t2 = text2.toCharArray();
		
		int[][] matrix = new int[m+1][n+1];
		
		for(int i = 1; i < m+1; i++) {
			for(int j = 1; j < n+1; j++) {
				if(t1[i-1] == t2[j-1]) {
					matrix[i][j] = Math.max(matrix[i-1][j-1] + 1, matrix[i][j]);
				}else {
					int curMin = Math.max(matrix[i][j-1], matrix[i-1][j]);
					matrix[i][j] = curMin;
				}
			}
		}
		return matrix[m][n];
	}
	
	public static void main(String[] args) {
		LongestCommonSubsequence s = new LongestCommonSubsequence();
		System.out.println(s.longestCommonSubsequence("abcde", "ace" ));
		System.out.println(s.longestCommonSubsequence("ace", "ace" ));
		System.out.println(s.longestCommonSubsequence("def", "abc" ));
	}

}
