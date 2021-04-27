import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int num = 1;
        int flag=0;
        while (queue.size() > 0) {
            List<Integer> nums = new ArrayList<>();
            for (int i = 1; i <= num; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                nums.add(queue.poll().val);
            }
            if(flag%2==0){
                res.add(nums);
            }else{
                res.add(reverse(nums));
            }
            num = queue.size();
            flag++;
        }
        return res;
    }

    public static List<Integer> reverse(List<Integer> list) {
        List<Integer> res = new ArrayList<>(list.size());
        for(int i=list.size()-1;i>=0;i--){
            res.add(list.get(i));
        }
        return res;
    }
}
// @lc code=end
