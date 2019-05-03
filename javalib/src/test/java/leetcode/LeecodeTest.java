package leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LeecodeTest {
    //============================================LeecodeArray======================================================/

    /**
     * 有效的数独
     */
    @Test
    public void isValidSudokuTest() {
        LeecodeArray la = new LeecodeArray();
        char board[][] = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        assertTrue(la.isValidSudoku(board));
        board[0][0]='8';
        assertFalse(la.isValidSudoku(board));
    }
    /**
     * 两数之和
     */
    @Test
    public void twoSumTest() {
        LeecodeArray la = new LeecodeArray();
        assertArrayEquals(new int[]{0,1}, la.twoSum(new int[]{2, 7, 11, 15},9));
    }

    /**
     * 零移动
     */
    @Test
    public void moveZeroesTest() {
        LeecodeArray la = new LeecodeArray();
        int nums1[] = new int[]{0,1,0,3,12};
        la.moveZeroes(nums1);
        assertArrayEquals(new int[]{1,3,12,0,0}, nums1);
    }

    /**
     * 加一
     */
    @Test
    public void plusOneTest() {
        LeecodeArray la = new LeecodeArray();
        int nums1[] = new int[]{3, 1, 1};
        assertArrayEquals(new int[]{3,1, 2}, la.plusOne(nums1));
        nums1 = new int[]{9,9,9};
        assertArrayEquals(new int[]{1,0,0,0}, la.plusOne(nums1));
    }
    /**
     * 两个数组的交集
     */
    @Test
    public void intersectTest() {
        LeecodeArray la = new LeecodeArray();
        int nums1[] = new int[]{3, 1, 1, 7, 5};
        int nums2[] = new int[]{3, 22, 44, 66, 1, 1, 5, 3, 5, 6};
        assertArrayEquals(new int[]{1, 1, 3, 5}, la.intersect(nums1, nums2));
        nums1 = new int[]{1, 2, 2, 1};
        nums2 = new int[]{1, 2};
        assertArrayEquals(new int[]{1, 2}, la.intersect(nums1, nums2));
    }
    /**
     * 只出现一次的数字
     */
    @Test
    public void singleNumberTest() {
        LeecodeArray la = new LeecodeArray();
        assertEquals(1,la.singleNumber(new int[]{2,2,1}));
        assertEquals(4,la.singleNumber(new int[]{4,1,2,1,2}));
        assertEquals(6,la.singleNumber(new int[]{3,1,1,5,3,5,6,8,8}));
    }

    /**
     * 存在重复
     */
    @Test
    public void containsDuplicateTest(){
        LeecodeArray la=new LeecodeArray();
        assertTrue(la.containsDuplicate(new int[]{1,2,3,1}));
        assertFalse(la.containsDuplicate(new int[]{1,2,3,4}));
        assertTrue(la.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));
        assertTrue(la.containsDuplicate(new int[]{3,1,1,5,3,6}));
        //算法2
        assertTrue(la.containsDuplicate2(new int[]{1,2,3,1}));
        assertFalse(la.containsDuplicate2(new int[]{1,2,3,4}));
        assertTrue(la.containsDuplicate2(new int[]{1,1,1,3,3,4,3,2,4,2}));
        assertTrue(la.containsDuplicate2(new int[]{3,1,1,5,3,6}));
    }
    /**
     *  旋转数组
     */
    @Test
    public void rotateTest(){
        LeecodeArray la=new LeecodeArray();
        int []nums={1,2,3,4,5,6,7};
        int []out={5,6,7,1,2,3,4};
        la.rotate(nums,3);
        assertArrayEquals(nums,out);

        nums=new int[]{-1,-100,3,99};
        out=new int[]{3,99,-1,-100};
        la.rotate(nums,2);
        assertArrayEquals(nums,out);

        nums=new int[]{1};
        out=new int[]{1};
        la.rotate(nums,0);
        assertArrayEquals(nums,out);

        nums=new int[]{1};
        la.rotate(nums,1);
        assertArrayEquals(nums,out);

        //算法2
        nums=new int[]{1,2,3,4,5,6,7};
        out=new int[]{5,6,7,1,2,3,4};
        la.rotate2(nums,3);
        assertArrayEquals(nums,out);

        nums=new int[]{-1,-100,3,99};
        out=new int[]{3,99,-1,-100};
        la.rotate2(nums,2);
        assertArrayEquals(nums,out);

        nums=new int[]{1};
        out=new int[]{1};
        la.rotate2(nums,0);
        assertArrayEquals(nums,out);

        nums=new int[]{1};
        la.rotate2(nums,1);
        assertArrayEquals(nums,out);
    }
    /**
     *  买卖股票的最佳时机 II
     */
    @Test
    public void maxProfitTest(){
        LeecodeArray la=new LeecodeArray();
        int []nums={7,1,5,3,6,4};
        assertEquals(7,la.maxProfit(nums));
        nums=new int[]{1,2,3,4,5};
        assertEquals(4,la.maxProfit(nums));
        nums=new int[]{7,6,4,3,1};
        assertEquals(0,la.maxProfit(nums));
    }
    /**
     * 从排序数组中删除重复项
     */
    @Test
    public void removeDuplicatesTest(){
        LeecodeArray la=new LeecodeArray();
        assertEquals(5,la.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }

    /* ============================================LeecodeArray======================================================**/

    /**
     * 杨辉三角
     */
    @Test
    public void isValidTest(){
        LeecodeOthers lm=new LeecodeOthers();
        assertTrue(lm.isValid("()"));
        assertTrue(lm.isValid("()[]{}"));
        assertTrue(lm.isValid("()"));
        assertFalse(lm.isValid("(]"));
        assertFalse(lm.isValid("([)]"));
        assertTrue(lm.isValid("{[]}"));
        assertFalse(lm.isValid("[])"));
    }
    /**
     * 杨辉三角
     */
    @Test
    public void generateTest(){
        LeecodeOthers lm=new LeecodeOthers();
        assertEquals("[[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]", lm.generate(5).toString());
    }


    /**
     * 颠倒二进制
     */
    @Test
    public void reverseBitsTest2(){
        LeecodeOthers lm=new LeecodeOthers();
        assertEquals(964176192,lm.reverseBits2(43261596));
        assertEquals(-1073741825,lm.reverseBits2(-3));
    }
    /**
     * 颠倒二进制
     */
    @Test
    public void reverseBitsTest(){
        LeecodeOthers lm=new LeecodeOthers();
        assertEquals(964176192,lm.reverseBits(43261596));
        assertEquals(-1073741825,lm.reverseBits(-3));
    }
    /**
     * 汉明距离
     */
    @Test
    public void hammingDistanceTest(){
        LeecodeOthers lm=new LeecodeOthers();
        assertEquals(2,lm.hammingDistance(1,4));
    }
    /**
     * 汉明数字
     */
    @Test
    public void hammingWeightTest(){
        LeecodeOthers lm=new LeecodeOthers();
        assertEquals(3,lm.hammingWeight(7));
        assertEquals(31,lm.hammingWeight(-3));
    }

    /**
     * 罗马数字
     */
    @Test
    public void romanToIntTest(){
        LeecodeMath lm=new LeecodeMath();
        assertEquals(58,lm.romanToInt("LVIII"));
    }
    /**
     * 3的幂次方
     */
    @Test
    public void isPowerOfThreeTest() {
        LeecodeMath lm=new LeecodeMath();
        assertTrue(lm.isPowerOfThree(27));
        assertTrue(!lm.isPowerOfThree(0));
        assertTrue(lm.isPowerOfThree(9));
        assertTrue(!lm.isPowerOfThree(45));
    }
    /**
     * 质素
     */
    @Test
    public void countPrimesTest() {
        LeecodeMath lm=new LeecodeMath();
        assertEquals(4,lm.countPrimes(10));
    }

    /**
     * 最小栈
     */
    @Test
    public void fizzBuzzTest() {
        LeecodeMath lm=new LeecodeMath();
        String[] s=new String[]{
                "1",
                "2",
                "Fizz",
                "4",
                "Buzz",
                "Fizz",
                "7",
                "8",
                "Fizz",
                "Buzz",
                "11",
                "Fizz",
                "13",
                "14",
                "FizzBuzz"};
        String[] array = lm.fizzBuzz(15).toArray(new String[s.length]);
        assertArrayEquals(s,array);

    }
    @Test
    public void MinStackTest2() {
        LeecodeDesign.MinStack lm = new LeecodeDesign().new MinStack();
        lm.push(2147483646);
        lm.push(2147483646);
        lm.push(2147483647);
        lm.top();
        lm.pop();
        assertEquals(2147483646,lm.getMin());
        lm.pop();
        assertEquals(2147483646,lm.getMin());
        lm.pop();
        lm.push(2147483647);
        lm.top();
        assertEquals(2147483647,lm.getMin());
        lm.push(-2147483648);
        lm.top();
        assertEquals(-2147483648,lm.getMin());
        lm.pop();
        assertEquals(2147483647,lm.getMin());
    }
    /**
     * 最小栈
     */
    @Test
    public void MinStackTest() {
        LeecodeDesign.MinStack lm = new LeecodeDesign().new MinStack();
        lm.push(-2);
        lm.push(0);
        lm.push(-3);
        assertEquals(-3,lm.getMin());
        lm.pop();
        lm.pop();
        assertEquals(-2,lm.getMin());
    }
    /**
     * 买卖股票的最佳时机
     */
    @Test
    public void robTest(){
        LeetcodeDynamicProgramming ldp=new LeetcodeDynamicProgramming();
        int nums[]=new int[]{1,1,2,4,1};
        assertEquals(5,ldp.maxSubArray(nums));
//         nums=new int[]{2,7,9,3,1};
//        assertEquals(12,ldp.maxSubArray(nums));
    }
    /**
     * 买卖股票的最佳时机
     */
    @Test
    public void maxSubArrayTest(){
        LeetcodeDynamicProgramming ldp=new LeetcodeDynamicProgramming();
        int nums[]=new int[]{-2,1,-3,4,-1,2,1,-5,4};
        assertEquals(6,ldp.maxSubArray(nums));
         nums=new int[]{-1};
        assertEquals(-1,ldp.maxSubArray(nums));
    }
    @Test
    public void isMaxProfitTest2(){
        LeetcodeDynamicProgramming ldp=new LeetcodeDynamicProgramming();
        int prices[]=new int[]{1,2};
        assertEquals(1,ldp.maxProfit(prices));
        prices=new int[]{2,1,2,1,0,1,2};
        assertEquals(2,ldp.maxProfit(prices));
    }
    /**
     * 第一个错误的版本
     */
    @Test
    public void isMaxProfitTest(){
        LeetcodeDynamicProgramming ldp=new LeetcodeDynamicProgramming();
        int prices[]=new int[]{7,2,8,1,3,6,4};
        assertEquals(6,ldp.maxProfit(prices));
    }
    /**
     * 第一个错误的版本
     */
    @Test
    public void isClimbTest(){
        LeetcodeDynamicProgramming ldp=new LeetcodeDynamicProgramming();
        assertEquals(5,ldp.climbStairs2(5));
    }
    /**
     * 第一个错误的版本
     */
    @Test
    public void isFirstBadVersionTest(){
        LeetcodeSortingAndSearching lsas=new LeetcodeSortingAndSearching();
        assertEquals(3,lsas.firstBadVersion(8));
    }
    /**
     * 合并两个有序数组
     */
    @Test
    public void isMergeTest(){
        LeetcodeSortingAndSearching lsas=new LeetcodeSortingAndSearching();
        int nums0[]={1,2,2,3,5,6};
        int nums1[]={1,2,3,0,0,0};
        int nums2[]={2,5,6};
        lsas.merge(nums1,3,nums2,3);
        assertArrayEquals(nums0,nums1);
    }
    /**
     * 合并两个有序数组
     */
    @Test
    public void isMergeTest2(){
        LeetcodeSortingAndSearching lsas=new LeetcodeSortingAndSearching();
        int nums0[]={1,2};
        int nums1[]={2,0};
        int nums2[]={1};
        lsas.merge(nums1,1,nums2,1);
        assertArrayEquals(nums0,nums1);
    }
    /**
     * 合并两个有序数组
     */
    @Test
    public void isMergeTest3(){
        LeetcodeSortingAndSearching lsas=new LeetcodeSortingAndSearching();
        int nums0[]={-1,0,0,1,2,2,3,3,3};
        int nums1[]={-1,0,0,3,3,3,0,0,0};
        int nums2[]={1,2,2};
        lsas.merge(nums1,6,nums2,3);
        assertArrayEquals(nums0,nums1);
    }
    /**
     * 合并两个有序数组
     */
    @Test
    public void isMergeTest4(){
        LeetcodeSortingAndSearching lsas=new LeetcodeSortingAndSearching();
        int nums0[]={-1,0,0,1,1,1,2,3,3};
        int nums1[]={0,0,3,0,0,0,0,0,0};
        int nums2[]={-1,1,1,1,2,3};
        lsas.merge(nums1,3,nums2,6);
        assertArrayEquals(nums0,nums1);
    }
    /**
     * 验证二叉搜索树
     */
    @Test
    public void isValidBSTTest(){
        LeetcodeTrees trees=new LeetcodeTrees();
        TreeNode t0=new TreeNode(2);
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(4);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(6);
        t0.left=t1;
        t0.right=t2;
        t2.left=t3;
        t2.right=t4;
//        assertNotNull(trees.isValidBST(t0));
//        assertFalse(trees.isValidBST(t0));
        assertTrue(trees.isValidBST(t0));
    }
    /**
     * 二叉树最大深度
     */
    @Test
    public void maxDepthTest(){
        LeetcodeTrees trees=new LeetcodeTrees();
        TreeNode t0=new TreeNode(3);
        TreeNode t1=new TreeNode(9);
        TreeNode t2=new TreeNode(20);
        TreeNode t3=new TreeNode(15);
        TreeNode t4=new TreeNode(7);
        t0.left=t1;
        t0.right=t2;
        t2.left=t3;
        t2.right=t4;
        assertEquals(3,trees.maxDepth(t0));
    }
    @Test
    public void maxDepthTest2(){
        LeetcodeTrees trees=new LeetcodeTrees();
        TreeNode t0=new TreeNode(3);
        TreeNode t1=new TreeNode(9);
        TreeNode t2=new TreeNode(20);
        TreeNode t3=new TreeNode(15);
        TreeNode t4=new TreeNode(7);
        t0.left=t1;
        t0.right=t2;
        t2.left=t3;
        t3.right=t4;
        assertEquals(4,trees.maxDepth(t0));
    }


    LeetcodeLinked mLinked;
    ListNode nodes[];

    @Before
    public void init() {
        mLinked=new LeetcodeLinked();
        nodes = new ListNode[3];
        for (int i = nodes.length - 1; i >= 0; i--) {
            nodes[i] = new ListNode(i + 1);
            if (i < nodes.length - 1)
                nodes[i].next = nodes[i + 1];
        }
    }
    /**
     * 环形链表II
     */
    @Test(timeout = 1000)
    public void detectCycleTest3(){
        ListNode l0 = new ListNode(-1);
        ListNode l1= new ListNode(-7);
        ListNode l2 = new ListNode(7);
        ListNode l3 = new ListNode(-4);
        ListNode l4 = new ListNode(19);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(-9);
        ListNode l7 = new ListNode(-5);
        ListNode l8 = new ListNode(-2);
        ListNode l9 = new ListNode(-5);
        l0.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        l8.next = l9;
        l9.next = l6;
        assertEquals(l6, mLinked.detectCycle(l0));
    }
    @Test
    public void detectCycleTest2(){
        ListNode l1 = new ListNode(1);
        ListNode l2= new ListNode(2);
//        ListNode l0 = new ListNode(0);
//        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l1;
//        l0.next = l4;
//        l4.next = l2;
        assertEquals(l1, mLinked.detectCycle(l1));
    }
    @Test
    public void detectCycleTest(){
        ListNode l3 = new ListNode(3);
        ListNode l2= new ListNode(2);
        ListNode l0 = new ListNode(0);
        ListNode l4 = new ListNode(4);
        l3.next = l2;
        l2.next = l0;
        l0.next = l4;
        l4.next = l3;
        assertEquals(l3, mLinked.detectCycle(l3));
    }
    @Test
    public void hasCycleHashTest(){
        ListNode l3 = new ListNode(3);
        ListNode l2= new ListNode(2);
        ListNode l0 = new ListNode(0);
        ListNode l4 = new ListNode(4);
        l3.next = l2;
        l2.next = l0;
        l0.next = l4;
        l4.next = l2;
        assertTrue( mLinked.hasCycle2(l3));
    }
    @Test
    public void hasCycleTest(){
        ListNode l3 = new ListNode(3);
        ListNode l2= new ListNode(2);
        ListNode l0 = new ListNode(0);
        ListNode l4 = new ListNode(4);
        l3.next = l2;
        l2.next = l0;
        l0.next = l4;
        l4.next = l2;
        assertTrue( mLinked.hasCycle(l3));
    }
    @Test
    public void hasCycleTest2(){
        ListNode l3 = new ListNode(3);
        ListNode l2= new ListNode(2);
        l3.next = l2;
        l2.next = l2;
        assertTrue( mLinked.hasCycle(l3));
    }
    @Test
    public void hasCycleTest3(){
        ListNode l3 = new ListNode(3);
        ListNode l2= new ListNode(2);
        ListNode l0 = new ListNode(0);
        ListNode l4 = new ListNode(4);
        l3.next = l2;
        l2.next = l0;
        l0.next = l4;
        assertFalse( mLinked.hasCycle(l3));
    }


    @Test
    public void isPalindrome() {
        ListNode l3 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l1 = new ListNode(1);
        l3.next = l2;
        l2.next = l1;
        nodes[2].next = l3;
        assertTrue( mLinked.isPalindrome(nodes[0]));
    }

    @Test
    public void isPalindrome2() {
        ListNode l3 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l1 = new ListNode(1);
        l3.next = l2;
        l2.next = l1;
        assertFalse( mLinked.isPalindrome(l3));
    }

    @Test(timeout = 500)
    public void isPalindrome3() {
        ListNode l3 = new ListNode(3);
        l3.next = new ListNode(3);
        assertTrue( mLinked.isPalindrome(l3));
    }

    @Test
    public void isPalindrome4() {
        ListNode l3 = new ListNode(1);
        ListNode l2 = new ListNode(0);
        ListNode l1 = new ListNode(1);
        l3.next = l2;
        l2.next = l1;
        assertTrue(mLinked.isPalindrome(l3));
    }


}