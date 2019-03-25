package leetcode;

import java.util.ArrayList;

public class LeetcodeTrees {
    public static void main(String args[]) {

    }

    /**
     * 验证二叉搜索树
     *
     * @param root
     * @return
     */
    double last=-Double.MAX_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (isValidBST(root.left)) {
            if (last < root.val) {
                last = root.val;
                return isValidBST(root.right);
            }
        }
        return false;
    }


    /**
     * 二叉树的最大深度
     *
     * @param root 0
     * @return 最大深度
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int lmax = maxDepth(root.left) + 1;
        int rmax = maxDepth(root.right) + 1;
        return lmax >= rmax ? lmax : rmax;
    }
}
