package leetCode.dailyQuestion.IsValidSudoku;


/**
 * 有效的数独
 *
 * 请你判断一个9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 *
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用'.'表示。
 *
 * 注意：
 *
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-sudoku
 */
public class Solution {

    /**
     * 用二维数组row[i][index]来记录第i行index+1出现的次数
     * 用二位数组col[j][index]来记录第j列index+1出现的次数
     * 用三维数组matrix[i/3][j/3][index]来记录第i/3个方阵里index+1出现的次数
     */
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][][] matrix = new int[9][9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int index = c - '0' - 1;
                    row[i][index] ++;
                    col[j][index] ++;
                    matrix[i/3][j/3][index] ++;
                    if (row[i][index] > 1 || col[j][index] > 1 || matrix[i/3][j/3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
