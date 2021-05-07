import java.util.*;

/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
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
    public List<Integer> preorderTraversal(TreeNode root) {
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
        res.add(root.val);
        preOrderTraverse(res, root.left);
        preOrderTraverse(res, root.right);
    }
}
// @lc code=end

