package TI;

public class ValidPostorderTraversalOfBinarySearchTree {
	public boolean validPostOrder(int[] post) {
	    // Write your solution here
	    return helper(post, 0, post.length - 1);
	  }

	  private boolean helper(int[] post, int start, int end){
	    if(start >= end){
	      return true;
	    }
	    int cur = post[end], next = end - 1;
	    while(next >= start && post[next] > cur){
	      next--;
	    }
	    int tmp = next;
	    while(next >= start){
	      if(post[next] > cur){
	        return false;
	      }
	      next--;
	    }
	    if(tmp == start) {
	      return helper(post, start, end - 1);
	    }else{
	      return helper(post, start, tmp) && helper(post,tmp+1, end - 1);
	    }
	  }
	  
	  public static void main(String[] args) {
		  ValidPostorderTraversalOfBinarySearchTree s = new ValidPostorderTraversalOfBinarySearchTree();
		  boolean result = s.validPostOrder(new int[] {3,2,1});
		  System.out.print(result);
	}
}
