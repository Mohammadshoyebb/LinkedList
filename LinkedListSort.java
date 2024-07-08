/*
148. Sort List
Solved
Medium
Topics
Companies
Given the head of a linked list, return the list after sorting it in ascending order.

Example 1:
Input: head = [4,2,1,3]
Output: [1,2,3,4]

Example 2:
Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]

Example 3:
Input: head = []
Output: []

Constraints:
The number of nodes in the list is in the range [0, 5 * 10^4].
-10^5 <= Node.val <= 10^5

Follow up: Can you sort the linked list in O(n log n) time and O(1) memory (i.e. constant space)?
*/

public class LinkedListSort {
    // Function to find the middle of the linked list
    private ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // Function to merge two sorted linked lists
    private ListNode merge(ListNode newLeft, ListNode newRight){
        ListNode temp = new ListNode(-1);
        ListNode result = temp;

        while(newLeft != null && newRight != null){
            if(newLeft.val <= newRight.val){
                temp.next = newLeft;
                newLeft = newLeft.next;
                temp = temp.next;
            }
            else{
                temp.next = newRight;
                newRight = newRight.next;
                temp = temp.next;
            }
        }
        while(newLeft != null){
            temp.next = newLeft;
                newLeft = newLeft.next;
                temp = temp.next;
        }
        while(newRight != null){
             temp.next = newRight;
                newRight = newRight.next;
                temp = temp.next;
        }
        return result.next;
    }

    // Main function to sort the linked list
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode mid = findMid(head);

        ListNode rightHead = mid.next;
        mid.next = null;

        ListNode newLeft = sortList(head);
        ListNode newRight = sortList(rightHead);

        return merge(newLeft, newRight);
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
        // Creating the linked list [4, 2, 1, 3]
        ListNode head1 = new ListNode(4);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(1);
        head1.next.next.next = new ListNode(3);

        // Printing the original list
        System.out.print("Original list 1: ");
        printList(head1);

        // Sorting the list
        LinkedListSort solution = new LinkedListSort();
        ListNode sortedHead1 = solution.sortList(head1);

        // Printing the sorted list
        System.out.print("Sorted list 1: ");
        printList(sortedHead1);

        // Creating the linked list [-1, 5, 3, 4, 0]
        ListNode head2 = new ListNode(-1);
        head2.next = new ListNode(5);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(0);

        // Printing the original list
        System.out.print("Original list 2: ");
        printList(head2);

        // Sorting the list
        ListNode sortedHead2 = solution.sortList(head2);

        // Printing the sorted list
        System.out.print("Sorted list 2: ");
        printList(sortedHead2);
    }

    // Example to illustrate the process
    /*
    Step-by-Step Example
    Initial Call: The initial linked list is [4, 2, 1, 3].

    head points to 4.
    The list is not empty, and it has more than one node.
    Finding the Middle: Call findMid(head) to find the middle of the list.

    Let's say the middle node is 2. The list is split into [4, 2] and [1, 3].
    Dividing the List:

    The rightHead pointer is set to the node after 2, which is 1.
    Set mid.next to null to break the list into two parts.
    Recursive Sorting:

    Left Sublist: [4, 2]

    Call sortList(head), where head points to 4.
    Again, find the middle node of [4, 2], which is 4. Split into [4] and [2].
    Recursively sort [4] and [2]:
    [4] is already sorted as it has only one node.
    [2] is already sorted as it has only one node.
    Merge [4] and [2] to get [2, 4].
    Right Sublist: [1, 3]

    Call sortList(rightHead), where rightHead points to 1.
    Find the middle node of [1, 3], which is 1. Split into [1] and [3].
    Recursively sort [1] and [3]:
    [1] is already sorted as it has only one node.
    [3] is already sorted as it has only one node.
    Merge [1] and [3] to get [1, 3].
    Merging:

    Now that we have two sorted sublists, [2, 4] and [1, 3], we merge them.
    The final sorted list is [1, 2, 3, 4].
    Summary of Calls
    Initial list: [4, 2, 1, 3]
    Split into [4, 2] and [1, 3]
    Sort [4, 2] into [2, 4]
    Sort [1, 3] into [1, 3]
    Merge [2, 4] and [1, 3] into [1, 2, 3, 4]
    Result
    The sortList method sorts the linked list in ascending order, resulting in [1, 2, 3, 4].

    By breaking down the list into smaller parts, sorting those parts, and merging them back together, sortList efficiently sorts the linked list using the merge sort algorithm.
    */

    /*
    Another Example
    Initial Call: The initial linked list is [-1, 5, 3, 4, 0].

    head points to -1.
    The list is not empty, and it has more than one node.
    Finding the Middle: Call findMid(head) to find the middle of the list.

    Let's say the middle node is 3. The list is split into [-1, 5, 3] and [4, 0].
    Dividing the List:

    The rightHead pointer is set to the node after 3, which is 4.
    Set mid.next to null to break the list into two parts.
    Recursive Sorting:

    Left Sublist: [-1, 5, 3]

    Call sortList(head), where head points to -1.
    Again, find the middle node of [-1, 5, 3], which is 5. Split into [-1, 5] and [3].
    Recursively sort [-1, 5] and [3]:
    [-1, 5] is split into [-1] and [5]. Both are already sorted.
    Merge [-1] and [5] to get [-1, 5].
    [3] is already sorted as it has only one node.
    Merge [-1, 5] and [3] to get [-1, 3, 5].
    Right Sublist: [4, 0]

    Call sortList(rightHead), where rightHead points to 4.
    Find the middle node of [4, 0], which is 4. Split into [4] and [0].
    Recursively sort [4] and [0]:
    [4] is already sorted as it has only one node.
    [0] is already sorted as it has only one node.
    Merge [4] and [0] to get [0, 4].
    Merging:

    Now that we have two sorted sublists, [-1, 3, 5] and [0, 4], we merge them.
    The final sorted list is [-1, 0, 3, 4, 5].
    Summary of Calls
    Initial list: [-1, 5, 3, 4, 0]
    Split into [-1, 5, 3] and [4, 0]
    Sort [-1, 5, 3] into [-1, 3, 5]
    Sort [4, 0] into [0, 4]
    Merge [-1, 3, 5] and [0, 4] into [-1, 0, 3, 4, 5]
    Result
    The sortList method sorts the linked list in ascending order, resulting in [-1, 0, 3, 4, 5].

    By breaking down the list into smaller parts, sorting those parts, and merging them back together, sortList efficiently sorts the linked list using the merge sort algorithm.
    */
}
