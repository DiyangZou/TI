package Medium;

public class LastMomentBeforeAllAntsFallOutofaPlank {
	public int getLastMoment(int n, int[] left, int[] right) {
		int result = 0;
		for(int l: left) {
			result = Math.max(result, l);
		}
		for(int r: right) {
			result = Math.max(result, r);
		}
		return result;
	}
}
