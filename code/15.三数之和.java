import java.util.*;
/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    if (nums == null || nums.length < 3) {
      return result;
    }
    int head = 0;
    int tail = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      if (nums[i] > 0) {
        return result;
      }
      head = i + 1;
      tail = nums.length - 1;
      while (head < tail) {
        if ((nums[i] + nums[head] + nums[tail]) == 0) {
          List<Integer> ans = new ArrayList<>();
          ans.add(nums[i]);
          ans.add(nums[head]);
          ans.add(nums[tail]);
          result.add(ans);
          while (head < tail && nums[tail] == nums[tail - 1]) {
            tail--;
          }
          while (head < tail && nums[head] == nums[head + 1]) {
            head++;
          }
          tail--;
          head++;
        } else if ((nums[i] + nums[head] + nums[tail]) > 0) {
          tail--;
        } else {
          head++;
        }
      }
    }
    return result;
  }
}
// @lc code=end
