import java.util.*;
/*
* @lc app=leetcode.cn id=39 lang=java
*
* [39] 组合总和
*/

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            numbers.add(nums[i]);
            findSumList(res, nums, target - nums[i], i, numbers);
            numbers.remove(numbers.size() - 1);
        }
    }
}
// @lc code=end
