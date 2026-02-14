public class T108_E_Tree {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = helper(nums, 0, nums.length-1);
        return root;
    }

    public TreeNode helper(int[] nums, int left, int right){
        if (left > right){
            return null;
        }
        TreeNode root = new TreeNode();
        int mid = (left+right)/2;
        root.val = nums[mid];

        root.left = helper(nums, left, mid-1);
        root.right = helper(nums, mid+1, right);
        return root;
    }
}
