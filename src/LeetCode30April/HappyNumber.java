package LeetCode30April;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

//	public boolean isHappy(int n) {
//		
//		Set<Integer> seen = new HashSet<>();
//		while(n != 1) {
//			n = helper(n, seen);
//			if(n == -1) {
//				break;
//			}
//			int happy = n;
//			seen.add(happy);
//		}
//		return n == 1;
//	}
//	
//	private int helper(int n, Set<Integer> seen) {
//		int curSum = 0;
//		while(n > 0) {
//			int digit = n % 10;
//			curSum += digit * digit;
//			n = n/10;
//		}
//		return seen.contains(curSum) ? -1:curSum;
//	}
	
	public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        
        do {
            slow = HappySq(slow);
            fast = HappySq(HappySq(fast));
        } while (slow!=fast);
        return slow == 1? true: false;
    }
    
    private int HappySq(int n) {
        int num = 0;
        while(n != 0) {
            num = num + (n%10) * (n%10);
            n= n/10;
        }
        return num;
    }
	
	public static void main(String[] args) {
		HappyNumber s = new HappyNumber();
		boolean result = s.isHappy(0);
		System.out.print(result);
	}

}
