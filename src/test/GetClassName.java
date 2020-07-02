package test;

public class GetClassName {

	
	private void getClassName(String in) {
		String[] cur = in.split(" ");
		StringBuilder sb = new StringBuilder();
		for(String c : cur) {
			sb.append(c);
		}
		System.out.print(sb.toString());
	}
	
	public static void main(String[] args) {
		GetClassName s = new GetClassName();
		s.getClassName("Minimum Time to Collect All Apples in a Tree");
	}
}
