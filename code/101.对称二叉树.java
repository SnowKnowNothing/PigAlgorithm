/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
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
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return isSameTree3(invertTree(root.left), root.right);
    }

    public static TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);
        TreeNode tmp=root.left;
        root.left=root.right;
        root.right=tmp;
        return root;
    }

    public static boolean isSameTree3(TreeNode p,TreeNode q){
        if(q==null && p==null){
            return true;
        }else if(p==null || q==null){
            return false;
        }else if(p.val!=q.val){
            return false;
        }else{
            return isSameTree3(p.left, q.left)&isSameTree3(p.right, q.right);
        }
    }
}
// @lc code=end

