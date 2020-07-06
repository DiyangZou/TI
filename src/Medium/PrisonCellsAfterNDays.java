package Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrisonCellsAfterNDays {
	public int[] prisonAfterNDays(int[] cells, int N) {
//        int n = cells.length;
//        for(int i = 0; i < N; ++i){
//        	int[] dp = new int[n];
//            for(int j = 1; j < n - 1; ++j){
//                dp[j] = cells[j-1] == cells[j + 1] ? 1:0;
//            }
//            cells = dp;
//        }
//        return cells;

		Map<String, Integer> seen = new HashMap<>();
        while (N > 0) {
            int[] cells2 = new int[8];
            seen.put(Arrays.toString(cells), N--);
            for (int i = 1; i < 7; ++i)
                cells2[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
            cells = cells2;
            if (seen.containsKey(Arrays.toString(cells))) {
                N %= seen.get(Arrays.toString(cells)) - N;
            }
        }
        return cells;
        
// loop pattern
//		for (N = (N - 1) % 14 + 1; N > 0; --N) {
//            int[] cells2 = new int[8];
//            for (int i = 1; i < 7; ++i)
//                cells2[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
//            cells = cells2;
//        }
//        return cells;
	}

	public static void main(String[] args) {
		PrisonCellsAfterNDays s = new PrisonCellsAfterNDays();
		System.out.println(Arrays.toString(s.prisonAfterNDays(new int[] { 0, 1, 0, 1, 1, 0, 0, 1 }, 2)));
	}
}
