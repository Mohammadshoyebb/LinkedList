public class DoublyCircularLinkedList {
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
        if (head == null) {
            newNode.next = newNode;
            newNode.prev = newNode;
            head = newNode;
        } else {
            Node last = head.prev;
            newNode.next = head;
            newNode.prev = last;
            head.prev = newNode;
            last.next = newNode;
            head = newNode;
        }
    }

    // Insert at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            newNode.next = newNode;
            newNode.prev = newNode;
            head = newNode;
        } else {
            Node last = head.prev;
            newNode.next = head;
            newNode.prev = last;
            last.next = newNode;
            head.prev = newNode;
        }
    }

    // Insert after a given node
    public void insertAfter(Node prevNode, int data) {
        if (prevNode == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }
        Node newNode = new Node(data);
        Node nextNode = prevNode.next;
        newNode.next = nextNode;
        newNode.prev = prevNode;
        prevNode.next = newNode;
        nextNode.prev = newNode;
    }

    // Delete a node from the start
    public void deleteFromStart() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.next == head) {
            head = null;
        } else {
            Node last = head.prev;
            head = head.next;
            head.prev = last;
            last.next = head;
        }
    }

    // Delete a node from the end
    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.next == head) {
            head = null;
        } else {
            Node last = head.prev;
            Node secondLast = last.prev;
            secondLast.next = head;
            head.prev = secondLast;
        }
    }

    // Delete a given node
    public void deleteNode(Node delNode) {
        if (head == null || delNode == null) {
            System.out.println("List is empty or node to be deleted is null.");
            return;
        }
        if (head == delNode && head.next == head) {
            head = null;
        } else {
            Node prevNode = delNode.prev;
            Node nextNode = delNode.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            if (delNode == head) {
                head = nextNode;
            }
        }
    }

    // Display the list
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data);
            temp = temp.next;
            if (temp != head) {
                System.out.print(" <-> ");
            }
        } while (temp != head);
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyCircularLinkedList dcList = new DoublyCircularLinkedList();

        dcList.insertAtStart(5);
        dcList.insertAtEnd(10);
        dcList.insertAtEnd(15);
        dcList.insertAtStart(0);

        Node secondNode = dcList.head.next; // Getting the second node
        dcList.insertAfter(secondNode, 7);

        System.out.println("List after insertions:");
        dcList.display();

        dcList.deleteFromStart();
        System.out.println("List after deleting from start:");
        dcList.display();

        dcList.deleteFromEnd();
        System.out.println("List after deleting from end:");
        dcList.display();

        dcList.deleteNode(dcList.head.next); // Deleting the second node
        System.out.println("List after deleting a node from the middle:");
        dcList.display();
    }
}

