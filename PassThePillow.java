/**
* 2582. Pass the Pillow
* There are n people standing in a line labeled from 1 to n. The first person in the line is holding a pillow initially.
* Every second, the person holding the pillow passes it to the next person standing in the line.
* Once the pillow reaches the end of the line, the direction changes, and people continue passing the pillow in the opposite direction.
*
* Given the two positive integers n and time, return the index of the person holding the pillow after time seconds.
*
* Example 1:
* Input: n = 4, time = 5
* Output: 2
* Explanation: People pass the pillow in the following way: 1 -> 2 -> 3 -> 4 -> 3 -> 2.
* After five seconds, the 2nd person is holding the pillow.
*
* Example 2:
* Input: n = 3, time = 2
* Output: 3
* Explanation: People pass the pillow in the following way: 1 -> 2 -> 3.
* After two seconds, the 3rd person is holding the pillow.
*
* Constraints:
* - 2 <= n <= 1000
* - 1 <= time <= 1000
*/

public class PassThePillow {
   
   // Optimized approach
   public int passThePillow(int n, int time) {
       // Calculate the total number of rounds completed
       int totalRounds = time / (n - 1);
       
       // Determine if the current direction is reversed
       boolean reverseDirection = (totalRounds % 2 != 0);
       
       if (reverseDirection) {
           // Calculate the position when moving in reverse direction
           return (n - (time % (n - 1)));
       } else {
           // Calculate the position when moving in forward direction
           return (time % (n - 1)) + 1;
       }
   }

   // Brute-force approach
   public int passThePillowBruteForce(int n, int time) {
       int pillowPosition = 1;
       int currentTime = 0;
       boolean revDirection = false;

       while (currentTime < time) {
           if (!revDirection) {
               pillowPosition++;
           } else {
               pillowPosition--;
           }

           // Check if direction needs to be reversed
           if (pillowPosition == 1 || pillowPosition == n) {
               revDirection = !revDirection;
               currentTime++;
           }
       }

       return pillowPosition;
   }

   public static void main(String[] args) {
       PassThePillow solution = new PassThePillow();

       // Test examples using optimized approach
       int n1 = 4, time1 = 5;
       System.out.println("Optimized Approach: Person holding the pillow after " + time1 + " seconds in line of " + n1 + " people: " + solution.passThePillow(n1, time1)); // Output: 2

       int n2 = 3, time2 = 2;
       System.out.println("Optimized Approach: Person holding the pillow after " + time2 + " seconds in line of " + n2 + " people: " + solution.passThePillow(n2, time2)); // Output: 3

       // Test examples using brute-force approach
       System.out.println("\nBrute-force Approach:");
       System.out.println("Person holding the pillow after " + time1 + " seconds in line of " + n1 + " people: " + solution.passThePillowBruteForce(n1, time1)); // Output: 2
       System.out.println("Person holding the pillow after " + time2 + " seconds in line of " + n2 + " people: " + solution.passThePillowBruteForce(n2, time2)); // Output: 3
   }
}
