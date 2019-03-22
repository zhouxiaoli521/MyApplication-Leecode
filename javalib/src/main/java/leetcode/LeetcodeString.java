package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class LeetcodeString {

    public static void main(String args[]){
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
//        String strs[]=new String[]{"c","c","b"};
//        System.out.println(longestCommonPrefix(strs));
    }
    /**
     * 最长公共前缀
     *
     * @param strs
     * @return
     */
    static public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        int min = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if (min > strs[i].length())
                min = strs[i].length();
        }
        if (min == 0)
            return "";
        for (int i = 0; i < min; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (c != strs[j].charAt(i)) {
                    if (i == 0)
                        return "";
                    return strs[0].substring(0, i);
                }
                if (i == min - 1 && j == strs.length - 1)
                    return strs[0].substring(0, i + 1);
            }
        }
        return "";
    }

    /**
     * 报数 需要优化
     * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/39/
     *
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
        if (needle.length() == 0)
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
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
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
}
