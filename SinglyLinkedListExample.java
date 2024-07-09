import java.util.LinkedList;

public class SinglyLinkedListExample {
    public static void main(String[] args) {
        // Creating a LinkedList
        LinkedList<Integer> list = new LinkedList<>();

        // Insertion
        list.add(1); // Adds to the end
        list.add(2);
        list.add(3);
        list.addFirst(0); // Adds to the beginning
        list.addLast(4); // Adds to the end

        System.out.println("List after insertions: " + list);

        // Deletion
        list.removeFirst(); // Removes the first element
        list.removeLast(); // Removes the last element
        list.remove(1); // Removes the element at index 1

        System.out.println("List after deletions: " + list);
    }
}

