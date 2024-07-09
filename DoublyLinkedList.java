public class DoublyLinkedList {
    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    Node head;

    // Insert at the start
    public void insertAtStart(int data) {
        Node newNode = new Node(data);
        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
    }

    // Insert at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    // Insert after a given node
    public void insertAfter(Node prevNode, int data) {
        if (prevNode == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
        newNode.prev = prevNode;
        if (newNode.next != null) {
            newNode.next.prev = newNode;
        }
    }

    // Delete a node from the start
    public void deleteFromStart() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
    }

    // Delete a node from the end
    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.prev.next = null;
    }

    // Delete a given node
    public void deleteNode(Node delNode) {
        if (head == null || delNode == null) {
            System.out.println("List is empty or node to be deleted is null.");
            return;
        }
        if (head == delNode) {
            head = delNode.next;
        }
        if (delNode.next != null) {
            delNode.next.prev = delNode.prev;
        }
        if (delNode.prev != null) {
            delNode.prev.next = delNode.next;
        }
    }

    // Display the list
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            temp = temp.next;
            if (temp != null) {
                System.out.print(" <-> ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.insertAtStart(5);
        dll.insertAtEnd(10);
        dll.insertAtEnd(15);
        dll.insertAtStart(0);

        Node secondNode = dll.head.next; // Getting the second node
        dll.insertAfter(secondNode, 7);

        System.out.println("List after insertions:");
        dll.display();

        dll.deleteFromStart();
        System.out.println("List after deleting from start:");
        dll.display();

        dll.deleteFromEnd();
        System.out.println("List after deleting from end:");
        dll.display();

        dll.deleteNode(dll.head.next); // Deleting the second node
        System.out.println("List after deleting a node from the middle:");
        dll.display();
    }
}
