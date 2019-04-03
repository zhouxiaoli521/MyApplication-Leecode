package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetcodeTrees {
    public static void main(String args[]) {

    }


    /**
     * 将有序数组转换为二叉搜索树
     * @param nums 0
     * @return 0
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        // 左右等分建立左右子树，中间节点作为子树根节点，递归该过程
        return nums == null ? null : buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int m = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = buildTree(nums, l, m - 1);
        root.right = buildTree(nums, m + 1, r);
        return root;
    }

    /**
     * 二叉树的层次遍历
     * 遍历 把当前深度传递下去 用当前深度做游标获取list来保存当前节点
     * @param root 0
     * @return 0
     */

    List<List<Integer>> leve = new ArrayList<List<Integer>>(10);
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return leve;
        levelOrder(root, 0);
        return leve;
    }

    public void levelOrder(TreeNode lt, int dep) {
        if (lt == null) return;
        if (leve.size()-1 < dep)
            leve.add(new ArrayList<Integer>());
        leve.get(dep).add(lt.val);
        levelOrder(lt.left, dep + 1);
        levelOrder(lt.right, dep + 1);
    }


    /**
     * 对称二叉树
     * 把两颗树的左右节点都传下去比较
     * @param root 0
     * @return b
     */
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root,root);
    }

    public boolean isMirror(TreeNode l,TreeNode r) {
        if (l == null && r == null) return true;
        if (l == null || r == null) return false;

        return (l.val == r.val) && isMirror(l.left, r.right) && isMirror(l.right,r.left);
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
