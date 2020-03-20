package TI;

import java.util.Arrays;

public class HeapSortTest {
	public int[] heapsort(int[] array) {
	    // Write your solution here
	    for(int i=array.length-1;i>=0;i--){
			  //remove the root, and put the last leaf at the root of the heap
			  int tmp = array[i];
			  array[i]=array[0];
			  array[0] = tmp;
			  //bubble the new root down to the correct location
			  sink(array,0,i);
		  }
		  return array;
	  }

	  private void sink(int[] array, int start, int end){
	    int val = array[start];
	    int i = start, next = start * 2 + 1;
	    while(next < end){
	      if(next + 1 < end && array[next + 1] < array[next]){
	        next++;
	      }
	      if(array[next] <= val){
	        break;
	      }
	      array[i] = array[next];
	      i = next;
	      next = 2 * i + 1;
	    }
	    array[i] = val;
	  }
	 
	  public static void main(String[] args) {
		  HeapSortTest s = new HeapSortTest();
		  //int[] result = s.heapsort(new int[] {1,2,3});
		  //System.out.println(Arrays.toString(result));
		  int[] res = s.heapsort(new int[] {1,2,3});
		  System.out.println(Arrays.toString(res));
	}
}
