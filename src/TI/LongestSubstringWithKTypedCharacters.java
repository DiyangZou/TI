package TI;

/*
\Given a string, return the longest contiguous substring that contains exactly k type of characters.

Return null if there does not exist such substring.

Assumptions:

The given string is not null and guaranteed to have at least k different characters.
k > 0.
Examples:

input = "aabcc", k = 3, output = "aabcc".
input = "aabcccc", k = 2, output = "bcccc".*/
public class LongestSubstringWithKTypedCharacters {
	
	public String longest(String input, int k) {
	    // Write your solution here
		int[] count = new int[256];
        int num = 0, i = 0;
        int[] res = new int[] {0, 0};
        for (int j = 0; j < input.length(); j++) {
            if (count[input.charAt(j)]++ == 0) num++;
            if (num > k) {
                while (--count[input.charAt(i++)] > 0);
                num--;
            }
            int len =  res[1] - res[0];
            if(j - i > len) {
            	res[0] = i;
            	res[1] = j;
            }
            
        }
		
		return input.substring(res[0], res[1]+1);
	  }
	
	public static void main(String[] args) {
		LongestSubstringWithKTypedCharacters s = new LongestSubstringWithKTypedCharacters();
		String result = s.longest("dabaaebac", 4);
		System.out.print(result);
	}

}
