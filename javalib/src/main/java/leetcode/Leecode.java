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

//        int nums[] = new int[]{0,0,1,1,1,2,2,3,3,4};
//        int nums[] = new int[]{1, 1, 2};
//        removeDuplicates(nums);

//        int nums[] = new int[]{0,1,3,6,4,7};
//        int nums2[] = new int[]{7,6,3,4,5};
//        int nums3[] = new int[]{7,1,5,3,6,4};
//        maxProfit2(nums);
//        maxProfit2(nums2);
//        maxProfit2(nums3);

//        int nums3[] = new int[]{7,1,5,3,6,4};
//        rotate(nums,4);
//        rotate2(nums,4);

//        int nums[] = new int[]{3,1,1,5,3,6};
//        System.out.println(containsDuplicate(nums));
//        System.out.println(containsDuplicate2(nums));

//        int nums[] = new int[]{3,1,1,5,3,5,6,8,8};
//        System.out.println(singleNumber2(nums));
//        int nums1[] = new int[]{3,1,1,7,5};
//        int nums2[] = new int[]{3,22,44,66,1,1,5,3,5,6};
//        int nums1[] = new int[]{1,2,2,1};
//        int nums2[] = new int[]{1,2};
//        intersect(nums1,nums2);

//        int nums1[] = new int[]{9,9,9};
//        System.out.println(Arrays.toString(plusOne(nums1)));

//        int nums[] = new int[]{1,1,0,3,12};
//        moveZeroes2(nums);

//        int nums[]=new int[]{2,5,1,7};
//        System.out.println(Arrays.toString(twoSum(nums,9)));

//        int nums[][]=new int[][]{{11,12,13,14},{15,16,17,18},{19,20,21,22},{23,24,25,26}};
//        rotate(nums);
//        char board[][]=new char[][]{
//  {'5','3','.','.','7','.','.','.','.'},
//  {'6','.','.','1','9','5','.','.','.'},
//  {'.','9','8','.','.','.','.','6','.'},
//  {'8','.','.','.','6','.','.','.','3'},
//  {'4','.','.','8','.','3','.','.','1'},
//  {'7','.','.','.','2','.','.','.','6'},
//  {'.','6','.','.','.','.','2','8','.'},
//  {'.','.','.','4','1','9','.','.','5'},
//  {'.','.','.','.','8','.','.','7','9'}
//        };
//        System.out.println(isValidSudoku(board));
//
//        char nums[]=new char[]{'h','e','l','l','o'};
//        reverseString(nums);
//        System.out.println(reverse2(159));

//        String s="";
//        System.out.println(firstUniqChar3(s));

//        String s = "ac";
//        String t = "bb";
//        System.out.println(isAnagram(s, t));

//        String t = " m, a , a ca: am";
//        String t = "0p";
//        System.out.println(isPalindrome(t));

//        String str="0000000042";
//        String str="4193 with words";
//        String str="words and 987";
//        System.out.println(myAtoi2(str));
//        String haystack = "aaaaa", needle = "bba";
//        String haystack = "BBC ABCDAB ABCDABCDABDE", needle = "ABCDABD";
//        System.out.println(strStr2(haystack, needle));
//        System.out.println(strStr3(haystack, needle));


//        System.out.println(countAndSay(5));

