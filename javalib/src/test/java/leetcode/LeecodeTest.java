package leetcode;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeecodeTest {
    static Leecode mLeecode;
    static Leecode.ListNode nodes[];

    @BeforeClass
    public static void init() {
        mLeecode = new Leecode();
        nodes = new Leecode.ListNode[3];
        for (int i = nodes.length - 1; i >= 0; i--) {
            nodes[i] = new Leecode.ListNode(i + 1);
            if (i < nodes.length - 1)
                nodes[i].next = nodes[i + 1];
        }
    }

    @Test
    public void removeDuplicates() {
        int nums[] = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int nums2[] = new int[]{1, 1, 2};
        assertEquals(5, Leecode.removeDuplicates(nums));
        assertEquals(2, Leecode.removeDuplicates(nums2));
    }

    @Test
    public void isPalindrome() {
        Leecode.ListNode l3 = new Leecode.ListNode(3);
        Leecode.ListNode l2 = new Leecode.ListNode(2);
        Leecode.ListNode l1 = new Leecode.ListNode(1);
        l3.next = l2;
        l2.next = l1;
        nodes[2].next = l3;
        assertEquals(true, mLeecode.isPalindrome(nodes[0]));
    }
    @Test
    public void isPalindrome2() {
        Leecode.ListNode l3 = new Leecode.ListNode(3);
        Leecode.ListNode l2 = new Leecode.ListNode(2);
        Leecode.ListNode l1 = new Leecode.ListNode(1);
        l3.next = l2;
        l2.next = l1;
        assertEquals(false, mLeecode.isPalindrome(l3));
    }
    @Test(timeout = 500)
    public void isPalindrome3() {
        Leecode.ListNode l3 = new Leecode.ListNode(3);
        Leecode.ListNode l2 = new Leecode.ListNode(3);
        l3.next = l2;
        assertEquals(true, mLeecode.isPalindrome(l3));
    }
    @Test
    public void isPalindrome4() {
        Leecode.ListNode l3 = new Leecode.ListNode(1);
        Leecode.ListNode l2 = new Leecode.ListNode(0);
        Leecode.ListNode l1 = new Leecode.ListNode(1);
        l3.next = l2;
        l2.next = l1;
        assertTrue( mLeecode.isPalindrome(l3));
    }
}