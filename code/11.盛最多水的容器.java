/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int max=0;
        int begin=0;
        int width=0;
        int high=0;
        int tmp=0;
        int end=height.length-1;
        while(begin<end){
            width=end-begin;
            if(height[begin]<height[end]){
                high=height[begin];
                begin++;
            }else{
                high=height[end];
                end--;
            }
            tmp=high*width;
            if(max<tmp){
                max=tmp;
            }
        }
        return max;
    }
}
// @lc code=end

