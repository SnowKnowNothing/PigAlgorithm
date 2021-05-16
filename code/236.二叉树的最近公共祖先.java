/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> pStack = new Stack<TreeNode>();
        Stack<TreeNode> qStack = new Stack<TreeNode>();
        getAcestorStack(root, pStack, p);
        getAcestorStack(root, qStack, q);
        pStack.push(p);
        qStack.push(q);
        TreeNode res = null;
        for (int i = 0; i < pStack.size() && i < qStack.size(); i++) {
            if (pStack.get(i).val == qStack.get(i).val) {
                res = pStack.get(i);
            } else {
                break;
            }
        }
        return res;

    }

    public void getAcestorStack(TreeNode root, Stack<TreeNode> stack, TreeNode node) {
        if (root == null) {
            return;
        }
        stack.push(root);
        if (root.val == node.val) {
            return;
        }
        getAcestorStack(root.left, stack, node);
        getAcestorStack(root.right, stack, node);
        stack.pop();
    }
}
// @lc code=end
