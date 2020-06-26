package Hard;

import java.util.ArrayList;
import java.util.List;

public class Findallbinarysearchtrees {

	public class TreeNode {
		public int key;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int key) {
			this.key = key;
		}
	}

	public List<TreeNode> generateBSTs(int n) {
		List<TreeNode> result = buildBST(1, n);
		return result;
	}
	
	private List<TreeNode> buildBST(int l, int r) {
		List<TreeNode> list = new ArrayList<>();
		if(l > r) {
			list.add(null);
			return list;
		}
		
		for(int i = l; i <= r; i++) {
			List<TreeNode> leftSub = buildBST(l, i-1);
			List<TreeNode> rightSub = buildBST(i+1, r);
			
			for(int j = 0; j < leftSub.size(); j++) {
				TreeNode left = leftSub.get(j);
				for(int k = 0; k < rightSub.size(); k++) {
					TreeNode right = rightSub.get(k);
					TreeNode root = new TreeNode(i);
					root.left = left;
					root.right = right;
					list.add(root);
				}
			}
			
		}
		return list;
	}

}
