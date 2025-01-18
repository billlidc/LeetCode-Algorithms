# Java Syntax

## Table of Contents

1. [String](#string)
2. [Character](#character)
3. [Type Conversion](#type-conversion)
4. [Array](#arrays)
5. [ArrayList](#arraylist)
6. [Collections](#collections)
7. [HashMap](#hashmap)
8. [HashSet](#hashset)

## String

> No imports needed for `String`

```java
String str = "Hello World";

int length = str.length();

String upper = str.toUpperCase();
String lower = str.toLowerCase();

boolean contains = str.contains("World");

char ch = str.charAt(1);

String[] parts = str.split(" ");

String sub = str.substring(6);
String sub2 = str.substring(0, 5);
String replaced = str.replace('o', 'a');
```

## Character

> No imports needed for `Character`

```java
char ch = 'A';

char lowerCh = Character.toLowerCase(ch);
char upperCh = Character.toUpperCase(ch);

boolean isLetter = Character.isLetter(ch);
boolean isDigit = Character.isDigit(ch);
boolean isWhitespace = Character.isWhitespace(' ');
```

## Type Conversion

```java
// List -> String Array
List<String> list = new ArrayList<>();
String[] array = list.toArray(new String[0]);

// String -> Char Array
char[] chars = str.toCharArray();

// Char Array -> String
String s = String.valueOf(chars);

// Char -> String
String s1 = String.valueOf(ch);
String s2 = Character.toString(ch);

// Integer -> String
String s1 = String.valueOf(num);
String s2 = Integer.toString(num);

// String -> Integer
int num1 = Integer.valueOf(strNum);
int num2 = Integer.parseInt(strNum);
```

## Arrays

> `import java.util.Arrays;`

```java
int[] arr = {1, 2, 3, 4, 5};
int[] arr = new int[] {1, 2, 3, 4, 5};
```

```java
int length = arr.length;

boolean areEqual = Arrays.equals(array1, array2);

System.out.println(Arrays.toString(array));

Arrays.sort(arr);

// Copy(1)
int[] copied = Arrays.copyOf(srcArr, length);

// Copy(2)
System.arraycopy(srcArr, srcIdx, desArr, desIdx, length);

// Copy(3)
int[] cloned = array.clone();
```

## ArrayList

> `import java.util.ArrayList;`

```java
ArrayList<String> al = new ArrayList<>();

ArrayList<Integer> al = new ArrayList<>(Arrays.asList(1, 2, 3));

List<Integer> list = Arrays.asList(4, 5, 6);
ArrayList<Integer> al = new ArrayList<>(list);
```

```java
boolean hasMango = al.contains("Mango");

int size = al.size();

String fruit = al.get(0);

al.add("Apple");

al.set(1, "Mango");

al.remove("Apple");
```

## Collections

> `import java.util.Collections;`

```java
// Can be applied to both List and ArrayList
Collections.sort(list);

Collections.reverse(list);

Collections.shuffle(list);

int min = Collections.min(list);
int max = Collections.max(list);
```

### `Comparable` and `Comparator`

```java
/* Method 1 */
public class Card implements Comparable<Card> {
    private String suit;
    private int rank;

    @Override
    public int compareTo(Card other) {
        return Integer.compare(rank, other.rank);  // Compares cards by rank
    }
}

Collections.sort(cards);  // Uses the `compareTo` method

/* Method 2 */
public class CompareBySuit implements Comparator<Card> {
    @Override
    public int compare(Card x, Card y) {
        return x.getSuit().compareToIgnoreCase(y.getSuit());
    }
}

Collections.sort(cards, new CompareBySuit());

/* Method 3 */
Collections.sort(cards, new CompareBySuitRank() {
    @Override
    public int compare(Card x, Card y) {
        int suitResult = x.getSuit().compareToIgnoreCase(y.getSuit());
        if (suitResult != 0) {
            return suitResult;
        }
        return Integer.compare(x.getRank(), y.getRank());
    }
});
```

## HashMap

> `import java.util.HashMap;`\
> `import java.util.Map;`

```java
HashMap<String, Integer> map = new HashMap<>();

map.put("John", 25);
map.put("Anna", 30);

int age = map.get("John");

boolean hasJohn = map.containsKey("John");

boolean hasAge30 = map.containsValue(30);

map.remove("Anna");
```

```java
for (String key : map.keySet()) {
    System.out.println("Key: " + key);
}

for (Integer value : map.values()) {
    System.out.println("Value: " + value);
}

import java.util.Map.Entry;
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}
```

### HashMap as Counter

```java
HashMap<Integer, Integer> itemCount = new HashMap<>();

// Iterate through the list and update count in the map
for (int i : list) {
    itemCount.put(i, itemCount.getOrDefault(i, 0) + 1);
}

// Print the counter
for (int key : itemCount.keySet()) {
    System.out.println(key + ": " + itemCount.get(key));
}
```

## HashSet

> `import java.util.HashSet;`

```java
HashSet<String> set = new HashSet<>();

set.add("Cat");
set.add("Dog");

boolean hasDog = set.contains("Dog");

int size = set.size();

set.remove("Cat");
```

```java
for (String s : set) {
    System.out.println(s);
}
```
