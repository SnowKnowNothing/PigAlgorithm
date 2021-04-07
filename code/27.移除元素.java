import java.util.*;
/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 */

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int last = 0;
        int finder = 0;
        while (last < nums.length - 1) {
            while (nums[last] == nums[finder]) {
                finder++;
                if (finder == nums.length) {
                    return last;
                }
            }
            nums[last] = nums[finder];
            last++;
        }
        return last;
    }
}
// @lc code=end
