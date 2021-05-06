import java.util.*;

/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
       return isTree(root);
    }
    public static boolean isTree(TreeNode root){
        if (root == null) {
            return true;
        }
        if (root.left != null ) {
            List<TreeNode> list=new ArrayList<>();
            traverse(list, root.left);
            for(TreeNode node: list){
                if(root.val<=node.val){
                    return false;
                }
            }
        }
        if (root.right != null ) {
            List<TreeNode> list=new ArrayList<>();
            traverse(list, root.right);
            for(TreeNode node: list){
                if(root.val>=node.val){
                    return false;
                }
            }
        }
        boolean leftRes=isTree(root.left);
        boolean rightRes=isTree(root.right);
        return leftRes&rightRes;
    }
    public static void traverse(List<TreeNode> list,TreeNode root){
        if(root==null){
            return;
        }
        list.add(root);
        traverse(list, root.left);
        traverse(list, root.right);
    }
}
// @lc code=end
