package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LeetcodeLinked {

    public static void main(String args[]) {
        ListNode nodes[] = new ListNode[3];
        for (int i = nodes.length - 1; i >= 0; i--) {
            nodes[i] = new ListNode(i * 2 + 1);
            if (i < nodes.length - 1)
                nodes[i].next = nodes[i + 1];
        }
        ListNode nodes2[] = new ListNode[3];
        for (int i = nodes2.length - 1; i >= 0; i--) {
            nodes2[i] = new ListNode(i * 2);
            if (i < nodes.length - 1)
                nodes2[i].next = nodes2[i + 1];
        }
//        ListNode node = removeNthFromEnd2(nodes[0], 2);
//        ListNode node = reverseList(nodes[0]);
//        ListNode node = reverseList2(nodes[0]);
//        ListNode node = reverseBetween(nodes[0],2,4);
        ListNode node = mergeTwoLists2(nodes[0], nodes2[0]);
        while (node != null) {
            if (node.next != null)
                System.out.print(node.val + "->" + node.next.val + " ");
            else
                System.out.print(node.val + "->null");
            node = node.next;
        }
    }

    /**
     * 环形链表 II
     * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     *
     * @param head 0
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        //标志是否有环
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (head != fast) {
                    head = head.next;
                    fast = fast.next;
                }
                return fast;
            }
        }
        return null;
    }

    /**
     * 环形列表 哈希表
     *
     * @param head 0
     * @return 是否有环
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null)
            return false;
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.contains(head)) {
                set.add(head);
                head = head.next;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 环形列表 快慢指针
     *
     * @param head 0
     * @return 是否有环
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * 要实现 O(n) 的时间复杂度和 O(1) 的空间复杂度，需要翻转后半部分
     *
     * @param head 1
     * @return 回文链表
     */
    public boolean isPalindrome(ListNode head) {
        // 要实现 O(n) 的时间复杂度和 O(1) 的空间复杂度，需要翻转后半部分
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        // 根据快慢指针，找到链表的中点
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = reverseList2(slow.next);
        while (slow != null) {
            if (head.val != slow.val) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    /**
     * 合并两个有序链表
     *
     * @param l1 1
     * @param l2 2
     * @return l0
     */
    static public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode l0 = null;
        if (l1.val <= l2.val) {
            l0 = l1;
            l0.next = mergeTwoLists2(l1.next, l2);
        } else {
            l0 = l2;
            l2.next = mergeTwoLists2(l1, l2.next);
        }
        return l0;
    }

    /**
     * 合并两个有序链表
     *
     * @param l1
     * @param l2
     * @return
     */
    static public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l0 = new ListNode(0);
        ListNode start = l0;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                l0.next = l1;
                l0 = l0.next;
                l1 = l1.next;
            } else {
                l0.next = l2;
                l0 = l0.next;
                l2 = l2.next;
            }
        }
        if (l1 == null) {
            l0.next = l2;
        } else {
            l0.next = l1;
        }
        return start.next;

    }

    /**
     * 反转链表 头插法
     * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
     *
     * @param head
     * @return
     */
    static public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null)
            return head;
        if (m < 1 || m > n || n == m)
            return head;
        ListNode pre = null;
        ListNode pos = null;
        // 记录m之前的一个节点 用于指向反转之后的首个节点
        ListNode mNode = null;
        //记录m位置的节点 这个节点就是反转之后的最后一个节点 用它来指向n之后的正常节点
        ListNode nNode = null;
        //zero节点 用于方法返回首节点
        ListNode zNode = head;

        int index = 0;
        if (m == 1) {
            nNode = head;
        } else {
            //让index走到m-1 保存mNode
            while (index + 1 < m - 1) {
                index++;
                head = head.next;
            }
            mNode = head;
            //让index走到m 保存nNode
            index++;
            head = head.next;
            nNode = head;
        }
        while (index < n) {
            index++;
            pos = head.next;
            head.next = pre;
            pre = head;
            head = pos;
        }
        //如果不是从第一个节点开始反转 就用保存的m-1的节点 指向反转之后的第一个节点
        if (mNode != null) {
            mNode.next = pre;
        }
        //指向n后面的正常节点
        nNode.next = head;
        return m == 1 ? pre : zNode;
    }

    /**
     * 反转链表 头插法
     *
     * @param head
     * @return
     */
    static public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode pre = null;
        ListNode pos = null;
        while (head != null) {
            pos = head.next;
            head.next = pre;
            pre = head;
            head = pos;
        }
        return pre;
    }

    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    static public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return dummy;
    }


    /**
     * 删除链表的倒数第N个节点
     * 双指针
     *
     * @param head
     * @param n
     * @return
     */
    static public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for (int i = 1; i < n + 1; i++) {
            first = first.next;
        }
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    /**
     * 删除链表的倒数第N个节点
     *
     * @param head
     * @param n
     * @return
     */
    static public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return head = null;
        }
        int i = 0;
        HashMap<Integer, ListNode> hashMap = new HashMap<Integer, ListNode>();
        do {
            hashMap.put(i, head);
            i++;
            head = head.next;
        } while (head != null);
        ListNode temp = (ListNode) hashMap.get(i - n);
        //尾节点
        if (temp.next == null) {
            ((ListNode) hashMap.get(i - n - 1)).next = null;
            temp = null;
        } else {
            temp.val = temp.next.val;
            temp.next = temp.next.next;
            temp = null;
        }
        return (ListNode) hashMap.get(0);
    }

    /**
     * 删除链表中的节点
     * 你将只被给定要求被删除的节点。
     *
     * @param node
     */
    static public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
