package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class LeecodeDesign {
    /**
     * 最小栈
     */
    class MinStack {
        private int mini = Integer.MAX_VALUE;
        ArrayList stack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new ArrayList();
        }

        public void push(int x) {
            if (mini >= x) {
                stack.add(mini);
                mini = x;
            }
            stack.add(x);
        }

        public void pop() {
            if (stack.isEmpty()) return;
            if ((int) stack.remove(stack.size() - 1) == mini) {
                mini = (int) stack.remove(stack.size() - 1);
            }
        }

        public int top() {
            return (int) stack.get(stack.size() - 1);
        }

        public int getMin() {
            return mini;
        }
    }

    //public class MinStack {
//
//    private int min = Integer.MAX_VALUE;
//    private Stack<Integer> stack;
//    /** initialize your data structure here. */
//    public MinStack() {
//        stack = new Stack<>();
//    }
//
//    public void push(int x) {
//        if(min >= x){
//            stack.push(min);
//            min = x;
//        }
//        stack.push(x);
//    }
//
//    public void pop() {
//        if(stack.pop() == min){
//            min = stack.pop();
//        }
//    }
//
//    public int top() {
//        return stack.peek();
//    }
//
//    public int getMin() {
//        return min;
//    }}
    public class Solution {

        private int nums[];

        public Solution(int[] nums) {
            this.nums = nums;
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            return nums;
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {
            int[] result = Arrays.copyOf(nums, nums.length);
            Random random = new Random();
            for (int i = result.length; i > 1; i--) {
                swap(result, i - 1, random.nextInt(i));
            }
            return result;
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}