# Exam 01 Practice - Java

## Concepts

> What is the time complexity of searching in a binary search tree?

- Average case (O(log n)): In a balanced BST, the height is O(log n) with respect to the number of nodes n.
- Worst case (O(n)): In a skewed BST, the tree behaves like a linked list.

> **BFS** is guaranteed to return the path with the fewest number of edges because it explores all nodes at the current level from the starting node before moving on to nodes that are farther away.

> **Alpha-beta pruning** is an optimization technique used for **minimax (adversarial) search**, which is commonly applied in two-player adversarial games (like chess, checkers, etc.).




## Intercalation (20pt, 16m)

**Intercalation**: In 1972, the esoteric programming language INTERCAL (short for "Compiler Language With No Pronounceable Acronym") introduced the previously-unknown "mingle" operator. "mingle" interleaves the bits of two numbers, putting the least-significant bit of its second argument in the least-significant bit of the result. Your task is to implement `mingle(a,b)` to interleave the low 16 bits of a and b and return the 32-bit result.

```
Input: 3(0011) 9(1001)
Output: 75(01001011)

b3 a3 b2 a2 b1 a1 b0 a0
1  1  0  1  0  0  1  1  = 01001011 = 75
```

Explanation: `mingle(abcd, efgh)` results in `aebfcgdh`, where each letter represents a bit.


```java
public class Intercalation {
    static int reverse16(int n) {
        int res = 0;
        for (int i = 0; i < 16; i++) {
            res = (res << 1) | (n & 1) ;
            n = n >>> 1;
        }
        return res;
    }

    public static int mingle(int a, int b) {
        int result = 0;

        for (int i = 0; i < 16; i++) {
            int bitB = (b >> i) & 1; // Get the bit of b
            result |= (bitB << (2 * i)); // Shift the bit of a to even positions

            int bitA = (a >> i) & 1; // Get the bit of a
            result |= (bitA << (2 * i + 1)); // Shift the bit of a to odd positions
        }

        return result;
    }
  
}
```





## Simple Bits (5pt, 1m)

**Simple Bits**: Complete the function to perform a bitwise negation of the given value.


```java

public class SimpleBits {
  public static int not(int value) {
      return ~value;  // Bitwise NOT
  }
}

```





## String Manipulation (12pt, 7m)

**String Manipulation**: We define an interrupted palindrome to be a string that is a palindrome (equal to its reversed version) after removing any characters which are not letters (a-z).

Implement the function `interruptedPalindrome` to determine whether a string is an interrupted palindrome. It is given a string and returns a boolean indicating whether that string is an interrupted palindrome.

```
Input: "$a ba"
Output: True

"$a ba" -> "aba"
```

```java
public class Palindrome {
  public static boolean interruptedPalindrome(String s) {
      // Step 1: Remove all non-alphabetic characters and convert to lowercase
      StringBuilder filtered = new StringBuilder();
      for (char c : s.toCharArray()) {
          if (Character.isLetter(c)) {
              filtered.append(Character.toLowerCase(c));
          }
      }

      // Step 2: Check if the filtered string is a palindrome
      String cleanString = filtered.toString();
      String reversedString = filtered.reverse().toString();
      
      // Step 3: Return true if the filtered string equals its reverse
      return cleanString.equals(reversedString);
  }


  public static void main(String[] args) {
    System.out.println(interruptedPalindrome("a ba"));
  }
}
```





## Linked-List Manipulation (24pt, 12m)

**Linked-List Manipulation**: We needed to implement a merge sort for linked lists, but ran out of time. Complete the function `split`, which takes a linked list and splits it into as nearly equal as possible halves (if the number of nodes in the list is odd, put the longer part in index 0 of the returned array). The two elements of the returned array should reference the head node of each of the two resulting lists.

```
Input: 1 -> 2 -> 3

Output:
    parts[0] = 1 -> 2
    parts[1] = 3
```


```java
import lib.Node;

import lib.Node;

public class ListMerge {

    public static Node[] split(Node list) {
        if (list == null) {
            return new Node[]{null, null};
        }
        
        int len = 0;
        Node curr = list;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        
        int mid = (len + 1) / 2;
        curr = list;
        Node prev = null;
        
        for (int i = 0; i < mid; i++) {
            prev = curr;
            curr = curr.next;
        }
        
        if (prev != null) {
            prev.next = null;
        }
        
        return new Node[]{list, curr};
    }

}
```

```java

import lib.Node;

public class ListMerge {

    public static Node[] split(Node list) {
        if (list == null || list.next == null) {
            return new Node[]{list, null};  // If there's one or no node, no split is needed
        }

        // Initialize slow and fast pointers
        Node slow = list;
        Node fast = list;
        Node prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev != null) {
            prev.next = null;
        }

        return new Node[]{list, slow};
    }
}
```
