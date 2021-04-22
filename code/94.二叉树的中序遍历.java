import java.util.ArrayList;

import java.util.*;
/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        traverseTree(res, root);
        return res;
    }
    public void traverseTree(List<Integer> list,TreeNode node){
        if(node==null){
            return;
        }
        traverseTree(list,node.left);
        list.add(node.val);
        traverseTree(list,node.right);
    }
}
// @lc code=end
