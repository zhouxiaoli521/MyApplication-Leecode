package leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LeecodeTest {
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
        ListNode l0 = new ListNode(0);
        ListNode l4 = new ListNode(4);
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
        assertEquals(true, mLinked.isPalindrome(nodes[0]));
    }

    @Test
    public void isPalindrome2() {
        ListNode l3 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l1 = new ListNode(1);
        l3.next = l2;
        l2.next = l1;
        assertEquals(false, mLinked.isPalindrome(l3));
    }

    @Test(timeout = 500)
    public void isPalindrome3() {
        ListNode l3 = new ListNode(3);
        ListNode l2 = new ListNode(3);
        l3.next = l2;
        assertEquals(true, mLinked.isPalindrome(l3));
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