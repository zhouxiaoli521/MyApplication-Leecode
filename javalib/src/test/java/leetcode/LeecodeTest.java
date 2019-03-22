package leetcode;

import org.junit.Before;
import org.junit.Test;

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

    @Test(timeout = 1000000000)
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