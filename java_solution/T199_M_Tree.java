import java.util.*;

public class T199_M_Tree {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int layerNum = 1;
        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode node = new TreeNode();
            int nowLayerNum = 0;
            // 按层遍历二叉树
            for (int i = 0; i < layerNum; i++) {
                nowLayerNum = 0;
                node = queue.poll();
                if (node.left != null){
                    queue.offer(node.left);
                    nowLayerNum++;
                }
                if (node.right != null){
                    queue.offer(node.right);
                    nowLayerNum++;
                }
            }
            ans.add(node.val);
            layerNum = nowLayerNum;
        }
        return ans;
    }
}
