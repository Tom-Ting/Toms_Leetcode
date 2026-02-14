import java.util.Stack;

public class T230_M_Tree {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        // 压进栈不是访问
        stack.push(root);
        root = root.left;
        while (true){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            // 访问节点
            root = stack.pop();
            k--;
            if (k == 0){
                break;
            }
            root = root.right;
        }
        return root.val;
    }
}

/*
    二叉搜索树的中序遍历就是全排序
    注意，即便是中序遍历，左也在右前
    怎么一个一个弹值？
 */
