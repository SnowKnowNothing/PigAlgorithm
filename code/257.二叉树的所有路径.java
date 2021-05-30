import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=257 lang=java
 *
 * [257] 二叉树的所有路径
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
    List<String> ans=new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root==null){
            return ans;
        }
        getPaths(root,Integer.valueOf(root.val).toString());
        return ans;
    }
    private void getPaths(TreeNode root, String str) {
        if(root.left==null && root.right==null){
            ans.add(str);
            return;
        }
        if(root.left!=null){
            getPaths(root.left, str+"->"+root.left.val);
        }
        if(root.right!=null){
            getPaths(root.right, str+"->"+root.right.val);
        }
    }
}
// @lc code=end

