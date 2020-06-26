package Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new ArrayList<>();
		List<String> res = new ArrayList<>();

		helper(result, res, n);
		return result;
	}

	private void helper(List<List<String>> result, List<String> res, int n) {
		if (res.size() == n) {
			result.add(new ArrayList<String>(res));
			return;
		}
		for (int i = 0; i < n; i++) {
			if (isValid(res, i)) {
				char[] cur = new char[n];
				for (int j = 0; j < n; j++) {
					if(j == i) {
						cur[j] = 'Q';
					}else {
						cur[j] = '.';
					}
				}
				res.add(new String(cur));
				helper(result, res, n);
				res.remove(res.size() - 1);
			}
		}

	}

	private boolean isValid(List<String> res, int idx) {
		int row = res.size();
		for (int i = 0; i < row; i++) {
			String str = res.get(i);
			int qIdx = findQueen(str);
			if (qIdx == idx || row - i == Math.abs(idx - qIdx)) {
				return false;
			}
		}
		return true;
	}

	private int findQueen(String str) {
		char[] ch = str.toCharArray();
		for (int i = 0; i < str.length(); i++) {
			if (ch[i] == 'Q')
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		NQueens s = new NQueens();
		List<List<String>> r = s.solveNQueens(4);
		for (List<String> rr : r) {
			System.out.print(Arrays.deepToString(rr.toArray()));
		}
	}
}
