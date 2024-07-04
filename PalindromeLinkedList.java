/**
 * 234. Palindrome Linked List
 * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
 *
 * Example 1:
 * Input: head = [1,2,2,1]
 * Output: true
 *
 * Example 2:
 * Input: head = [1,2]
 * Output: false
 *
 * Constraints:
 * - The number of nodes in the list is in the range [1, 10^5].
 * - 0 <= Node.val <= 9
 *
 * Follow up: Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        // Edge case: empty or single-node list is a palindrome
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        // Find the middle of the linked list using slow and fast pointers
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;   // Moves 1 step
            fast = fast.next.next;  // Moves 2 steps
        }

        // Reverse the second half of the linked list
        ListNode reversedSecondHalf = reverseList(slow.next);

        // Compare the first half and the reversed second half
        ListNode p1 = head;
        ListNode p2 = reversedSecondHalf;

        while (p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }

    // Helper method to reverse a linked list
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // ListNode class definition (assumed to be provided)
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        // Example 1: [1,2,2,1]
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(1);

        PalindromeLinkedList solution = new PalindromeLinkedList();
        System.out.println("Is LinkedList 1 a palindrome? " + solution.isPalindrome(head1)); // Output: true

        // Example 2: [1,2]
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);

        System.out.println("Is LinkedList 2 a palindrome? " + solution.isPalindrome(head2)); // Output: false

        // Example 3: [1,2,3,3,2,1]
        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(2);
        head3.next.next = new ListNode(3);
        head3.next.next.next = new ListNode(3);
        head3.next.next.next.next = new ListNode(2);
        head3.next.next.next.next.next = new ListNode(1);

        System.out.println("Is LinkedList 3 a palindrome? " + solution.isPalindrome(head3)); // Output: true

        // Example 4: [1,2,3,4,5,4,3,2,1]
        ListNode head4 = new ListNode(1);
        head4.next = new ListNode(2);
        head4.next.next = new ListNode(3);
        head4.next.next.next = new ListNode(4);
        head4.next.next.next.next = new ListNode(5);
        head4.next.next.next.next.next = new ListNode(4);
        head4.next.next.next.next.next.next = new ListNode(3);
        head4.next.next.next.next.next.next.next = new ListNode(2);
        head4.next.next.next.next.next.next.next.next = new ListNode(1);

        System.out.println("Is LinkedList 4 a palindrome? " + solution.isPalindrome(head4)); // Output: true

        // Example 5: [1,2,3,4,5,6,7,8,9]
        ListNode head5 = new ListNode(1);
        head5.next = new ListNode(2);
        head5.next.next = new ListNode(3);
        head5.next.next.next = new ListNode(4);
        head5.next.next.next.next = new ListNode(5);
        head5.next.next.next.next.next = new ListNode(6);
        head5.next.next.next.next.next.next = new ListNode(7);
        head5.next.next.next.next.next.next.next = new ListNode(8);
        head5.next.next.next.next.next.next.next.next = new ListNode(9);

        System.out.println("Is LinkedList 5 a palindrome? " + solution.isPalindrome(head5)); // Output: false
    }
}
