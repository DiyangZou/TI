package TI;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class FormLargestNumber {
	
	public String largestNumber(String[] input) {
	    // Write your solution here
		
		if(input == null || input.length == 0) {
			return "";
		}
	    Arrays.sort(input, new Comparator<String>() {
	    	@Override
	    	public int compare(String e1, String e2) {
	    		String one = e1 + e2;
	    		String two = e2 + e1;
	    		Long numOne = Long.parseLong(one);
	    		Long numTwo = Long.parseLong(two);
	    		
	    		return numOne > numTwo ? -1:1;
	    	}
	    });
	    
	    String res = "";
	    for(int i = 0; i < input.length; i++) {
	    	res += input[i];
	    }

	    char[] resChar = res.toCharArray();
	    int i = 0;
	    while(i < resChar.length &&  resChar[i] == '0') {
	    	i++;
	    }
	    if(i == resChar.length) return "0";
	    return res.substring(i, res.length());
	  }
	
	public static void main(String[] args) {
		FormLargestNumber s = new FormLargestNumber();
		String result = s.largestNumber(new String[] {"0", "0"});
		System.out.println(result);
	}

}
