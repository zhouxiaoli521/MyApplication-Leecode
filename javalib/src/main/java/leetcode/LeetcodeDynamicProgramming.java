package leetcode;

public class LeetcodeDynamicProgramming {


    /**
     * 打家劫舍
     * [1,1,2,4,1]
     * 2,7,9,3,1
     */
    public int rob(int[] nums) {
        int sum = 0;
        int sum2 = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i-1 != index ) {
                sum = Math.max(nums[i] + sum, nums[i]);
                sum2 = Math.max(sum2, sum);
                index=i;
            }
        }
        int sum0=sum;
        sum=0;
        sum2=0;
        index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (i-1 != index ) {
                sum = Math.max(nums[i] + sum, nums[i]);
                sum2 = Math.max(sum2, sum);
                index=i;
            }
        }
        return sum>sum0?sum:sum0;
    }

    /**
     *  最大子序和
     *  Kadane算法扫描一次整个数列的所有数值，在每一个扫描点计算以该点数值为结束点的子数列的最大和（正数和）。
     *  该子数列由两部分组成：以前一个位置为结束点的最大子数列、该位置的数值。
     *  因为该算法用到了“最佳子结构”（以每个位置为终点的最大子数列都是基于其前一位置的最大子数列计算得出），
     *  该算法可看成动态规划的一个例子。
     *  https://zh.wikipedia.org/wiki/%E6%9C%80%E5%A4%A7%E5%AD%90%E6%95%B0%E5%88%97%E9%97%AE%E9%A2%98
     *   −2, 1, −3, 4, −1, 2, 1, −5, 4
     */
    public int maxSubArray(int[] nums) {
        if(nums.length<1)return 0;
        int max=0;
        int max1=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max+nums[i] , nums[i]);
            max1=Math.max(max,max1);
        }
        return max1;
    }

    /**
     * 买卖股票的最佳时机
     */
    public int maxProfit(int[] prices) {
        int max=0;
        int min=Integer.MAX_VALUE;;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<min){
                min=prices[i];
            }else{
                max = Math.max(prices[i] - min, max);
            }
        }
        return max;
    }


    /**
     * 不难发现，这个问题可以被分解为一些包含最优子结构的子问题，即它的最优解可以从其子问题的最优解来有效地构建，我们可以使用动态规划来解决这一问题。
     * 第 ii 阶可以由以下两种方法得到：
     * 在第 (i-1)(i−1) 阶后向上爬一阶。
     * 在第 (i-2)(i−2) 阶后向上爬 22 阶。
     * 所以到达第 ii 阶的方法总数就是到第 (i-1)(i−1) 阶和第 (i-2)(i−2) 阶的方法数之和。
     * 令 dp[i]dp[i] 表示能到达第 ii 阶的方法总数：
     * dp[i]=dp[i-1]+dp[i-2] dp[i]=dp[i−1]+dp[i−2]
     * @param n 0
     * @return 0
     */
    public int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    /**
     * 在暴力法中，我们将会把所有可能爬的阶数进行组合，也就是 1 和 2 。而在每一步中我们都会继续调用 climbStairsclimbStairs 这个函数模拟爬 11 阶和 22 阶的情形，并返回两个函数的返回值之和。
     * 在上一种方法中，我们计算每一步的结果时出现了冗余。另一种思路是，我们可以把每一步的结果存储在 memomemo 数组之中，每当函数再次被调用，我们就直接从 memomemo 数组返回结果。
     * 在 memomemo 数组的帮助下，我们得到了一个修复的递归树，其大小减少到 nn 。
     * @param n 0
     * @return 0
     */
    public int climbStairs(int n) {
        int memo[] = new int[n + 1];
       return  climb_Stairs(0, n,memo);
    }
    public int climb_Stairs(int i, int n,int []memo) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if(memo[i]>0)
            return memo[i];
        int l1=climb_Stairs(i + 1, n,memo);
        int l2=climb_Stairs(i + 2, n,memo);
        memo[i]=l1+l2;
        System.out.println(l1+" "+l2);
        return memo[i] ;
    }
}
