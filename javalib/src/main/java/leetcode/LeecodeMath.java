package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeecodeMath {


    /**
     * 罗马数字
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * "LVIII"
     */
    public int romanToInt(String s) {
        int num=0;
        int last=0;
        int result=0;
        for(int i=s.length()-1;i>=0;i--){
            switch (s.charAt(i)){
                case 'I': num=1;break;
                case 'V': num=5;break;
                case 'X': num=10;break;
                case 'L': num=50;break;
                case 'C': num=100;break;
                case 'D': num=500;break;
                case 'M': num=1000;break;
            }
            if(num>=last)
                result+=num;
            else result-=num;
            last=num;
        }
        return result;
    }

    /**
     * 3的幂次方
     * https://www.cnblogs.com/grandyang/p/5138212.html
     */
    public boolean isPowerOfThree(int n) {
//        if (n <= 0) return false;
//        while (n % 3 == 0) {
//            n /= 3;
//        }
//        return n == 1;
        return (n > 0 && (int) (Math.log10(n) / Math.log10(3)) - Math.log10(n) / Math.log10(3) == 0);
    }

    /**
     * n以内质素的个数
     */
    public int countPrimes(int n) {
        if (n < 2) return 0;
        boolean[] nums = new boolean[n];
        nums[0] = nums[1] = true;
        for (int i = 2; i < Math.pow(n, 0.5); i++) {
            if (!nums[i]) {
                for (int j = i * i; j < n; j = j + i) {
                    nums[j] = true;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            count = nums[i] ? count : count + 1;
        }
        return count;
    }

    public List<String> fizzBuzz(int n) {
        ArrayList<String> out = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                out.add("FizzBuzz");
            } else if (i % 5 == 0) {
                out.add("Buzz");
            } else if (i % 3 == 0) {
                out.add("Fizz");
            } else {
                out.add(String.valueOf(i));
            }
        }
        return out;
    }
}
