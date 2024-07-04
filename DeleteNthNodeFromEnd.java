/*
 * 19. Remove Nth Node From End of List
Solved
Medium
Topics
Companies
Hint
Given the head of a linked list, remove the nth node from the end of the list and return its head.

 

Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]
 

Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
 */
public class DeleteNthNodeFromEnd {
    // Inner class to represent a node in the linked list
    public class Node {
        int data; // Value stored in the node
        Node next; // Reference to the next node in the list

        // Constructor to initialize node data and set next to null
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head and tail pointers for the linked list
    public static Node head;
    public static Node tail;
    public static int size;

    // Method to add a node at the beginning of the linked list
    public void addBegin(int data) {
        // Create a new node
        Node newNode = new Node(data);
        size++; // Increment the size of the list

        // If the list is empty, both head and tail point to the new node
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // Point the new node to the current head
        newNode.next = head;
        // Update head to the new node
        head = newNode;
    }

    // Method to add a node at the end of the linked list
    public void addLast(int data) {
        // Create a new node
        Node newNode = new Node(data);
        size++; // Increment the size of the list

        // If the list is empty, both head and tail point to the new node
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // Point the current tail to the new node
        tail.next = newNode;
        // Update tail to the new node
        tail = newNode;
    }

    // Method to print the linked list
    public void printLinkedList() {
        Node temp = head; // Start from the head
        while (temp != null) {
            // Print the data in the current node
            System.out.print(temp.data + " -> ");
            // Move to the next node
            temp = temp.next;
        }
        System.out.println("Null"); // Indicate the end of the list
    }

    // Method to reverse the linked list
    public void reverse() {
        Node prev = null; // Previous node, initially null
        Node current = head; // Current node, start with the head
        Node next = null; // Next node, initially null

        while (current != null) {
            next = current.next; // Save the next node
            current.next = prev; // Reverse the link: current node points to previous node
            prev = current; // Move prev to the current node
            current = next; // Move current to the next node
        }

        head = prev; // Update head to the last non-null node, which is the new head
    }


//====================Remove from Last===================================
    public void removeFromEnd(int position){
        if(head == null){
            return;
        }
        Node curr = head;
        int idx = 0;
        while(curr != null){
            curr = curr.next;
            idx++;
        }
        int newPosition = idx - position;

        if(position == idx){
            head = head.next;
            return;
        }

        Node temp = head;
        for(int i=1;i<newPosition;i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return;
    }
    public static void main(String[] args) {
        DeleteNthNodeFromEnd list = new DeleteNthNodeFromEnd();

        // Adding unique elements to the linked list
        list.addBegin(7);
        list.addBegin(6);
        list.addBegin(5);
        list.addLast(8);
        list.addLast(9);
        list.addLast(10);
        list.addBegin(4);

        // Print the linked list
        list.printLinkedList();

        // Reverse the linked list
        list.reverse();

        // Print the reversed linked list
        list.printLinkedList();

        list.removeFromEnd(3);
        list.printLinkedList();
    }
}
