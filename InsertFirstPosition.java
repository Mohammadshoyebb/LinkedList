public class InsertFirstPosition {
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

    // Method to add a node in the middle of the linked list at a given index
    public void addInMiddle(int data, int index) {
        // Create a new node
        Node newNode = new Node(data);
        size++; // Increment the size of the list

        // If the list is empty, both head and tail point to the new node
        if (head == null) {
            head = tail = newNode;
            return;
        }

        Node temp = head;
        int i = 0;

        // Traverse to the node before the desired position
        while (i < index - 1) {
            temp = temp.next;
            i++;
        }

        // Point new node to the next node
        newNode.next = temp.next;
        // Point current node to the new node
        temp.next = newNode;
    }

    // Method to remove the first node of the linked list
    public void removeFirst() {
        // If the list is empty, print a message and return
        if (size == 0) {
            System.out.println("Linked list is empty");
            return;
        }

        // If there is only one node, reset head and tail to null
        if (size == 1) {
            head = tail = null;
            size--;
            return;
        }

        // Move head to the next node
        head = head.next;
        size--; // Decrement the size of the list
    }

    // Method to remove the last node of the linked list
    public void removeLast() {
        // If the list is empty, print a message and return
        if (size == 0) {
            System.out.println("Linked list is empty");
            return;
        }

        // If there is only one node, reset head and tail to null
        if (size == 1) {
            head = tail = null;
            size--;
            return;
        }

        Node temp = head;
        // Traverse to the second last node
        while (temp.next.next != null) {
            temp = temp.next;
        }

        // Point second last node to null and update tail
        temp.next = null;
        tail = temp;
        size--; // Decrement the size of the list
    }

    // Method to search for an element in the linked list iteratively
    public int searchElementIndexIteration(int val) {
        Node temp = head; // Start from the head
        int index = 0;

        // Traverse through the list
        while (temp != null) {
            // If the node's data matches the value, return the index
            if (temp.data == val) {
                return index;
            }
            // Move to the next node and increment the index
            temp = temp.next;
            index++;
        }

        // Return -1 if the value is not found
        return -1;
    }

    // Method to search for an element in the linked list recursively
    public int recursiveSearch(int val) {
        return helper(val, head);
    }

    // Helper method for recursive search
    private int helper(int val, Node temp) {
        // If reached end of list, return -1
        if (temp == null) {
            return -1;
        }
        // If the node's data matches the value, return 0 (base case)
        if (temp.data == val) {
            return 0;
        }

        // Recursively search in the next nodes
        int index = helper(val, temp.next);
        // If value is not found in the remaining list, return -1
        if (index == -1) {
            return -1;
        }
        // Otherwise, return the index incremented by 1
        return index + 1;
    }

    public static void main(String[] args) {
        InsertFirstPosition d = new InsertFirstPosition();

        // Insertion at the beginning
        d.addBegin(5);
        d.addBegin(2);
        d.addBegin(1);

        // Insertion at the end
        d.addLast(7);
        d.addLast(25);
        d.addLast(20);

        // Print the linked list
        d.printLinkedList();

        // Insertion in the middle
        d.addInMiddle(3, 2);

        // Print the linked list
        d.printLinkedList();

        // Print the size of the linked list
        System.out.println(d.size);

        // Remove the first node
        d.removeFirst();
        d.printLinkedList();
        // Print the size of the linked list
        System.out.println(d.size);

        // Remove the last node
        d.removeLast();
        d.printLinkedList();

        // Search for an element iteratively
        System.out.println(d.searchElementIndexIteration(7));

        // Search for an element recursively
        System.out.println(d.recursiveSearch(25));
    }
}
