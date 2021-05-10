import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=173 lang=java
 *
 * [173] 二叉搜索树迭代器
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
class BSTIterator {
    Queue<TreeNode> queue=null;
    public BSTIterator(TreeNode root) {
        queue=new LinkedList<>();
        inOrderBST(root);
    }
    
    private void inOrderBST(TreeNode root) {
        if(root==null){
            return ;
        }
        inOrderBST(root.left);
        queue.offer(root);
        inOrderBST(root.right);
    }

    public int next() {
        return queue.poll().val;
    }
    
    public boolean hasNext() {
        return queue.peek()!=null;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
// @lc code=end

