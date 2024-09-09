/**
 * 725. Split Linked List in Parts
 *
 * Given the head of a singly linked list and an integer k, split the linked list into k consecutive parts.
 *
 * The length of each part should be as equal as possible: no two parts should have a size differing by more than one.
 * This may lead to some parts being null.
 *
 * The parts should be in the order of occurrence in the input list, and parts occurring earlier should always have 
 * a size greater than or equal to parts occurring later.
 *
 * Return an array of the k parts.
 *
 * Example 1:
 * Input: head = [1, 2, 3], k = 5
 * Output: [[1], [2], [3], [], []]
 *
 * Example 2:
 * Input: head = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
 * Output: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
 *
 * Constraints:
 * - The number of nodes in the list is in the range [0, 1000].
 * - 0 <= Node.val <= 1000
 * - 1 <= k <= 50
 */

public class SplitLinkedListInParts {

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];  // Array to store the result, where each index will hold a part of the linked list.
        
        // Step 1: Calculate the length of the linked list
        int length = 0;  // Variable to store the total number of nodes in the linked list.
        ListNode temp = head;  // Temporary pointer to traverse the linked list.
        while (temp != null) {  // Traverse the entire linked list.
            length++;  // Increment the length for each node.
            temp = temp.next;  // Move to the next node.
        }
        
        // Step 2: Determine the size of each part
        int partSize = length / k;  // Calculate the minimum size of each part by dividing the total length by k.
        int extraNodes = length % k;  // Calculate how many extra nodes need to be distributed among the parts.
                                      // If extraNodes > 0, some parts will have one extra node.
    
        // Step 3: Split the list into k parts
        ListNode current = head;  // Pointer to the current node in the linked list.
        
        // Iterate over each part to divide the linked list
        for (int i = 0; i < k; i++) {
            result[i] = current;  // Set the start of the current part.
            
            // Calculate the current part size. Some parts might have one extra node if extraNodes > 0.
            int currentPartSize = partSize + (extraNodes-- > 0 ? 1 : 0);
    
            // Move the current pointer to the end of the current part.
            for (int j = 0; j < currentPartSize - 1; j++) {
                if (current != null) {
                    current = current.next;  // Move to the next node in the current part.
                }
            }
    
            // If there are still nodes left, break the link to form the current part.
            if (current != null) {
                ListNode next = current.next;  // Store the next node before breaking the link.
                current.next = null;  // Break the link to end the current part.
                current = next;  // Move to the start of the next part.
            }
        }
        return result;  // Return the array of split parts.
    }
    

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Main method to test the code
    public static void main(String[] args) {
        SplitLinkedListInParts solution = new SplitLinkedListInParts();

        // Example 1
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        int k1 = 5;
        ListNode[] result1 = solution.splitListToParts(head1, k1);
        System.out.println("Example 1 Result:");
        printResult(result1);  // Expected Output: [[1], [2], [3], [], []]

        // Example 2
        ListNode head2 = new ListNode(1, 
                new ListNode(2, 
                    new ListNode(3, 
                        new ListNode(4, 
                            new ListNode(5, 
                                new ListNode(6, 
                                    new ListNode(7, 
                                        new ListNode(8, 
                                            new ListNode(9, 
                                                new ListNode(10))))))))));
        int k2 = 3;
        ListNode[] result2 = solution.splitListToParts(head2, k2);
        System.out.println("Example 2 Result:");
        printResult(result2);  // Expected Output: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
    }

    // Helper function to print the result
    private static void printResult(ListNode[] result) {
        for (ListNode node : result) {
            System.out.print("[");
            while (node != null) {
                System.out.print(node.val);
                node = node.next;
                if (node != null) System.out.print(", ");
            }
            System.out.println("]");
        }
    }
}

// =========================================== Easy Logic By Shash Code ===========================================

/*
 
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode temp = head;
        int size = 0;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        ListNode[] res = new ListNode[k];

        int avg = size/k;
        int extra = size%k;

        temp = head;

        for(int i=0;i<k;i++){
            if(temp ==  null){
                break;
            }
            ListNode curHead = temp;
            ListNode prev = null;
            int len = 0;

            while(temp != null && len < avg){
                prev = temp;
                temp = temp.next;
                len++;
            }
            if(extra > 0){
                prev = temp;
                temp = temp.next;
                extra--;
            }
            prev.next = null;
            res[i] = curHead;
        }
        return res;
    }
}

 */