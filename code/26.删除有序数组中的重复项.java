
/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除有序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int last = 0;
        int finder = 0;
        while (last < nums.length-1) {
            while (nums[last] == nums[finder]) {
                finder++;
                if (finder == nums.length) {
                    return last+1;
                }
            }
            nums[last+1] = nums[finder];
            last++;
        }
        return last+1;
    }
}
// @lc code=end

