/*
 * @lc app=leetcode.cn id=129 lang=java
 *
 * [129] 求根节点到叶节点数字之和
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }
        return getSumNumbers(root,0);
    }

    private int getSumNumbers(TreeNode root, int i) {
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null ){
            return root.val+i*10;
        }
        return getSumNumbers(root.left, 10*i+root.val)+getSumNumbers(root.right, 10*i+root.val);
    }

}
// @lc code=end

