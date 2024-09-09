/*
 
2326. Spiral Matrix IV
Medium
Topics
Companies
You are given two integers m and n, which represent the dimensions of a matrix.

You are also given the head of a linked list of integers.

Generate an m x n matrix that contains the integers in the linked list presented in spiral order (clockwise), starting from the top-left of the matrix. If there are remaining empty spaces, fill them with -1.

Return the generated matrix.

 

Example 1:


Input: m = 3, n = 5, head = [3,0,2,6,8,1,7,9,4,2,5,5,0]
Output: [[3,0,2,6,8],[5,0,-1,-1,1],[5,2,4,9,7]]
Explanation: The diagram above shows how the values are printed in the matrix.
Note that the remaining spaces in the matrix are filled with -1.
Example 2:


Input: m = 1, n = 4, head = [0,1,2]
Output: [[0,1,2,-1]]
Explanation: The diagram above shows how the values are printed from left to right in the matrix.
The last space in the matrix is set to -1.
 

Constraints:

1 <= m, n <= 10^5
1 <= m * n <= 10^5
The number of nodes in the list is in the range [1, m * n].
0 <= Node.val <= 1000

 */
public class SpiralMatrixIV {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        // Initialize the matrix and fill it with -1 as a placeholder for empty cells
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = -1;
            }
        }

        // Set boundaries for the spiral traversal
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        ListNode current = head;

        // Traverse the matrix in spiral order and populate values from the linked list
        while (current != null) {
            // Fill the top row
            for (int i = left; i <= right && current != null; i++) {
                matrix[top][i] = current.val;
                current = current.next;
            }
            top++; // Move the top boundary down

            // Fill the right column
            for (int i = top; i <= bottom && current != null; i++) {
                matrix[i][right] = current.val;
                current = current.next;
            }
            right--; // Move the right boundary left

            // Fill the bottom row
            for (int i = right; i >= left && current != null; i--) {
                matrix[bottom][i] = current.val;
                current = current.next;
            }
            bottom--; // Move the bottom boundary up

            // Fill the left column
            for (int i = bottom; i >= top && current != null; i--) {
                matrix[i][left] = current.val;
                current = current.next;
            }
            left++; // Move the left boundary right
        }

        // Return the resulting matrix
        return matrix;
    }

    // Helper class for ListNode definition
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // Main method to test the function
    public static void main(String[] args) {
        SpiralMatrixIV solution = new SpiralMatrixIV();

        // Example 1
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(0);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(6);
        head1.next.next.next.next = new ListNode(8);
        head1.next.next.next.next.next = new ListNode(1);
        head1.next.next.next.next.next.next = new ListNode(7);
        head1.next.next.next.next.next.next.next = new ListNode(9);
        head1.next.next.next.next.next.next.next.next = new ListNode(4);
        head1.next.next.next.next.next.next.next.next.next = new ListNode(2);
        head1.next.next.next.next.next.next.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next.next.next.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(0);

        int[][] result1 = solution.spiralMatrix(3, 5, head1);
        for (int[] row : result1) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        // Example 2
        ListNode head2 = new ListNode(0);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(2);

        int[][] result2 = solution.spiralMatrix(1, 4, head2);
        for (int[] row : result2) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

