package trees;


//Given a binary tree, find the length of the longest path where each node in the path has the same value.
//This path may or may not pass through the root.
//Note: The length of path between two nodes is represented by the number of edges between them.

public class LongestUnivaluePath {

	public static int longestUnivaluePath(TreeNode root){
		if(root==null ||(root.left==null && root.right==null)){
			return 0;
		}

		int heightOfNode=0;
      
		if(root.left!=null && root.left.val==root.val)
			heightOfNode+=height(root.left)+1;
		if(root.right!=null && root.right.val==root.val)
			heightOfNode+=height(root.right)+1;
        

		int leftMax=longestUnivaluePath(root.left);
		int rightMax=longestUnivaluePath(root.right);

		return Math.max(heightOfNode,Math.max(leftMax,rightMax));
	}


	public static int height(TreeNode root){
		
		if(root==null)
			return 0;

		int left=0;
		int right=0;
		boolean changed=false;
		if(root.left!=null && root.left.val==root.val){
			changed=true;
			left=height(root.left);
		}

		if(root.right!=null && root.right.val==root.val){
			changed=true;
			right= height(root.right);
		}
		if(changed)
			return Math.max(left, right)+1;
		return 0;
	}

	public static void main(String[] args) {
		TreeNode root=new TreeNode(5);
		root.left=new TreeNode(4);
		root.left.left=new TreeNode(1);
		root.left.right=new TreeNode(1);

		root.right=new TreeNode(5);
		root.right.right=new TreeNode(1);
		root.right.left=new TreeNode(5);

		System.out.println(longestUnivaluePath(root));
	}
}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}