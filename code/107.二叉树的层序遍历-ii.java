import java.util.*;


/*
 * @lc app=leetcode.cn id=107 lang=java
 *
 * [107] 二叉树的层序遍历 II
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        List<List<Integer>> rootOrder=new ArrayList<>();
        queue.offer(root);
        while(queue.size()>0){
            int size=queue.size();
            List<Integer> res=new ArrayList<>();
            for(int i=0;i<size;i++){
                if(queue.peek().left!=null){
                    queue.offer(queue.peek().left);
                }
                if(queue.peek().right!=null){
                    queue.offer(queue.peek().right);
                }
                res.add(queue.poll().val);
            }
            rootOrder.add(res);
        }
        int num=rootOrder.size();
        List<List<Integer>> result=new ArrayList<>(num);
        for(int i=num-1;i>=0;i--){
            result.add(rootOrder.get(i));
        }
        return result;
    }
}
// @lc code=end

