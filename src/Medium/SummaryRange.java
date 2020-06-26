package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SummaryRange {
	public String[] summaryRanges(int[] nums) {
	    // Write your solution here
	    if(nums == null || nums.length == 0) return new String[0];
	    List<String> list = new ArrayList<>();
	    for(int i=0;i<nums.length;i++){
	    	int a=nums[i];
	    	while(i+1<nums.length&&(nums[i+1]-nums[i])==1){
	    		i++;
	    	}
	    	if(a!=nums[i]){
	    		list.add(a+"->"+nums[i]);
	    	}else{
	    		list.add(a+"");
	    	}
	    }
	    String[] res = list.toArray(new String[0]);
	    return  res;
	  }
	
	public static void main(String[] args) {
		SummaryRange s = new SummaryRange();
		System.out.println(Arrays.deepToString(s.summaryRanges(new int[] {0,1,2,4,5,7})));
	}
}
