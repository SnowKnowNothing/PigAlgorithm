import java.util.ArrayList;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=100 lang=java
 *
 * [100] 相同的树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<TreeNode> pList = new ArrayList<>();
        List<TreeNode> qList = new ArrayList<>();
        traverse(pList, p);
        traverse(qList, q);
        if (pList.size() != qList.size()) {
            return false;
        }
        for (int i = 0; i < pList.size(); i++) {
            if (pList.get(i).val != qList.get(i).val) {
                return false;
            }
        }
        return true;

    }

    public static void traverse(List<TreeNode> list, TreeNode node) {
        if (node == null) {
            list.add(new TreeNode());
            return;
        }
        list.add(node);
        traverse(list, node.left);
        traverse(list, node.right);
    }
}
// @lc code=end
