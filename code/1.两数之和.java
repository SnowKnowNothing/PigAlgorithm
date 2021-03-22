/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            Integer sub=target-nums[i];
            Integer index=map.get(sub);
            if(index!=null){
                return new int[]{i,index};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
// @lc code=end

