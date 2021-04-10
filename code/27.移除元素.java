
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
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (val != nums[i]) {
                if (nums[cnt] != nums[i]) {
                    nums[cnt] = nums[i];
                }
                cnt++;
            }
        }
        return cnt;
    }
}
// @lc code=end
