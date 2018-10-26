
class MaximumBinaryTree {

    private static TreeNode helper(int nums[], int start, int end){
        if(start>end){
            return null;
        }

        int maxIndex=findMax(nums,start,end);
        TreeNode root=new TreeNode(nums[maxIndex]);
        root.left=helper(nums,start,maxIndex-1);
        root.right=helper(nums,maxIndex+1,end);

        return root;
    }
    private static int findMax(int nums[], int start, int end){
        int max=Integer.MIN_VALUE;
        int index=start;
        for(int i=start;i<=end;i++){
            if(nums[i]>max){
                max=nums[i];
                index=i;
            }
        }
        return index;
    }
    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums,0,nums.length-1);
    }


    public static void main(String[] args) {

    }

}
