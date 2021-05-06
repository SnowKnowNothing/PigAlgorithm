/*
 * @lc app=leetcode.cn id=99 lang=java
 *
 * [99] 恢复二叉搜索树
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
    TreeNode targetOne=null,targetTwo=null,pre=null;
    public void recoverTree(TreeNode root) {
        inOrderTraverse(root);
        if(targetOne!=null && targetTwo!=null){
            int tmp=targetOne.val;
            targetOne.val=targetTwo.val;
            targetTwo.val=tmp;
        }
    }

    private void inOrderTraverse(TreeNode root) {
        if(root==null){
            return ;
        }
        inOrderTraverse(root.left);
        if(pre!=null && pre.val>root.val){
            if(targetOne==null){
                targetOne=pre;
            }
            targetTwo=root;
        }
        pre=root;
        inOrderTraverse(root.right);
    }
}
// @lc code=end

