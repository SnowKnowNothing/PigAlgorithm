import java.util.*;
/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> orderNum = new ArrayList<>();
        if (matrix.length == 1 && matrix[0].length == 1) {
            orderNum.add(matrix[0][0]);
        }
        getOrderNum(matrix, orderNum, 0, matrix.length - 1, matrix[0].length - 1);
        return orderNum;
    }

    public static void getOrderNum(int[][] matrix, List<Integer> res, int begin, int rows, int cols) {
        if (rows == 0 && cols == 0) {
            return;
        }
        if (rows < begin || cols < begin) {
            return;
        }
        if (begin == rows && begin == cols) {
            res.add(matrix[rows][cols]);
            return;
        }
        for (int i = begin; i < cols; i++) {
            res.add(matrix[begin][i]);
        }
        for (int i = begin; i < rows; i++) {
            res.add(matrix[i][cols]);
        }
        for (int i = 0; i < cols - begin; i++) {
            res.add(matrix[rows][cols - i]);
        }
        for (int i = 0; i < rows - begin; i++) {
            res.add(matrix[rows - i][begin]);
        }
        getOrderNum(matrix, res, begin + 1, rows - 1, cols - 1);
    }
}
// @lc code=end
