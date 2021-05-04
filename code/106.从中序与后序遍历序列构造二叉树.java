import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    private static Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int num = inorder.length;
        indexMap = new HashMap<Integer, Integer>(num);
        for (int i = 0; i < num; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildMyTree(inorder, postorder, 0, num - 1, 0, num - 1);
    }

    private static TreeNode buildMyTree(int[] inorder, int[] postorder, int inLeft, int inRight, int poLeft, int poRight) {
        if (inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[poRight]);
        int rootIndex = indexMap.get(postorder[poRight]);
        int inLeftSize = rootIndex - inLeft;
        root.left = buildMyTree(inorder, postorder, inLeft, inLeft + inLeftSize-1, poLeft, poLeft + inLeftSize-1);
        root.right = buildMyTree(inorder, postorder, rootIndex + 1, inRight, poLeft + inLeftSize, poRight - 1);
        return root;
    }
}
// @lc code=end
