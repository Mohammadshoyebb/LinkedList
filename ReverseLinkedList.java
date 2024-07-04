public class ReverseLinkedList {
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


    //Reverse LinkedList
    public void reverse(){
        Node curr = tail = head;
        Node prev = null;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();

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

        list.reverse();

        list.printLinkedList();
    }
}

