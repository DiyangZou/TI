package test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TestIn2{
	
	public int test() {
		int k = -1;
		int b = k % 3;
		return b;
	}
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		
		System.out.println('1' - '0');
		
		
		
		
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
