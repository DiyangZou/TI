package test;


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
		
	}

}
