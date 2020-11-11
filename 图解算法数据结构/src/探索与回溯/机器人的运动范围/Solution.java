package 探索与回溯.机器人的运动范围;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * 机器人的运动范围
     * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：m = 2, n = 3, k = 1
     * 输出：3
     * 示例 2：
     * <p>
     * 输入：m = 3, n = 1, k = 0
     * 输出：1
     * 提示：
     * <p>
     * 1 <= n,m <= 100
     * 0 <= k <= 20
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    Set<String> sites = new HashSet<>();

    public int movingCount(int m, int n, int k) {
        bfs(m, n, k, 0, 0);
        // 统计set的个数
        return sites.size();
    }

    private boolean bfs(int m, int n, int k, int x, int y) {
        if (sites.contains(x + "," + y)) {
            return false;
        }

        // 判断是否越界
        if (x < 0 || x > m - 1 || y < 0 || y > n - 1) {
            return false;
        }
        // 判断行坐标和列坐标的数位之和大于k
        if (judgeK(x, y, k)) {
            return false;
        }
        // 添加到set中
        sites.add(x + "," + y);
        // 广度优先
        bfs(m, n, k, x, y + 1);
        bfs(m, n, k, x, y - 1);
        bfs(m, n, k, x - 1, y);
        bfs(m, n, k, x + 1, y);
        return true;
    }

    /**
     * 当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19
     *
     */
    private boolean judgeK(int x, int y, int k) {
        String[] splitM = String.valueOf(x).split("");
        String[] splitN = String.valueOf(y).split("");
        int count = 0;
        for (String index : splitM) {
            count += Integer.valueOf(index);
        }
        for (String index : splitN) {
            count += Integer.valueOf(index);
        }
        return count > k ? true : false;
    }

}
