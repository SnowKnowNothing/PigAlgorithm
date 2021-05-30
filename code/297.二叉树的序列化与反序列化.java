import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=297 lang=java
 *
 * [297] 二叉树的序列化与反序列化
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder ans=new StringBuilder();
        getSerialize(root,ans);
        return ans.toString();
    }

    private void getSerialize(TreeNode root, StringBuilder ans) {
        if(root==null){
            ans.append("null,");
            return;
        }
        ans.append(String.valueOf(root.val)+",");
        getSerialize(root.left, ans);
        getSerialize(root.right, ans);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strTree=data.split(",");
        List<String> values=new LinkedList<String>(Arrays.asList(strTree));
        return getTree(values);
        
    }

    private TreeNode getTree(List<String> values) {
        if(values.get(0).equalsIgnoreCase("null")){
            values.remove(0);
            return null;
        }
        TreeNode root=new TreeNode(Integer.valueOf(values.get(0)));
        values.remove(0);
        root.left=getTree(values);
        root.right=getTree(values);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end

