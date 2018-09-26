//Leetcode 100
package trees;

class SameTree {
	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if(p==q)
			return true;

		if(p==null || q==null)
			return false;

		if(p.val!=q.val)
			return false;

		return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
	}

	public static void main(String args[]) {

		TreeNode p=new TreeNode(10);
		TreeNode q=new TreeNode(10);
		q.left=new TreeNode(10);
		System.out.println(isSameTree(p, q));
	}
}
