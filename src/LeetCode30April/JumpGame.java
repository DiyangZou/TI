package LeetCode30April;

public class JumpGame {
	public boolean canJump(int[] nums) {
//		if(nums == null || nums.length == 0) {
//			return false;
//		}
//		
//		boolean[] dp = new boolean[nums.length];
//		dp[0] = true;
//		
//		for(int i = 1; i < nums.length; i++) {
//			for(int j = 0; j < i; j++) {
//				if(dp[j] && j + nums[j] >= i) {
//					dp[i] = true;
//					break;
//				}
//			}
//		}
//		return dp[dp.length - 1];
		if (nums == null || nums.length == 0)
            return false;
        
        int maxReachedSoFar = 0;
        for (int i=0; i < nums.length; i++){
            //from last position, maxReachedSoFar is the farthest distance, if its less than i, we failed to reach there.
            if (maxReachedSoFar < i)
                return false;
            
            //keep updating the max
            //maxReachedSoFar = ((nums[i]+i) > maxReachedSoFar)?(nums[i]+i):maxReachedSoFar;
            maxReachedSoFar = Math.max(maxReachedSoFar, nums[i]+i);
        }
        return true;
	}
	
	public static void main(String[] args) {
		JumpGame s = new JumpGame();
		System.out.println(s.canJump(new int[] {2,3,1,1,4}));
		System.out.println(s.canJump(new int[] {3,2,1,0,4}));
	}

}
