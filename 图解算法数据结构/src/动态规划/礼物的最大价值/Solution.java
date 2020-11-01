package 动态规划.礼物的最大价值;

public class Solution {
    /**
     * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
     * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
     * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入:
     * [
     *   [1,3,1],
     *   [1,5,1],
     *   [4,2,1]
     * ]
     * 输出: 12
     * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
     */
    public int maxValue(int[][] grid) {
        int line = grid.length;
        int row = grid[0].length;
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < row; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    // 第一行 grid[i][j] += grid[i][j - 1];
                    grid[i][j] += grid[i][j - 1];
                    continue;
                }
                if (j == 0) {
                    grid[i][j] += grid[i - 1][j];
                    continue;
                }
                // 非第一行
                grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
            }

        }
        return grid[line - 1][row - 1];
    }

    public static void main(String[] args) {
        int grid[][] = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        new Solution().maxValue(grid);
    }
}
