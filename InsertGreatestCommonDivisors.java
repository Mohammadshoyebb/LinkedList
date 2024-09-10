class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class InsertGreatestCommonDivisors {

    // Helper function to calculate the Greatest Common Divisor (GCD) of two numbers
    private int gcd(int a, int b) {
        // Base case: If b becomes 0, then GCD is a
        return b == 0 ? a : gcd(b, a % b); // Recursively calculate GCD using Euclidean algorithm
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        // If the list has only one node, no pairs exist, so return the list as is
        if (head.next == null) {
            return head;
        }

        // Initialize two pointers: 'prev' points to the current node, and 'curr' points to the next node
        ListNode prev = head;
        ListNode curr = head.next;

        // Traverse the linked list until 'curr' becomes null (i.e., reach the end of the list)
        while (curr != null) {
            // Step 1: Calculate the GCD of the values in 'prev' and 'curr' nodes
            int divisor = gcd(prev.val, curr.val);

            // Step 2: Create a new node with the GCD value
            ListNode temp = new ListNode(divisor);

            // Step 3: Insert the GCD node between 'prev' and 'curr'
            prev.next = temp;  // 'prev' now points to the new GCD node
            temp.next = curr;  // GCD node points to 'curr'

            // Step 4: Move both 'prev' and 'curr' pointers forward
            prev = curr;      // Move 'prev' to the next original node
            curr = curr.next; // Move 'curr' to the next node
        }

        // Return the head of the modified linked list
        return head;
    }

    // Helper function to print the linked list (for testing)
    public void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Main function to test the solution
    public static void main(String[] args) {
        InsertGreatestCommonDivisors solution = new InsertGreatestCommonDivisors();

        // Example 1: Input = [18,6,10,3]
        ListNode head1 = new ListNode(18, new ListNode(6, new ListNode(10, new ListNode(3))));
        head1 = solution.insertGreatestCommonDivisors(head1);
        solution.printList(head1);  // Output: 18 6 6 2 10 1 3

        // Example 2: Input = [7]
        ListNode head2 = new ListNode(7);
        head2 = solution.insertGreatestCommonDivisors(head2);
        solution.printList(head2);  // Output: 7
    }
}

