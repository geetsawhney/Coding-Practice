//leetcode 114

class FlattenBinaryTree {
    public void flatten(TreeNode root) {

        flattenHelp(root);

    }

     public TreeNode flattenHelp(TreeNode root) {
        if(root == null)
            return null;
        TreeNode leftChild = flattenHelp(root.left);
        TreeNode rightChild = flattenHelp(root.right);
        root.left=null;
         if(leftChild == null)
         {
             root.right = rightChild;
             return root;
         }
         root.right = leftChild;

         if(rightChild == null)
             return root;

         while(leftChild.right!=null){
             leftChild=leftChild.right;
         }
         leftChild.right=rightChild;

         return root;
    }
}
