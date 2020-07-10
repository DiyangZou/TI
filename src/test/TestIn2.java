package test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public class TestIn2{
	
	public int test() {
		int k = -1;
		int b = k % 3;
		return b;
	}
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Person a = new Person("a", "b", null);
		Field[] f = a.getClass().getDeclaredFields();
		List<String> lis = new ArrayList<>();

		lis.add(a.getFname());
		lis.add(a.getLname());
		lis.add(a.getAge());
		lis.add("0");
		lis.add("1");
		lis.add("2");
		lis.add("3");
		lis.add("4");
		lis.add("5");
		
	}

}
class Person{
	public String fname;
	public String lname;
	public String age;
	
	public Person(String fname, String lname, String age) {
		this.fname = fname;
		this.lname = lname;
		this.age = age;
	}
	
	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFname(){
		return fname;
	}
	
}
