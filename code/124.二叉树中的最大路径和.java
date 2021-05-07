/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    int maxValue = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        countMaxPathSum(root);
        return maxValue;
    }

    private int countMaxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = countMaxPathSum(root.left);
        int right = countMaxPathSum(root.right);
        int sum;
        if (left < 0 && right >= 0) {
            sum = right + root.val;
        } else if (left >= 0 && right < 0) {
            sum = left + root.val;
        } else if (left < 0 && right < 0) {
            sum = root.val;
        } else {
            sum = left + right + root.val;
        }
        maxValue = Math.max(maxValue, sum);
        //如果有负数时就只取当前根结点的val
        if (Math.max(left, right) < 0) {
            return root.val;
        } else {
            return Math.max(left, right) + root.val;
        }
    }

}
// @lc code=end
