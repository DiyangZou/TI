package TI;

public class LongestBitonicSequence {
	public int longestBitonic(int[] array) {
	    // Write your solution here
	    if(array == null || array.length == 0){
	      return 0;
	    }
	    int[] dp = new int[array.length], dp2 = new int[array.length];
	    dp[0] = 1;
	    dp2[array.length - 1] = 1;
	    for(int i= 1; i < array.length; i++){
	      dp[i] = 1;
	      for(int j = 0; j < i ; j++){
	        if(array[j] < array[i]){
	          dp[i] = Math.max(dp[j] + 1, dp[i]);
	        }
	      }
	    }

	    for(int i= array.length - 2; i >= 0; i--){
	      dp2[i] = 1;
	      for(int j = array.length- 1; j > i; j--){
	        if(array[j] < array[i]){
	          dp2[i] = Math.max(dp2[j] + 1, dp2[i]);
	        }
	      }
	    }

	    int result = dp[0] + dp2[0] - 1;
	    for(int i = 1; i < array.length; i++){
	      result = Math.max(result, dp[i] + dp2[i] - 1);
	    }
	    return result;
	  }
	
	public static void main(String[] args) {
		LongestBitonicSequence s = new LongestBitonicSequence();
		int res = s.longestBitonic(new int[] {1,5,2,4,3});
		System.out.print(res);
	}
	

}
