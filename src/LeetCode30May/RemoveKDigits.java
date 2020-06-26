package LeetCode30May;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveKDigits {

	public String removeKdigits(String num, int k) {
		if(num == null || num.length() == 0 ) {
			return "0";
		}
		
		char[] nums = num.toCharArray();
		char[] stck = new char[nums.length];
		int top = 0, digits = nums.length - k, startK = k;
		
		for(int i = 0; i < nums.length; i++) {
			char cur = nums[i];
			while(top > 0 && stck[top - 1] > cur && k > 0) {
				top -= 1;
				k -= 1;
			}
			stck[top++] = cur;
		}
		
		Deque<Character> stack = new LinkedList<>();
		for(char ch: nums) {
			while(startK > 0 && !stack.isEmpty() && stack.peekFirst() > ch) {
				stack.pollFirst();
				startK--;
			}
			stack.offerFirst(ch);
		}
		
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			sb.append(stack.pollLast());
		}
		while(sb.length() > 0 && sb.charAt(0) == '0') {
			sb.deleteCharAt(0);
		}
		System.out.println(sb.length() == 0 ? "0":sb.toString());
		
		
		int idx = 0;
        while (idx < digits && stck[idx] == '0') idx++;
        return idx == digits? "0": new String(stck, idx, digits - idx);
		
	}
	
	public static void main(String[] args) {
		RemoveKDigits s = new RemoveKDigits();
		System.out.print(s.removeKdigits("10200", 1));
		
	}
}
