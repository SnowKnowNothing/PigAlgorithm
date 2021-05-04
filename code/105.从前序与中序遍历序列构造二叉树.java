import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    private static Map<Integer,Integer> hashmap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=inorder.length;
        hashmap=new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++){
            hashmap.put(inorder[i],i);
        }
        return buildMyTree(preorder,inorder,0,n-1,0,n-1);
    }
    public static TreeNode buildMyTree(int[] preorder,int[] inorder,int preleft,int preright,int inleft,int inright){
        if(preleft>preright){
            return null;
        }
        TreeNode root= new TreeNode(preorder[preleft]);
        int index=hashmap.get(preorder[preleft]);
        int leftsize=index-inleft;
        root.left=buildMyTree(preorder, inorder, preleft+1, preleft+leftsize, inleft, index-1);
        root.right=buildMyTree(preorder, inorder, preleft+leftsize+1, preright, index+1, inright);
        return root;
    }
}
// @lc code=end

