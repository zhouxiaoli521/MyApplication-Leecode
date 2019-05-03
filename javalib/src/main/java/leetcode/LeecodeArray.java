package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeecodeArray {

    /**
     * 有效的数独
     * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
     * 数字 1-9 在每一行只能出现一次。
     * 数字 1-9 在每一列只能出现一次。
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
     * 数独部分空格内已填入了数字，空白格用 '.' 表示。
     * 输入:
     * [
     *   ["5","3",".",".","7",".",".",".","."],
     *   ["6",".",".","1","9","5",".",".","."],
     *   [".","9","8",".",".",".",".","6","."],
     *   ["8",".",".",".","6",".",".",".","3"],
     *   ["4",".",".","8",".","3",".",".","1"],
     *   ["7",".",".",".","2",".",".",".","6"],
     *   [".","6",".",".",".",".","2","8","."],
     *   [".",".",".","4","1","9",".",".","5"],
     *   [".",".",".",".","8",".",".","7","9"]
     * ]
     * 输出: true
     *
     * 输入:
     * [
     *   ["8","3",".",".","7",".",".",".","."],
     *   ["6",".",".","1","9","5",".",".","."],
     *   [".","9","8",".",".",".",".","6","."],
     *   ["8",".",".",".","6",".",".",".","3"],
     *   ["4",".",".","8",".","3",".",".","1"],
     *   ["7",".",".",".","2",".",".",".","6"],
     *   [".","6",".",".",".",".","2","8","."],
     *   [".",".",".","4","1","9",".",".","5"],
     *   [".",".",".",".","8",".",".","7","9"]
     * ]
     * 输出: false
     * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
     *      但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
     * 说明:
     * 一个有效的数独（部分已被填充）不一定是可解的。
     * 只需要根据以上规则，验证已经填入的数字是否有效即可。
     * 给定数独序列只包含数字 1-9 和字符 '.' 。
     * 给定数独永远是 9x9 形式的。
     * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/30/
     * 把棋盘的行[i]、列[j]、九宫格都记录下来 查找到重复数字就判定无效
     * 查找宫格元素的公式：block[(i/3)*3+j/3][num]
     */
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row=new boolean[9][9];
        boolean[][] clo=new boolean[9][9];
        boolean[][] block=new boolean[9][9];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='.')continue;
                int num=board[i][j]-'0'-1;
                if(row[i][num]||clo[j][num]||block[(i/3)*3+j/3][num]){
                    return false;
                }
                row[i][num]=clo[j][num]=block[(i/3)*3+j/3][num]=true;
            }
        }
        return true;
    }

    /**
     * 两数之和
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/29/
     * 把数组保存在map里 用target减去当前珍整数i 查找结果是否在map中 如果在就返回 如果不在就保存到map里
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            int result=target-nums[i];
            if(map.containsKey(result)){
                return new int[]{map.get(result),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
    /**
     * 零移动
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     *
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     * https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/1/array/28/
     *
     * 双指针 i表示0元素 j表示非零元素 但i==0 && j!=0时交换两个数 并更新位置
     *
     * 另一种算法是 判断j!=0就和前一个元素交换 然后记录交换次数 最后在用一个for循环把最后几位赋值为0
     */
    public void moveZeroes(int[] nums) {
        for(int i=0,j=1;j<nums.length;j++){
            if(nums[i]!=0){
                i++;
                continue;
            }
            if(nums[j]==0){
                continue;
            }
            nums[i]=nums[j];
            nums[j]=0;
            i++;
        }
    }

    /**
     * 加一
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     * 输入: [1,2,3]
     * 输出: [1,2,4]
     * 解释: 输入数组表示数字 123。
     *
     * 输入: [4,3,2,1]
     * 输出: [4,3,2,2]
     * 解释: 输入数组表示数字 4321。
     * https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/1/array/27/
     */
    public int[] plusOne(int[] digits) {
        int[] nums=new int[digits.length+1];
        nums[digits.length]=1;
        for(int i=digits.length-1;i>=0;i--){
            nums[i+1]+=digits[i];
            if(nums[i+1]==10){
                nums[i+1]=0;
                nums[i]+=1;
            }
        }
        if(nums[0]==0){
            return Arrays.copyOfRange(nums,1,nums.length);
        }
        return nums;
    }
    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出: [2,2]
     * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出: [4,9]
     * 说明：
     * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
     * https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/1/array/26/
     *
     * 先排序 然后按顺序比较两个数组 如果相等就保存 不相等就让数值小的数组游标++
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0,j=0,index=0;
        //用哪个数组的长度都可以 后面会用index来指明需要拷贝的长度
        int [] array=new int[nums2.length];
        while (i<nums1.length && j<nums2.length){
            if(nums1[i]==nums2[j]){
                array[index++]=nums1[i];
                i++;j++;
            }else if(nums1[i]>nums2[j]){
                j++;
            }else {
                i++;
            }
        }
        return Arrays.copyOf(array,index);
    }
    /**
     * 只出现一次的数字
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/25/
     * 异或
     */
    public int singleNumber(int[] nums) {
        for(int i=1;i<nums.length;i++){
            nums[0]^=nums[i];
        }
        return nums[0];
    }
    /**
     * 存在重复
     *给定一个整数数组，判断是否存在重复元素。
     *如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
     * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/24/
     * set
     */
    public boolean containsDuplicate2(int[] nums) {
        if (nums.length < 2) return false;
        Set<Integer> set = new HashSet<Integer>();
        for (int i : nums) {
            set.add(i);
        }
        return !(set.size() == nums.length);
    }
    /**
     * 存在重复
     *给定一个整数数组，判断是否存在重复元素。
     *如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
     * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/24/
     */
    public boolean containsDuplicate(int[] nums) {
        if(nums.length<2)return false;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j])return true;
            }
        }
        return false;
    }

    /**
     *旋转数组
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/23/
     * 数组拷贝
     * 　Object src : 原数组
     *   int srcPos : 从元数据的起始位置开始
     * 　Object dest : 目标数组
     * 　int destPos : 目标数组的开始起始位置
     * 　int length  : 要copy的数组的长度
     *   byte[]  srcBytes = new byte[]{2,4,0,0,0,0,0,10,15,50};  // 源数组
     *   byte[] destBytes = new byte[5]; // 目标数组
     */
    public void rotate2(int[] nums, int k) {
        if(nums.length<1||k==0)return ;
        int[] newnums=nums.clone();
        System.arraycopy(newnums,0,nums,k,nums.length-k);
        System.arraycopy(newnums,nums.length-k,nums,0,k);
    }
    /**
     *旋转数组
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/23/
     * 开始通过(j+k)%nums.length找到它移动后的位置，然后赋值并且记录当前位置，下一次循环再计算下一个位置
     * 变量t保存这下次需要使用的值
     */
    public void rotate(int[] nums, int k) {
        if(nums.length<1||k==0)return ;
        int t=nums[0];
        int start=0;
        for(int i=0,j=0;i<nums.length;i++){
            j=(j+k)%nums.length;
            int t2=nums[j];
            nums[j]=t;
            t=t2;
            if(j==start&&start<nums.length-1){
                t=nums[++start];
                j=start;
            }
        }
    }

    /**
     * 买卖股票的最佳时机 II
     * 输入: [7,1,5,3,6,4]
     * 输出: 7
     * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/22/
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0, j = 1; j < prices.length; j++) {
            if (prices[j] > prices[i]) {
                max += prices[j] - prices[i];
            }
            i++;
        }
        return max;
    }

    /**
     * 从排序数组中删除重复项
     * [0,0,1,1,1,2,2,3,3,4]
     * 快慢指针 比较不同就交换并且i,j指针后移 相同只有j指针向后移动
     * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/21/
     */
    int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
