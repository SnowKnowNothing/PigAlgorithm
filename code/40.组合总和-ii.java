import java.util.*;
/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        int index = 0;
        findSumList(res, candidates, target, index, new ArrayList<Integer>());
        return res;

    }

    public static void findSumList(List<List<Integer>> res, int[] nums, int target, int index, List<Integer> numbers) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(numbers));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            numbers.add(nums[i]);
            findSumList(res, nums, target - nums[i], i+1, numbers);
            numbers.remove(numbers.size() - 1);
        }
    }
}
// @lc code=end
