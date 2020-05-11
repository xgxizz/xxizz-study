package com.xu.study.tree;

import java.util.Stack;

/**
 * @Description
 * @Author xgx
 * @Date 2019/12/31 10:36
 */
public class TestTree {

    public static int run(TreeNode root) {
        int depth = 0;
        int tmpDepth = 0;
        Stack<TreeNode> s = new Stack<>();
        TreeNode t = root;
        if (root != null){
            s.push(t);
            tmpDepth ++;
        }else {
            return 0;
        }
        while (!s.isEmpty()){

            t = s.peek().left;
            if (t != null) {
                s.push(t);
                tmpDepth ++;
            }else {
                t = t.right;
                if (t == null){
                    if (tmpDepth<depth)
                    depth = tmpDepth;
                    s.pop();
                }
            }
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode treeNode0 = new TreeNode(0);
        treeNode0.left = new TreeNode(1);
        treeNode0.right = new TreeNode(2);
        treeNode0.left.right = new TreeNode(3);
        int depth = TestTree.run(treeNode0);
        System.out.println(depth);
    }

}
