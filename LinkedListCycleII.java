// 142. Linked List Cycle II
// Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
// There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
// Do not modify the linked list.

// Example 1:
// Input: head = [3,2,0,-4], pos = 1
// Output: tail connects to node index 1
// Explanation: There is a cycle in the linked list, where tail connects to the second node.

// Example 2:
// Input: head = [1,2], pos = 0
// Output: tail connects to node index 0
// Explanation: There is a cycle in the linked list, where tail connects to the first node.

// Example 3:
// Input: head = [1], pos = -1
// Output: no cycle
// Explanation: There is no cycle in the linked list.

// Constraints:
// The number of the nodes in the list is in the range [0, 10^4].
// -10^5 <= Node.val <= 10^5
// pos is -1 or a valid index in the linked-list.

// Follow up: Can you solve it using O(1) (i.e. constant) memory?

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        // Initialize two pointers, slow and fast
        ListNode slow = head;
        ListNode fast = head;

        // Move slow by one step and fast by two steps
        // If they meet, there is a cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // Cycle detected, find the entry point of the cycle
                ListNode entry = head;
                while (entry != slow) {
                    entry = entry.next;
                    slow = slow.next;
                }
                return entry; // Entry point of the cycle
            }
        }
        return null; // No cycle
    }

    public static void main(String[] args) {
        // Example 1
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(0);
        head1.next.next.next = new ListNode(-4);
        head1.next.next.next.next = head1.next; // Creating a cycle
        LinkedListCycleII solution1 = new LinkedListCycleII();
        System.out.println("Example 1: " + (solution1.detectCycle(head1) != null ? "tail connects to node index " + head1.next.val : "no cycle"));

        // Example 2
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = head2; // Creating a cycle
        LinkedListCycleII solution2 = new LinkedListCycleII();
        System.out.println("Example 2: " + (solution2.detectCycle(head2) != null ? "tail connects to node index " + head2.val : "no cycle"));

        // Example 3
        ListNode head3 = new ListNode(1);
        LinkedListCycleII solution3 = new LinkedListCycleII();
        System.out.println("Example 3: " + (solution3.detectCycle(head3) != null ? "tail connects to node index " + head3.val : "no cycle"));
    }
}

