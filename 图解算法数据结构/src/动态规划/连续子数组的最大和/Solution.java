package 动态规划.连续子数组的最大和;

/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * <p>
 * 要求时间复杂度为O(n)。
 * <p>
 *  
 * <p>
 * 示例1:
 * <p>
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 * 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/
 */
public class Solution {

    public int maxSubArray(int[] nums) {
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        // if(DP[i-1]>0) DP[i] = DP[i-1] +nums[i]
        // if(DP[i-1]<=0) DP[i] = nums[i]
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i-1]>0){
                dp[i] = dp[i-1]+nums[i];
            }else{
                dp[i] = nums[i];
            }

            if (dp[i]>max){
                max = dp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
