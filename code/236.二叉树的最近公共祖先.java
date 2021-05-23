import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
    Map<Integer,TreeNode> ancestorMap=new HashMap<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        getAcestorMap(root);
        Set<Integer> pSet=new HashSet<>();
        while(p!=null){
            pSet.add(p.val);
            TreeNode node=ancestorMap.get(p.val);
            p=node;
        }
        while(true){
            if(pSet.contains(q.val)){
                return q;
            }else{
                q=ancestorMap.get(q.val);
            }
        }
    }

    public void getAcestorMap(TreeNode root) {
        if (root == null) {
            return;
        }
        if(root.left!=null){
            ancestorMap.put(root.left.val,root);
            getAcestorMap(root.left);
        }
        if(root.right!=null){
            ancestorMap.put(root.right.val,root);
            getAcestorMap(root.right);
        }
    }

}
// @lc code=end
