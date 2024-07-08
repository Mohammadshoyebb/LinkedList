/*
92. Reverse Linked List II
Medium
Topics
Companies
Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

Example 1:
Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]

Example 2:
Input: head = [5], left = 1, right = 1
Output: [5]

Constraints:
The number of nodes in the list is n.
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n

Follow up: Could you do it in one pass?
*/

public class ReverseLinkedListII {
    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    // Function to reverse the linked list from position left to right using while loop
    public ListNode reverseBetweenWhileLoop(ListNode head, int left, int right) {
        // Edge case: If the list is empty or has only one node, or left equals right, return the head
        if (head == null || head.next == null || left == right) {
            return head;
        }

        // Create a dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Initialize pointers
        ListNode prev = dummy;

        // Move prev to the node before the start of the sublist to be reversed
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Start the reversal process
        ListNode current = prev.next;
        ListNode next = current.next;

        // Reverse the sublist between left and right using while loop
        int count = right - left;
        while (count > 0) {
            current.next = next.next;
            next.next = prev.next;
            prev.next = next;
            next = current.next;
            count--;
        }

        // Return the modified list
        return dummy.next;
    }
//==============================================================================================================


    // Function to reverse the linked list from position left to right using original method
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // Edge case: If the list is empty or has only one node, or left equals right, return the head
        if (head == null || head.next == null || left == right) {
            return head;
        }

        // Create a dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Initialize pointers
        ListNode prev = dummy;

        // Move prev to the node before the start of the sublist to be reversed
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Start the reversal process
        ListNode current = prev.next;
        ListNode next = current.next;

        // Reverse the sublist between left and right
        for (int i = 0; i < right - left; i++) {
            current.next = next.next;
            next.next = prev.next;
            prev.next = next;
            next = current.next;
        }

        // Return the modified list
        return dummy.next;
    }

    // Function to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example 1 using original method
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        System.out.print("Original list 1: ");
        printList(head1);
        ReverseLinkedListII solution = new ReverseLinkedListII();
        ListNode result1 = solution.reverseBetween(head1, 2, 4);
        System.out.print("Reversed list 1 (original method): ");
        printList(result1);

        // Example 1 using while loop method
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);
        System.out.print("Original list 2: ");
        printList(head2);
        ListNode result2 = solution.reverseBetweenWhileLoop(head2, 2, 4);
        System.out.print("Reversed list 2 (while loop method): ");
        printList(result2);

        // Example 2 using original method
        ListNode head3 = new ListNode(5);
        System.out.print("Original list 3: ");
        printList(head3);
        ListNode result3 = solution.reverseBetween(head3, 1, 1);
        System.out.print("Reversed list 3 (original method): ");
        printList(result3);

        // Example 2 using while loop method
        ListNode head4 = new ListNode(5);
        System.out.print("Original list 4: ");
        printList(head4);
        ListNode result4 = solution.reverseBetweenWhileLoop(head4, 1, 1);
        System.out.print("Reversed list 4 (while loop method): ");
        printList(result4);
    }
}

