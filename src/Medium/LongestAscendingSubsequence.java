package Medium;

public class LongestAscendingSubsequence {
	public int longest(int[] array) {
		// Write your solution here
		if (array == null || array.length == 0) return 0;
		
		int[] ref = new int[array.length];
		ref[0] = array[0];
		int length = 1;
		
		for(int i = 1;i < ref.length; i++) {
			if(array[i] > ref[length-1]) {
				ref[length++] = array[i];
			}else if(array[i] < ref[length-1]) {
				int idx = helper(ref, 0, length - 1, array[i]);
				ref[idx] = array[i];
			}
		}
		return length;

		
	}
	
	private int helper(int[] ref, int start, int end, int val) {
		while(end > start) {
			int mid = start + (end - start) / 2;
			if(ref[mid] > val) {
				end = mid;
			}else if(ref[mid] < val) {
				start = mid + 1;
			}else {
				return mid;
			}
		}
		return end;
	}
	
	public static void main(String[] args) {
		LongestAscendingSubsequence s = new LongestAscendingSubsequence();
		int result = s.longest(new int[]{10,11,1,2,12,3,4});
		
		System.out.print(result);
	}
}
