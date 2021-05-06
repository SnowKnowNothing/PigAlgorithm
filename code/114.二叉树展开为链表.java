import java.util.*;

/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
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
    List<TreeNode> list=new LinkedList<>();
    public void flatten(TreeNode root) {
        preOrder(root);
        for(int i=0;i<list.size()-1;i++){
            list.get(i).left=null;
            list.get(i).right=list.get(i+1);
        }
    }
    void preOrder(TreeNode root){
        if(root==null){
            return;
        }
        list.add(root);
        preOrder(root.left);
        preOrder(root.right);
    }
}
// @lc code=end

