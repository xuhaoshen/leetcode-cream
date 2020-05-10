package algorithm.queue.leetcode_23;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: create by shen
 * @version: v1.0
 * @description:
 * @date:2020/2/16
 */
public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.intValue() - o2.intValue();
            }
        });
        for(int i = 0; i < k; i++) {
            ListNode listNode = lists[i];
            while (listNode != null) {
                ListNode current = listNode;
                priorityQueue.add(current.val);
                listNode = listNode.next;
            }
        }
        ListNode res = new ListNode(0);
        ListNode curr = res;
        while (!priorityQueue.isEmpty()) {
            curr.next = new ListNode(priorityQueue.poll());
            curr = curr.next;
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(5);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);

        ListNode listNode3 = new ListNode(2);
        listNode3.next = new ListNode(6);

        ListNode[] array = new ListNode[3];
        array[0] = listNode1;
        array[1] = listNode2;
        array[2] = listNode3;

        Solution solution = new Solution();
        solution.mergeKLists(array);


    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}