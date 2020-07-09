package test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class TestIn2{
	
	public int test() {
		int k = -1;
		int b = k % 3;
		return b;
	}
	
	public static void main(String[] args) {
		TestIn2 s = new TestIn2();
		System.out.println(s.test());
		
		StringBuilder sb = new StringBuilder();
		int n = 4;
		sb.append("1/3");
		sb.append(n);
		System.out.println(sb.toString());
		
		List<Integer> res = new ArrayList<>();
		res.add(1234);
		res.add(43424);
		
		//String testA = StringUtils.join(intList, "|");
		
		String as = res.toArray().toString();
		
		String result = res.stream()
			      .map(asa -> String.valueOf(asa))
			      .collect(Collectors.joining(","));
		
		System.out.println(result);
		
		
	}

}
