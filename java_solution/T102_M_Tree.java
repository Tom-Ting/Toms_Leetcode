import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class T102_M_Tree {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }
        TreeNode temp;

        while (!queue.isEmpty()){
            int layerNum = queue.size();
            List<Integer> layer = new ArrayList<>();
            for (int i = 0; i < layerNum; i++) {
                temp = queue.poll();
                layer.add(temp.val);
                if (temp.left != null){
                    queue.offer(temp.left);
                }
                if (temp.right != null){
                    queue.offer(temp.right);
                }
            }
            ans.add(layer);
        }
        return ans;
    }
}
