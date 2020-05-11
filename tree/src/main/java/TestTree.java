import java.util.*;

/**
 * @Description
 * @Author xgx
 * @Date 2019/12/31 12:47
 */
public class TestTree {

    /**
     * @Description  中序遍历
     * @Author xgx
     * @Date 2019/12/31 14:20
     * @Param [root]
     * @return void
     */
    public static void inOrder(TreeNode root){
        Stack<TreeNode> s = new Stack<>();
        TreeNode p = root;
        while (!s.isEmpty() || p != null){
            if (p != null){
                s.push(p);
                p = p.left;
            }else {
                p = s.pop();
                System.out.println( p.val+ "\t");
                p = p.right;
            }
        }
    }

    //层序遍历
    public static void levelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        TreeNode p = root;
        if (p != null){
            queue.add(p);
        }
        while (!queue.isEmpty()) {
            p = queue.poll();
            System.out.print(p.val + "\t\n");
            if (p.left != null) {
                queue.add(p.left);
            }
            if (p.right != null) {
                queue.add(p.right);
            }
        }
    }

    //求二叉树的深度(递归)
    public static int depth_recurce(TreeNode root){
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        int left = depth_recurce(root.left);
        int right = depth_recurce(root.right);
        return left > right ? (left+ 1):(right + 1);
    }
    //求二叉树深度（非递归）
    //采用层次遍历的方法
    //每遍历一层，depth++;
    //每一层，需使用一个变量len记录该层的结点个数，也就是队列的当前长度，然后依次在队列中访问该层的len个结点（将队列中len个元素出队列），并将下一层如队列。
    public static int depth(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode p = root;
        if (p != null){
            queue.add(p);
        }
        int level = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            level ++;
            while (len-- > 0) {
                p = queue.poll();
                if (p.left != null) {
                    queue.add(p.left);
                }
                if (p.right != null) {
                    queue.add(p.right);
                }
//                if(p.right == null && p.left == null ){
//                    System.out.println("当前叶节点" + p.val + "的深度是：" + level);
//                }
            }
        }
        return level;
    }

    //求叶节点深度
    public static Map leaves_depth(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Integer> leaf_depthMap = new HashMap<>();
        TreeNode p = root;
        if (p != null){
            queue.add(p);
        }
        int level = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            level ++;
            while (len-- > 0) {
                p = queue.poll();
                if (p.left != null) {
                    queue.add(p.left);
                }
                if (p.right != null) {
                    queue.add(p.right);
                }
                if(p.right == null && p.left == null ){
                    leaf_depthMap.put(p, level);
                }
            }
        }
        return leaf_depthMap;
    }

    ////采用层次遍历的方法
    //每遍历一层，depth++;
    //每一层，需使用一个变量len记录该层的结点个数，也就是队列的当前长度，然后依次在队列中访问该层的len个结点（将队列中len个元素出队列），并将下一层如队列。
    public static int minleaf_depth(TreeNode root){
        int min_depth = -1;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode p = root;
        if (p != null){
            queue.add(p);
        }
        int level = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            level ++;
            while (len-- > 0) {
                p = queue.poll();
                if (p.left != null) {
                    queue.add(p.left);
                }
                if (p.right != null) {
                    queue.add(p.right);
                }
                if(p.right == null && p.left == null ){
                    if (min_depth == -1){
                        min_depth = level;
                    }else if(level < min_depth){
                        min_depth = level;
                    }
                }
            }
        }
        return min_depth;
    }



    public static void main(String[] args) {
        TreeNode treeNode0 = new TreeNode(0);
        treeNode0.left = new TreeNode(1);
        treeNode0.right = new TreeNode(2);
        treeNode0.right.right = new TreeNode(3);
        treeNode0.left.right = new TreeNode(4);
        treeNode0.left.right.left = new TreeNode(5);
        treeNode0.left.right.right = new TreeNode(6);
        treeNode0.right.right.right = new TreeNode(7);
        treeNode0.right.right.right.right = new TreeNode(8);
        inOrder(treeNode0);
        System.out.println();
        //层序遍历
        levelOrder(treeNode0);
        //二叉树深度
        System.out.println("二叉树的深度是：" + depth_recurce(treeNode0));
        System.out.println("非递归方式求二叉树的深度：" + depth(treeNode0));
        //所有叶节点深度
        Map<TreeNode, Integer> map = leaves_depth(treeNode0);
        Set<Map.Entry<TreeNode, Integer>> entries = map.entrySet();
        for (Map.Entry<TreeNode, Integer> entry: entries) {
            TreeNode key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("叶节点" + key.val + "的深度是：" + value);
        }
        //二叉树最小深度
        int minleaf_depth = minleaf_depth(treeNode0);
        System.out.println("二叉树最小深度是:" + minleaf_depth);


    }
}
