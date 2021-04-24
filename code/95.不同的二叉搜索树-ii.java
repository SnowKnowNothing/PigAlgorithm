import java.util.*;
/*
 * @lc app=leetcode.cn id=95 lang=java
 *
 * [95] 不同的二叉搜索树 II
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
    public List<TreeNode> generateTrees(int n) {
        if(n==0){
            return new ArrayList<TreeNode>();
        }
        return generateTrees(1,n);
    }
    public List<TreeNode> generateTrees(int start,int end){
        List<TreeNode> allTrees=new ArrayList<>();
        if(start>end){
            allTrees.add(null);
            return allTrees;
        }
        for(int i=start;i<=end;i++){
            List<TreeNode> left=generateTrees(start, i-1);
            List<TreeNode> right=generateTrees(i+1, end);
            for(TreeNode leftNode:left){
                for(TreeNode rightNode:right){
                    TreeNode currNode=new TreeNode(i);
                    currNode.left=leftNode;
                    currNode.right=rightNode;
                    allTrees.add(currNode);
                }
            }
        }
        return allTrees;
    }
}
// @lc code=end

