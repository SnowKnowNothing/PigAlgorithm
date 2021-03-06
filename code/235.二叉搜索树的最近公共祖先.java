/*
 * @lc app=leetcode.cn id=235 lang=java
 *
 * [235] 二叉搜索树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode commonAncestor=root;
        while(true){
            if(commonAncestor.val>p.val && commonAncestor.val>q.val){
                commonAncestor=commonAncestor.left;
            }
            else if(commonAncestor.val<p.val && commonAncestor.val<q.val){
                commonAncestor=commonAncestor.right;
            }
            else{
                return commonAncestor;
            }
        }
    }
}
// @lc code=end

