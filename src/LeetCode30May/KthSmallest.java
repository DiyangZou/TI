package LeetCode30May;

import java.util.Deque;
import java.util.LinkedList;

public class KthSmallest {
	public int kthSmallest(TreeNode root, int k) {

//		if(root == null) return -1;
//		
//		Deque<TreeNode> stack = new LinkedList<>();
//		while(root != null) {
//			stack.offerFirst(root);
//			root = root.left;
//		}
//		
//		while(k > 0) {
//			TreeNode node = stack.pollFirst();
//			k--;
//			if(k == 0) return node.val;
//			TreeNode right = node.right;
//			while(right != null) {
//				stack.offerFirst(right);
//				right = right.left;
//			}
//		}
//		return -1;
//		
		int count = 0;
		int ksmall = Integer.MAX_VALUE;
		TreeNode current = root;
		while (current != null) {
			if (current.left == null) {
				count++;
				if (count == k) {
					ksmall = current.val;
					break;
				}
				current = current.right;
			} else {
				TreeNode prev = current.left;
				while (prev.right != null && prev.right != current)
					prev = prev.right;
				if (prev.right == null) {
					prev.right = current;
					current = current.left;
				} else {
					prev.right = null;
					count++;
					if (count == k) {
						ksmall = current.val;
						break;
					}
					current = current.right;
				}
			}
		}

		return ksmall;

	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
