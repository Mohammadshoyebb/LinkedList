// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class RemoveCycle {
    public void removeCycle(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // Initialize two pointers, slow and fast
        ListNode slow = head;
        ListNode fast = head;

        // Detect cycle using Floyd's Tortoise and Hare algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // Cycle detected, find the entry point of the cycle
                break;
            }
        }

        // No cycle found
        if (fast == null || fast.next == null) {
            return;
        }

        // Move slow to the head. Keep fast at the meeting point.
        // Each are k steps from the cycle start. If they move at the same pace,
        // they must meet at the cycle start.
        slow = head;
        ListNode prev = null; // to keep track of the node just before the start of the cycle
        if (slow == fast) {
            // Special case: Cycle starts at the head
            while (fast.next != slow) {
                fast = fast.next;
            }
            fast.next = null; // Remove the cycle
        } else {
            while (slow != fast) {
                prev = fast;
                slow = slow.next;
                fast = fast.next;
            }
            // Remove the cycle
            prev.next = null;
        }
    }

    public static void main(String[] args) {
        // Example 1
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(0);
        head1.next.next.next = new ListNode(-4);
        head1.next.next.next.next = head1.next; // Creating a cycle
        RemoveCycle solution1 = new RemoveCycle();
        System.out.println("Example 1: Before removing cycle");
        solution1.printList(head1, 10); // Print limited number of nodes to avoid infinite loop
        solution1.removeCycle(head1);
        System.out.println("Example 1: After removing cycle");
        solution1.printList(head1, 10);

        // Example 2
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = head2; // Creating a cycle
        RemoveCycle solution2 = new RemoveCycle();
        System.out.println("Example 2: Before removing cycle");
        solution2.printList(head2, 10);
        solution2.removeCycle(head2);
        System.out.println("Example 2: After removing cycle");
        solution2.printList(head2, 10);

        // Example 3
        ListNode head3 = new ListNode(1);
        RemoveCycle solution3 = new RemoveCycle();
        System.out.println("Example 3: Before removing cycle");
        solution3.printList(head3, 10);
        solution3.removeCycle(head3);
        System.out.println("Example 3: After removing cycle");
        solution3.printList(head3, 10);

        // Edge Case: Cycle at the head
        ListNode head4 = new ListNode(1);
        head4.next = new ListNode(2);
        head4.next.next = new ListNode(3);
        head4.next.next.next = head4; // Creating a cycle at the head
        RemoveCycle solution4 = new RemoveCycle();
        System.out.println("Edge Case: Cycle at the head - Before removing cycle");
        solution4.printList(head4, 10);
        solution4.removeCycle(head4);
        System.out.println("Edge Case: Cycle at the head - After removing cycle");
        solution4.printList(head4, 10);
    }

    // Helper method to print the linked list
    public void printList(ListNode head, int limit) {
        ListNode current = head;
        int count = 0;
        while (current != null && count < limit) {
            System.out.print(current.val + " -> ");
            current = current.next;
            count++;
        }
        if (current != null) {
            System.out.print("...");
        } else {
            System.out.print("null");
        }
        System.out.println();
    }
}
