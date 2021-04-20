import java.util.*;
/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals == null || intervals.length == 0) {
            return res.toArray(new int[0][]);
        }
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        int begin = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (end < intervals[i][0]) {
                res.add(new int[] { begin, end });
                begin = intervals[i][0];
                end = intervals[i][1];
            } else if (end < intervals[i][1]) {
                end = intervals[i][1];
            }
        }
        res.add(new int[] { begin, end });
        return res.toArray(new int[0][]);
    }
}
// @lc code=end
