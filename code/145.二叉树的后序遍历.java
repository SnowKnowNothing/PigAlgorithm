import java.util.*;
/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        preOrderTraverse(res,root);
        return res;
    }

    private void preOrderTraverse(List<Integer> res, TreeNode root) {
        if(root==null){
            return ;
        }
        preOrderTraverse(res, root.left);
        preOrderTraverse(res, root.right);
        res.add(root.val);
    }
}
// @lc code=end

