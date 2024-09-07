/**
 * 3217. Delete Nodes From Linked List Present in Array
 *
 * You are given an array of integers nums and the head of a linked list. 
 * Return the head of the modified linked list after removing all nodes 
 * from the linked list that have a value that exists in nums.
 *
 * Example 1:
 * Input: nums = [1, 2, 3], head = [1, 2, 3, 4, 5]
 * Output: [4, 5]
 * Explanation: Remove the nodes with values 1, 2, and 3.
 *
 * Example 2:
 * Input: nums = [1], head = [1, 2, 1, 2, 1, 2]
 * Output: [2, 2, 2]
 * Explanation: Remove the nodes with value 1.
 *
 * Example 3:
 * Input: nums = [5], head = [1, 2, 3, 4]
 * Output: [1, 2, 3, 4]
 * Explanation: No node has value 5.
 *
 * Constraints:
 * - 1 <= nums.length <= 105
 * - 1 <= nums[i] <= 105
 * - All elements in nums are unique.
 * - The number of nodes in the given list is in the range [1, 105].
 * - 1 <= Node.val <= 105
 * - The input is generated such that there is at least one node in the linked list that has a value not present in nums.
 */

import java.util.HashSet;

public class DeleteNodesFromLinkedList {
    
    public ListNode deleteNodes(ListNode head, int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        // Dummy node to handle edge cases (head being deleted)
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode curr = head;
        
        while (curr != null) {
            if (set.contains(curr.val)) {
                prev.next = curr.next; // Remove the node
            } else {
                prev = curr; // Move prev to current if not deleted
            }
            curr = curr.next;
        }
        
        return dummy.next; // Return the modified list
    }

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    // Main method to test the code
    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {1, 2, 3};
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        DeleteNodesFromLinkedList obj = new DeleteNodesFromLinkedList();
        ListNode result1 = obj.deleteNodes(head1, nums1);
        System.out.print("Modified List (Example 1): ");
        printList(result1);

        // Example 2
        int[] nums2 = {1};
        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(1, new ListNode(2, new ListNode(1, new ListNode(2))))));
        ListNode result2 = obj.deleteNodes(head2, nums2);
        System.out.print("Modified List (Example 2): ");
        printList(result2);

        // Example 3
        int[] nums3 = {5};
        ListNode head3 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode result3 = obj.deleteNodes(head3, nums3);
        System.out.print("Modified List (Example 3): ");
        printList(result3);
    }
}
