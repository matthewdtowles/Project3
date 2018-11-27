/**
 * File: Sequence.java
 * Author: Matthew Towles
 * Date: 11/25/2018
 * Purpose: Utility class representing a number sequence and methods
 *          to compute corresponding element in sequence
 */
package project3;

/**
 * Number sequence: next number is [(2 * current) + previous]
 * 
 * E.g.:  [0, 1, 2, 5, 12, 29, 70, ... ]
 * @author matthew.towles
 */
public class Sequence {
    
    // number of calculations made
    private static int efficiencyCounter;
    
    
    /**
     * Returns corresponding element in sequence using iteration
     * @param n
     * @return current - the nth element
     */
    public static int computeIterative(int n) {
        
        // prev2 = number before prev1
        // prev1 = number before current
        // current = current number in sequence
        int prev2, prev1, current;
        prev2 = prev1 = current = 0;
        
        // initialize efficiencyCounter 
        Sequence.initCounter();
        
        for (int i = 0; i < n; i++) {
            // save the number from 2 iterations ago
            prev2 = prev1;
            // save number from last iteration - used in next iteration
            prev1 = current;
            // calculate current number in sequence:
            current *= 2; // multiply itself by 2
            current += prev2; // add number from 2 iterations ago
            
            // base case - need to add 1 to current
            if (current == 0) {
                current++;
            }
            
            // keep track of iterations with efficiency counter
            Sequence.efficiencyCounter++;
        }
        return current;
    }
    
    
    /**
     * Returns corresponding element in sequence using recursion
     * This is a helper method
     * Used to initialize the efficiency counter
     * Then calls recursive method to perform actual computation
     * 
     * @param n
     * @return the nth element
     */
    public static int computeRecursive(int n) {
        // initialize the sequence counter
        Sequence.initCounter();
        
        // call the actual recursive function
        return Sequence.recursive(n);
    }
    
    
    /**
     * Returns corresponding element in sequence with recursion
     * This is the actual recursive algorithm
     * This should only be called by computeRecursive!!!
     * 
     * @param n
     * @return 
     */
    private static int recursive(int n) {
        // keep track of iterations with efficiency counter
        Sequence.efficiencyCounter++;
        // base case:
        if (n < 2) {
            // nth number same as n if 0 or 1
            return n;
        }
        // recursive call for previous and number before previous 
        return (2 * recursive(n - 1) + recursive(n - 2));
    }
    
    
    /**
     * Initialize efficiency counter to 0
     * Called by any method using efficiencyCounter
     */
    private static void initCounter() {
        efficiencyCounter = 0;
    }
    
    
    // getters:
    
    public static int getEfficiency() {
        return efficiencyCounter;
    }
    
    

    
}
