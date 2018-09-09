package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
	public static List<List<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> q= new LinkedList<>();
		
		List<List<Integer>> l= new ArrayList<List<Integer>>();
		
		if(root==null)
			return l;
		
		q.add(root);
		q.add(null);
		
		l.add(new ArrayList<>());
		int i=0;
		
		TreeNode current;
		
		while(!q.isEmpty()) {
			current=q.poll();
			if(current!=null) {
				if(current.left!=null)
					q.add(current.left);
				if(current.right!=null)
					q.add(current.right);

				l.get(i).add(current.val);
			}
			else {
				if(q.isEmpty())
					return l;
				i++;
				l.add(new ArrayList<>());
				q.add(null);
			}
		}
		return l;
	}

	public static void main(String[] args) {
		System.out.println(levelOrder(new TreeNode(10)));
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}