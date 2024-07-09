/**
 * 160. Intersection of Two Linked Lists
 * Solved
 * Easy
 * Topics
 * Companies
 * 
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
 * If the two linked lists have no intersection at all, return null.
 * 
 * For example, the following two linked lists begin to intersect at node c1:
 * 
 * The test cases are generated such that there are no cycles anywhere in the entire linked structure.
 * 
 * Note that the linked lists must retain their original structure after the function returns.
 * 
 * Custom Judge:
 * 
 * The inputs to the judge are given as follows (your program is not given these inputs):
 * 
 * intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
 * listA - The first linked list.
 * listB - The second linked list.
 * skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
 * skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
 * The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB to your program.
 * If you correctly return the intersected node, then your solution will be accepted.
 * 
 * Example 1:
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * Output: Intersected at '8'
 * Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
 * From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5].
 * There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 * - Note that the intersected node's value is not 1 because the nodes with value 1 in A and B (2nd node in A and 3rd node in B) are different node references.
 * In other words, they point to two different locations in memory, while the nodes with value 8 in A and B (3rd node in A and 4th node in B) point to the same location in memory.
 * 
 * Example 2:
 * Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * Output: Intersected at '2'
 * Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect).
 * From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
 * 
 * Example 3:
 * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * Output: No intersection
 * Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
 * Explanation: The two lists do not intersect, so return null.
 * 
 * Constraints:
 * 
 * The number of nodes of listA is in the m.
 * The number of nodes of listB is in the n.
 * 1 <= m, n <= 3 * 10^4
 * 1 <= Node.val <= 10^5
 * 0 <= skipA < m
 * 0 <= skipB < n
 * intersectVal is 0 if listA and listB do not intersect.
 * intersectVal == listA[skipA] == listB[skipB] if listA and listB intersect.
 * 
 * Follow up: Could you write a solution that runs in O(m + n) time and use only O(1) memory?
 */


 // Definition for singly-linked list.
 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class IntersectionOfLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode t1 = headA;
        ListNode t2 = headB;

        while (t1 != t2) {
            t1 = (t1 == null) ? headB : t1.next;
            t2 = (t2 == null) ? headA : t2.next;
        }
        return t1;
    }

    public static void main(String[] args) {
        // Example to test the getIntersectionNode method
        // Creating linked lists for testing
        ListNode intersect = new ListNode(8);
        intersect.next = new ListNode(4);
        intersect.next.next = new ListNode(5);

        ListNode listA = new ListNode(4);
        listA.next = new ListNode(1);
        listA.next.next = intersect;

        ListNode listB = new ListNode(5);
        listB.next = new ListNode(6);
        listB.next.next = new ListNode(1);
        listB.next.next.next = intersect;

        IntersectionOfLinkedLists solution = new IntersectionOfLinkedLists();
        ListNode intersectionNode = solution.getIntersectionNode(listA, listB);

        if (intersectionNode != null) {
            System.out.println("Intersected at '" + intersectionNode.val + "'");
        } else {
            System.out.println("No intersection");
        }
    }
}
