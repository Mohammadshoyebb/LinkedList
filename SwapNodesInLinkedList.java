/**
 * 1721. Swapping Nodes in a Linked List
 * Medium
 * Topics
 * Companies
 * Hint
 * You are given the head of a linked list, and an integer k.
 *
 * Return the head of the linked list after swapping the values of the kth node from the beginning 
 * and the kth node from the end (the list is 1-indexed).
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [1,4,3,2,5]
 *
 * Example 2:
 * Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
 * Output: [7,9,6,6,8,7,3,0,9,5]
 *
 * Constraints:
 * The number of nodes in the list is n.
 * 1 <= k <= n <= 105
 * 0 <= Node.val <= 100
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class SwapNodesInLinkedList {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode first = head;
        ListNode second = head;
        ListNode kthFromStart = null;

        // Move first pointer to the k-th node
        for (int i = 1; i < k; i++) {
            first = first.next;
        }
        kthFromStart = first;

        // Move first to the end, second will reach k-th node from end
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }

        // Swap the values
        int temp = kthFromStart.val;
        kthFromStart.val = second.val;
        second.val = temp;

        return head;
    }

    // Utility method to print the linked list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Creating the linked list: 1->2->3->4->5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;
        System.out.println("Original Linked List:");
        printList(head);

        SwapNodesInLinkedList solution = new SwapNodesInLinkedList();
        head = solution.swapNodes(head, k);
        System.out.println("Modified Linked List:");
        printList(head);
    }
}

