package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class LeecodeOthers {

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     */
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        if (s.length() < 1) return true;
        if (!map.containsKey(s.charAt(0)) || !map.containsValue(s.charAt(s.length() - 1))) {
            return false;
        }
        Stack<Character> sc = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                sc.push(s.charAt(i));
            } else if (sc.isEmpty() || map.get(sc.pop()) != s.charAt(i)) {
                //当前字符是后括号 如果栈为空或者和前者不匹配就结束
                return false;
            }
        }
        return sc.isEmpty();
    }
    /**
     * 帕斯卡三角形
     * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行@param numRows
     * 找数值规律 从第[n(n>2)]行 第i（i>1<n-1）个元素=n-1[i-1]+n-1[i]
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> t0 = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    t0.add(1);
                } else {
                    t0.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
                }
            }
            list.add(t0);
        }
        System.out.println(list.toString());
        return list;
    }


    /**
     * 颠倒二进制位
     * 输入: 00000010100101000001111010011100
     * 输出: 00111001011110000010100101000000
     * 解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
     *       因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
     */
    // you need treat n as an unsigned value
    public int reverseBits2(int n) {
        int rev=0;
        int i=32;
        while (i-->0){
            rev<<=1;
            System.out.println(Integer.toBinaryString(rev));
            rev+=n&1;
            System.out.println(Integer.toBinaryString(rev));
            n>>=1;
        }
        return rev;
    }
    /**
     * 颠倒二进制位
     * 输入: 00000010100101000001111010011100
     * 输出: 00111001011110000010100101000000
     * 解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
     *       因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
     */
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int rev=Integer.MIN_VALUE;
        int count=0;
        boolean run=true;
        while (run){
            rev+=(n&1);
            n>>>=1;
            if(n!=0){
                rev<<=1;
                count++;
            }else {
                run=false;
            }
        }
        rev<<=31-count;
        return rev;
//        return Integer.reverse(n);
    }
    /**
     *  汉明距离
     *  两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
     *  给出两个整数 x 和 y，计算它们之间的汉明距离。
     */
    public int hammingDistance(int x, int y) {
        int count=0;
        int n=x^y;
        while (n!=0){
            if((n&1)==1)count++;
            n>>>=1;
        }
        return count;
    }

    /**
     * 位1的个数
     * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
     */
    public int hammingWeight(int n){
        int count=0;
        while (n!=0){
            if((n&1)==1)count++;
            n>>>=1;
        }
        return count;
    }
}
