package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CodeTest {
	
	public static void main(String[] args) throws IOException {
	    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
	    BufferedReader in = new BufferedReader(reader);
	    String line;
	    while ((line = in.readLine()) != null) {
	      List<String> result = decoder(line);
	      for(String s : result){
	        System.out.println(s);
	      }
	    }
	  }
	  
	  private static List<String> decoder(String input){
	    List<String> result = new ArrayList<>();
	    if(input.isEmpty()) return result;
	    
	    String[] map = new String[]{"", "abc", "def", "ghi","jkl","mno", "pqr", "stu", "vwx", "yz"};
	    char[] in = input.toCharArray();StringBuilder sb = new StringBuilder();
	    helper(result, sb, in, map, 0);
	    return result;
	  }
	  
	  private static void helper(List<String> result, StringBuilder sb, char[] in, String[] map, int idx){
	     if(idx == in.length){
	       String res = sb.toString();
	       result.add(res);
	       return;
	     }
	     int curNum = Character.getNumericValue(in[idx]);
	     String value = map[curNum];
	     char[] val = value.toCharArray();
	    
	     for(int i = 0; i < val.length; i++){
	       sb.append(val[i]);
	       helper(result, sb, in, map, idx+1);
	       sb.deleteCharAt(sb.length() - 1);
	     }
	    
	  }
	
}
