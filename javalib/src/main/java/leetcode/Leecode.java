package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Leecode {

    static private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {


//        int nums[][]=new int[][]{{11,12,13,14},{15,16,17,18},{19,20,21,22},{23,24,25,26}};
//        rotate(nums);
    }

    /**
     * 有效的数独
     *
     */
    static public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] clo = new boolean[9][9];
        boolean[][] block = new boolean[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0' - 1;
                    if (row[i][num] || clo[j][num] || block[(i / 3) * 3 + j / 3][num]) {
                        return false;
                    }
                    row[i][num] = true;
                    clo[j][num] = true;
                    block[(i / 3) * 3 + j / 3][num] = true;
                }
            }
        }
        return true;
    }

    /**
     * 旋转图像 一次交换四个数据
     *
     * @param matrix
     */
    static public void rotate(int[][] matrix) {
        int tmp = 0;
        int len = matrix.length - 1;
        int end = 0;
        for (int i = 0; i < len - i; i++) {
            for (int j = i; j < len - i; j++) {
                System.out.println(j);
                tmp = matrix[i][j];
                end = len - j;
                matrix[i][j] = matrix[end][i];
                matrix[end][i] = matrix[len - i][end];
                matrix[len - i][end] = matrix[j][len - i];
                matrix[j][len - i] = tmp;
                int lt = matrix[i][j];
                int lb = matrix[end][i];
                int rb = matrix[len - i][end];
                int rt = matrix[j][len - i];
                System.out.print("");
            }
        }

        for (int i = 0; i <= len; i++) {
            System.out.println();
            for (int j = 0; j <= len; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
    }



    /**
     * 加一
     *
     * @param digits
     * @return
     */
    static public int[] plusOne(int[] digits) {
        digits[digits.length - 1] += 1;
        if (digits[digits.length - 1] < 10) {
            return digits;
        }

        digits[digits.length - 1] = 0;
        for (int i = digits.length - 2; i >= 0; i--) {
            digits[i] += 1;
            if (digits[i] > 9) {
                digits[i] = 0;
            } else {
                return digits;
            }
        }

        int[] temp = new int[digits.length + 1];
        temp[0] = 1;
        return temp;
    }

    /**
     * 两个数组的交集 II
     * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出: [2,2]
     * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出: [4,9]
     */
    static public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<Integer>();
        //交换次数
        int k = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = k; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    list.add(nums1[i]);
                    if (i != j) {
                        swap(nums2, k, j);
                        k++;
                    }
                    break;
                }
            }
            if (list.size() == nums1.length || list.size() == nums2.length)
                break;
        }
        int a[] = new int[list.size()];
        int i = 0;
        for (int t : list)
            a[i++] = t;
        System.out.print(list);
        return a;
    }


    /**
     * 唯一的数
     *
     * @param nums
     * @return
     */

    static public int singleNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    //判断重复数字是否相邻 如果不相邻交换数字 如果相邻直接下一次循环
                    int ti = ++i;
                    if (i != j) {
                        int tmp = nums[j];
                        nums[j] = nums[ti];
                        nums[ti] = tmp;
                    }
                    break;
                }
                if (j == nums.length - 1) {
                    return nums[i];
                }
            }
        }
        return nums[nums.length - 1];
    }




    /**
     * 旋转数组
     * 原理：从第0个数开始，找到他要跳转的地方 先保存这个数据到临时变量 然后把当前值赋值过去 并且更新游标 下次从新的游标开始找跳转的地方
     * 然后判断当前游标是否回到了初始的地方（index == start） 表示当前已经处理了一遍 第二遍要从第二个数开始
     * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/23/
     */
    static public void rotate(int[] nums, int k) {
        //len-k+i
        if (nums == null || k % nums.length == 0) return;
        int temp = nums[0];
        int start = 0;
        int cur = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            index = (cur + k) % nums.length;
            int ttmp = nums[index];
            nums[index] = temp;
            if (index == start) {
                start++;
                index++;
                temp = nums[index];
            } else {
                temp = ttmp;
            }
            cur = index;
        }
        System.out.println(Arrays.toString(nums));
    }

}
