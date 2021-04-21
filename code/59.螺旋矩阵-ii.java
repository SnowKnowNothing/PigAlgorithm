import java.util.*;
/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        if (n == 1) {
            return new int[][] { { 1 } };
        }
        if (n == 0) {
            return new int[][] { {} };
        }
        int[][] res = new int[n][n];
        List<Integer> list = new ArrayList<>(n * n);
        for (int i = 0; i < n * n; i++) {
            list.add(i + 1);
        }
        Iterator<Integer> iterator = list.iterator();
        setOrderNum(res, iterator, 0, n - 1);
        return res;
    }

    public static void setOrderNum(int[][] matrix, Iterator<Integer> iterator, int begin, int n) {
        if (n == 0) {
            return;
        }
        if (n < begin) {
            return;
        }
        if (begin == n) {
            matrix[n][n] = iterator.next();
            return;
        }
        for (int i = begin; i < n; i++) {
            matrix[begin][i] = iterator.next();
        }
        for (int i = begin; i < n; i++) {
            matrix[i][n] = iterator.next();
        }
        for (int i = 0; i < n - begin; i++) {
            matrix[n][n - i] = iterator.next();
        }
        for (int i = 0; i < n - begin; i++) {
            matrix[n - i][begin] = iterator.next();
        }
        setOrderNum(matrix, iterator, begin + 1, n - 1);
    }
}
// @lc code=end
