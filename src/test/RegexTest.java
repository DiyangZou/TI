package test;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
	
	public void regexTest(String test) {
		if(test == null) return;
		
		Pattern p = Pattern.compile("^740[0-9]{5}$");
		Matcher m = p.matcher(test);
		
		System.out.println(m.find());
		
//		String aa = null;
//		
//		System.out.println(aa.equalsIgnoreCase("abcd"));
		
	}
	
	public static void main(String[] args) {
//		RegexTest s = new RegexTest();
//		String[] test = new String[] {
//		"74012345", "7401", "74111", "84010203"
//		};
//		for(String str: test) {
//			s.regexTest(str);
//		}
		String dd = "";
//		BigDecimal d = new BigDecimal(dd);
//		System.out.println(d);
		
		Test t = new Test();
		t.setName("abcs");
		
		System.out.println(dd.isEmpty());
		
		int x = 0;
		int y = 1 << x;
		System.out.print(y);
		
		
	}
}
class Test{
	private String name;
	
	public Test() {
	}
	public void setName(String name) {
		this.name = name;
	}
}
