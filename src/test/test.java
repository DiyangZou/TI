package test;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class test {
	
	public void aaa(int a, int b) {
		int tmp = a;
		a = b;
		b = tmp;
	}
	
	public void bbb(Integer a, Integer b) {
		int tmp = a;
		a = b;
		b = tmp;
	}
	
	public void SortedSetTest(int[] input) {
		TreeSet<Integer> set = new TreeSet<>();
		for(int i: input) {
			set.add(i);
		}
		
		SortedSet<Integer> sub = set.subSet(0, 10);
		Iterator<Integer> itr = sub.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
	}
	
	public static void main(String[] args) {
		int a1 = 1, a2 = 2;
		Integer b1 = 1, b2 = 2;
		
		test s = new test();
//		s.aaa(a1, a2);
//		s.bbb(b1, b2);
//		
//		System.out.println(a1);
//		System.out.println(a2);
//		System.out.println(b1);
//		System.out.println(b2);
		s.SortedSetTest(new int[] {1, 2,3,4,5, 11});
		
		
	}
	
}
