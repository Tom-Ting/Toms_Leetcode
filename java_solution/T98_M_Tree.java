import org.junit.Test;

public class T98_M_Tree {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
    public boolean dfs(TreeNode root, long Max, long Min){
        if (root == null){
            return true;
        }
        if (root.val <= Min || root.val >= Max){
            return false;
        }
        return dfs(root.left, root.val, Min) && dfs(root.right, Max, root.val);
    }

    @Test
    public void Test(){
        System.out.println(2147483647);
        System.out.println(Integer.MAX_VALUE);
    }
}
