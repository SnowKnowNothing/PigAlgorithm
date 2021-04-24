/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 */

// @lc code=start
class Solution {
    public int numTrees(int n) {
        if(n==1){
            return 1;
        }
        return getNumTrees(1,n);
    }
    public static int getNumTrees(int left,int right){
        int sum=0;
        if(left>right){
            return sum;
        }
        if(left==right){
            return 1;
        }
        if(right-left==1){
            return 2;
        }
        if(right-left==2){
            return 5;
        }
        for(int i=left;i<=right;i++){
            int leftNum=getNumTrees(left, i-1);
            int rightNum=getNumTrees(i+1, right);
            if(leftNum!=0 && rightNum!=0){
                sum=sum+leftNum*rightNum;
            }else if(leftNum==0 && rightNum!=0){
                sum=sum+rightNum;
            }else if(leftNum!=0 && rightNum==0){
                sum=sum+leftNum;
            }
        }
        return sum;
    }
}
// @lc code=end

