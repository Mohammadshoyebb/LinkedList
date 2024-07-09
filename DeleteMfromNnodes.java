/**
 * Delete N nodes after M nodes of a linked list
 * 
 * Given a linked list and two integers M and N. Traverse the linked list such 
 * that you retain M nodes then delete next N nodes, continue the same till 
 * end of the linked list.
 * 
 * Difficulty Level: Rookie
 * 
 * Examples:
 * 
 * Input:
 * M = 2, N = 2
 * Linked List: 1->2->3->4->5->6->7->8
 * Output:
 * Linked List: 1->2->5->6
 * 
 * Input:
 * M = 3, N = 2
 * Linked List: 1->2->3->4->5->6->7->8->9->10
 * Output:
 * Linked List: 1->2->3->6->7->8
 * 
 * Input:
 * M = 1, N = 1
 * Linked List: 1->2->3->4->5->6->7->8->9->10
 * Output:
 * Linked List: 1->3->5->7->9
 */

 import java.util.*;

 public class DeleteMfromNnodes {
 
     // A linked list node
     static class Node {
         int data;
         Node next;
     }
 
     /* Function to insert a node at the beginning */
     static Node push(Node head_ref, int new_data) {
         /* allocate node */
         Node new_node = new Node();
 
         /* put in the data */
         new_node.data = new_data;
 
         /* link the old list of the new node */
         new_node.next = head_ref;
 
         /* move the head to point to the new node */
         head_ref = new_node;
 
         return head_ref;
     }
 
     /* Function to print linked list */
     static void printList(Node head) {
         Node temp = head;
         while (temp != null) {
             System.out.printf("%d ", temp.data);
             temp = temp.next;
         }
         System.out.printf("\n");
     }
 
     // Function to skip M nodes and then delete N nodes of the linked list.
     static void skipMdeleteN(Node head, int M, int N) {
         Node curr = head, t;
         int count;
 
         // The main loop that traverses through the whole list
         while (curr != null) {
             // Skip M nodes
             for (count = 1; count < M && curr != null; count++)
                 curr = curr.next;
 
             // If we reached end of list, then return
             if (curr == null)
                 return;
 
             // Start from next node and delete N nodes
             t = curr.next;
             for (count = 1; count <= N && t != null; count++) {
                 Node temp = t;
                 t = t.next;
             }
 
             // Link the previous list with remaining nodes
             curr.next = t;
 
             // Set current pointer for next iteration
             curr = t;
         }
     }
 
     // Driver code
     public static void main(String args[]) {
         /* Create following linked list 
         1.2.3.4.5.6.7.8.9.10 */
         Node head = null;
         int M = 2, N = 3;
         head = push(head, 10);
         head = push(head, 9);
         head = push(head, 8);
         head = push(head, 7);
         head = push(head, 6);
         head = push(head, 5);
         head = push(head, 4);
         head = push(head, 3);
         head = push(head, 2);
         head = push(head, 1);
 
         System.out.printf("M = %d, N = %d \nGiven Linked list is :\n", M, N);
         printList(head);
 
         skipMdeleteN(head, M, N);
 
         System.out.printf("\nLinked list after deletion is :\n");
         printList(head);
     }
 }
 