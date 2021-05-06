import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
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
    List<List<Integer>> res=new LinkedList<>();
    Deque<Integer> path=new LinkedList<Integer>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        getPathSum(root, targetSum);
        return res;
    }
    public void getPathSum(TreeNode root, int targetSum){
        if(root==null){
            return ;
        }
        path.offerLast(root.val);
        if(root.left==null && root.right==null && root.val==targetSum){
            res.add(new LinkedList<>(path));
        }
        getPathSum(root.left, targetSum-root.val);
        getPathSum(root.right, targetSum-root.val);
        path.pollLast();
    }
}
// @lc code=end