//        String strs[]=new String[]{"flower","flow","flight"};
        String strs[]=new String[]{"c","c","b"};
        System.out.println(longestCommonPrefix(strs));

    }

    /**
     * 最长公共前缀
     * @param strs
     * @return
     */
    static public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)
            return "";
        if(strs.length==1)
            return strs[0];
        int min=strs[0].length();
        for(int i=1;i<strs.length;i++){
          if(min>strs[i].length())
              min=strs[i].length();
        }
        if(min==0)
            return "";
        for(int i=0;i<min;i++){
            char c=strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
                if(c!=strs[j].charAt(i)){
                    if(i==0)
                        return "";
                    return strs[0].substring(0,i);
                }
                if(i==min-1&&j==strs.length-1)
                    return strs[0].substring(0,i+1);
            }
        }
        return "";
    }

    /**
     * 报数 需要优化
     * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/39/
     * @param n
     * @return
     */
    static public String countAndSay(int n) {
        if (n > 30 || n < 1)
            return "";
        StringBuffer sb = new StringBuffer();
        StringBuffer tsb = new StringBuffer();
        sb.append(1);
        for (int i = 1; i < n; i++) {
            char c = sb.charAt(0);
            int len = sb.length();
            for (int j = 0, k = 0; j < len; j++) {
                if (c == sb.charAt(j)) {
                    k++;
                    if (j == len - 1) {
                        tsb.append(k).append(c);
                        sb.setLength(0);
                        sb.append(tsb);
                        tsb.setLength(0);
                        continue;
                    }
                } else {
                    tsb.append(k).append(c);
                    k = 1;
                    if (j + 1 == len) {
                        tsb.append(k).append(sb.charAt(j));
                        sb.setLength(0);
                        sb.append(tsb);
                        tsb.setLength(0);
                        continue;
                    }
                    c = sb.charAt(j);
                }
            }
        }
        return sb.toString();
    }

    /**
     * 实现strStr() 暴力算法
     *
     * @param haystack
     * @param needle
     * @return
     */
    static public int strStr3(String haystack, String needle) {
        int t = 0;
        try {
            for (int i = 0; i <= haystack.length() - needle.length(); i++) {
                for (int j = 0; j < needle.length(); j++) {
                    t++;
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        break;
                    }
                    if (j == needle.length() - 1)
                        return i;
                }
            }
        } catch (Exception e) {
        } finally {
            System.out.println("@" + t);
        }
        return -1;
    }

    static public int[] next(String needle) {
        int next[] = new int[needle.length()];
        next[0] = -1;
        int i = 0, j = -1;
        for (; i < needle.length() - 1; ) {
            if (j == -1 || needle.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }

    /**
     * 实现strStr() KMP
     *
     * @param haystack
     * @param needle
     * @return
     */
    static public int strStr2(String haystack, String needle) {
        if(needle.length()==0)
            return 0;
//        int t = 0;
        int next[] = next(needle);
//        try {
        for (int i = 0, j = 0; i < haystack.length(); ) {
//                t++;
//                if (j == -1) {
//                    i++;
//                    j++;
//                    continue;
//                }
//                char h = haystack.charAt(i);
//                char n = needle.charAt(j);
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
            if (j == needle.length())
                return i - j;
        }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            System.out.println("@" + t);
//        }
        return -1;
    }

    /**
     * 实现strStr()
     *
     * @param haystack
     * @param needle
     * @return
     */
    static public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        if (needle.length() == haystack.length())
            return haystack.equals(needle) ? 0 : -1;
        int nLen = needle.length();
        for (int i = 0; i <= haystack.length() - nLen; i++) {
            String temp = haystack.substring(i, i + nLen);
            if (needle.equals(temp))
                return i;
        }
        return -1;
    }

    /**
     * 字符串转换整数 (atoi)
     *
     * @param str
     * @return
     */
    static public int myAtoi2(String str) {
        if (str.length() == 0)
            return 0;
        int start = 0;
        //过滤空格
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) != ' ') {
                start = i;
                break;
            }
        //判断正负
        boolean isMinus = false;
        if (str.charAt(start) == '-') {
            isMinus = true;
            start++;
        } else if (str.charAt(start) == '+') {
            start++;
        }
        //判断是否溢出
        int rev = 0;
        for (int i = start; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9')
                break;
            if (isMinus) {
                if (-rev < Integer.MIN_VALUE / 10 || -rev == Integer.MIN_VALUE / 10 && -(str.charAt(i) - '0') < -8)
                    return isMinus ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            } else if (rev > Integer.MAX_VALUE / 10 || rev == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)
                return isMinus ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            rev = rev * 10 + (str.charAt(i) - '0');
        }
        return isMinus ? -rev : rev;
    }

    /**
     * 字符串转换整数 (atoi)
     *
     * @param str
     * @return
     */
    static public int myAtoi(String str) {
        if (str.length() == 0)
            return 0;
        boolean isMinus = false;
        boolean isStart = false;
        int atoi[] = new int[str.length()];
        int atoiLen = 0;
        for (int i = 0; i < str.length(); i++) {
            //循环刚刚开始（还没有遇到有效数字）
            if (!isStart) {
                if (str.charAt(i) == ' ')
                    continue;
                if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                    if (str.charAt(i) == '+') {
                        isStart = true;
                        continue;
                    }
                    if (str.charAt(i) != '-') {
                        return 0;
                    }
                    isMinus = true;
                    isStart = true;
                    continue;
                }
            }
            //无效字符 结束有效数字查找
            if (str.charAt(i) < '0' || str.charAt(i) > '9')
                break;
            if (str.charAt(i) != '0' || atoiLen != 0) {
                atoi[atoiLen] = str.charAt(i) - '0';
                atoiLen++;
            }
            isStart = true;
        }
        if (atoiLen == 0)
            return 0;
        if (atoiLen == 1)
            return isMinus ? atoi[0] * -1 : atoi[0];
        //2147483647
        if (atoiLen > 10)
            return isMinus ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        int rev = 0;
        for (int i = 0; i < atoiLen; i++) {
            if (rev > Integer.MAX_VALUE / 10 || rev == Integer.MAX_VALUE / 10 && atoi[i] > 7)
                return isMinus ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            rev = rev * 10 + atoi[i];
        }
        return isMinus ? rev * -1 : rev;
    }

    /**
     * 验证回文字符串
     *
     * @param s
     * @return
     */
    static public boolean isPalindrome(String s) {
        char cs[] = new char[s.length()];
        int clen = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                cs[clen++] = (char) (c + ' ');
                continue;
            }
            if (c >= 'a' && c <= 'z' || c >= '0' && c <= '9') {
                cs[clen++] = c;
                continue;
            }
        }
        for (int i = 0, j = clen - 1; i < clen / 2; i++, j--) {
            if (cs[i] != cs[j])
                return false;
        }
        return true;
    }

    /**
     * 什么是异位词
     * 两个单词如果包含相同的字母，次序不同，则称为字母易位词(anagram)
     * 异位词特点
     * 字符数相同/顺序不同/出现字符相同
     *
     * @param s
     * @param t
     * @return
     */
    static public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 97]++;
            hash[t.charAt(i) - 97]--;
        }
        for (int i = 0; i < s.length(); i++) {
            if (hash[s.charAt(i) - 97] != 0)
                return false;
        }
        return true;
    }

    /**
     * 字符串中的第一个唯一字符
     *
     * @param s
     * @return
     */
    static public int firstUniqChar3(String s) {
        int len = s.length();
        int j = -1;
        if (len > 26) {
            for (char c = 'a'; c <= 'z'; c++) {
                int index = s.indexOf(c);
                if (index != -1 && index == s.lastIndexOf(c)) {
                    j = j == -1 ? index : j < index ? j : index;
                }
            }
        } else {
            for (int i = 0; i < s.length(); i++) {
                int index = s.indexOf(s.charAt(i));
                if (index == s.lastIndexOf(s.charAt(i)))
                    return index;
            }
        }
        return j;
    }

    /**
     * 字符串中的第一个唯一字符
     *
     * @param s
     * @return
     */
    static public int firstUniqChar2(String s) {
        if (s.length() <= 1)
            return s.length() - 1;
        int map[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 97] += 1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i) - 97] == 1)
                return i;
        }
        return -1;
    }

    /**
     * 字符串中的第一个唯一字符
     *
     * @param s
     * @return
     */
    static public int firstUniqChar(String s) {
        if (s.length() <= 1)
            return s.length() - 1;
        HashMap map = new HashMap();
        char c[] = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            map.put(c[i], i);
        }
        if (map.size() == 1) {
            return -1;
        }
        for (int i = 0; i < c.length; i++) {
            if ((int) map.get(c[i]) != i) {
                map.put(c[i], i);
            } else {
                return i;
            }
        }
        return -1;
    }


    /**
     * 整数反转
     * 2147483647
     *
     * @param x
     * @return
     */
    static public int reverse2(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    /**
     * 整数反转
     *
     * @param x
     * @return
     */
    static public int reverse(int x) {
        if (x < 10 && x > -10)
            return x;
        char s[] = String.valueOf(x > 0 ? x : x * -1).toCharArray();
        int len = s.length / 2;
        char temp = s[0];
        for (int i = 0, j = s.length - 1; i < len; i++, j--) {
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
        int y = 0;
        try {
            y = Integer.valueOf(new String(s));
        } catch (Exception e) {
            return 0;
        }
        return x > 0 ? y : y * -1;
    }

    /**
     * 反转字符串
     *
     * @param s
     */
    static public void reverseString(char[] s) {
        int len = s.length / 2;
        char temp = s[0];
        for (int i = 0, j = s.length - 1; i < len; i++, j--) {
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
        System.out.println(Arrays.toString(s));
    }

    /**
     * 有效的数独
     *
     * @param board
     * @return
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
     * 两数之和
     *
     * @param nums
     * @param target
     * @return
     */
    static public int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (result == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 两数之和 hashmap
     *
     * @param nums
     * @param target
     * @return
     */
    static public int[] twoSum(int[] nums, int target) {
//        for(int i=0;i<nums.length;i++){
//            map.put(nums[i],i);
//        }
        Map map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            if (map.containsKey(result) && (int) map.get(result) != i) {
                return new int[]{(int) map.get(result), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    /**
     * [1,1,0,3,12]
     *
     * @param nums 双指针
     */
    static public void moveZeroes2(int[] nums) {
        int swap = 0;
        for (int i = 0, j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                i++;
                swap++;
            }
        }
        for (int i = swap; i < nums.length; i++)
            nums[i] = 0;
        System.out.println(Arrays.toString(nums));
    }

    /**
     * [0,1,0,3,12]
     *
     * @param nums 双指针
     */
    static public void moveZeroes(int[] nums) {
        for (int i = 0, j = 1; j < nums.length; j++) {
            if (nums[i] != 0) {
                j = ++i;
                continue;
            }
            if (nums[j] == 0) {
                continue;
            }
            swap(nums, i, j);
            i++;
        }
        System.out.println(Arrays.toString(nums));
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
     * 异或
     *
     * @param nums
     * @return
     */
    static public int singleNumber2(int[] nums) {
        for (int i = 1; i < nums.length; i += 2) {
            nums[0] ^= nums[i] ^ nums[i + 1];
        }
        return nums[0];
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
     * 存在重复 双重循环
     */
    static public boolean containsDuplicate(int[] nums) {
        if (nums.length < 2) return false;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }

            }
        }
        return false;
    }

    /**
     * 存在重复 ste
     */
    static public boolean containsDuplicate2(int[] nums) {
        if (nums.length < 2) return false;
        Set set = new HashSet();
        for (int i : nums)
            set.add(i);
        return set.size() != nums.length ? true : false;
    }

    //旋转数组
    static public void rotate2(int[] nums, int k) {
        k = k % nums.length;
        int[] tmp = nums.clone();
        System.arraycopy(tmp, tmp.length - k, nums, 0, k);
        System.arraycopy(tmp, 0, nums, k, tmp.length - k);
        System.out.println(Arrays.toString(nums));
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

    /**
     * 买卖股票的最佳时机 II
     * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/22/
     */
    static public int maxProfit2(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        System.out.println(profit);
        return profit;
    }

    /**
     * 从排序数组中删除重复项 双指针
     * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/21/
     */
    static public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(i + 1);
        return i + 1;
    }

}
