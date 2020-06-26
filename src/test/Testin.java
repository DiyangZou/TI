package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Testin {

	public static void main(String[] args) throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
		BufferedReader in = new BufferedReader(reader);
		String line;
		while ((line = in.readLine()) != null) {
			System.out.println(line);
		}
	}

	private static boolean bracketChecker(String input){
	    if(input.isEmpty()) return false;
	    char[] in = input.toCharArray();
	    Map<Character, Character> map = new HashMap<>();
	    map.put(']', '[');
	    map.put('}', '{');
	    
	    Deque<Character> q = new LinkedList<>();
	    for(int i = 0; i < in.length; i++){
	      if(in[i] == '[' || in[i] == '{'){
	        q.offerFirst(in[i]);
	      }else if(map.containsKey(in[i])){
	          if(q.isEmpty() || q.peek() != map.get(in[i])){
	            return false;
	          }else{
	            q.pollFirst();
	          }
	      }else{
	        continue;
	      }
	    }
	    return q.isEmpty();
	    
	  }
}
