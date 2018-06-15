# Algorithms & Data Structures Exam Prep

## Recursion

Bad Recursion BRB

Fibonacci numbers using recursion.

```java
public int fibo1(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibo1(n - 1) + fibo1(n - 2);
        }
    }
```

## Analysis

Time, Memory, Scalability, Big-O, Union-Find Case

##### Big-O:

| Name         | Description        | Order of Growth | Example           |
| ------------ | ------------------ | --------------- | ----------------- |
| Constant     | Statement          | 1               | Add two numbers   |
| Logarithmic  | Divide in half     | LogN            | Binary Search     |
| Linear       | Loop               | N               | Find the maximum  |
| Linearithmic | Divide and conquer | NlogN           | Mergesort         |
| Quadradic    | Double loop        | N^2             | Check all pairs   |
| Cubic        | Triple loop        | N^3             | Check all triples |
| Exponential  | Exhaustive Search  | 2^N             | Check all subsets |

##### Memory:

| type    | bytes |
| ------- | ----- |
| boolean | 1     |
| byte    | 1     |
| char    | 2     |
| int     | 4     |
| float   | 4     |
| long    | 8     |
| double  | 8     |



## Data Structure

##### Bag:

A bag is a collection where removing items is not supported—its purpose is to provide clients with the ability to collect items and then to iterate through the collected items (the client can also test if a bag is empty and find its number of items). 

add, isEmpty, size

##### Queue:

A FIFO queue (or just a queue) is a collection that is based on the first-in-first-out (FIFO) policy. The policy of doing tasks in the same order that they arrive is one that we encounter frequently in everyday life: from people waiting in line at a theater, to cars waiting in line at a toll booth.

enqueue, dequeue, isEmpty, size

##### Stacks:

A pushdown stack (or just a stack) is a collection that is based on the last-in-first-out (LIFO) policy. When you keep your mail in a pile on your desk, you are using a stack. You pile pieces of new mail on the top when they arrive and take each piece of mail from the top when you are ready to read it.  

push, pop, isEmpty, size



##### Array/Linked Lists:

**Definition**. A linked list is a recursive data structure that is either empty (null) or a reference to a node having a generic item and a reference to a linked list.  

```java
private class Node {
 Item item;
 Node next;
}
```

| Data Structure | Advantage                                   | Disadvantage                        |
| -------------- | ------------------------------------------- | ----------------------------------- |
| Array          | index provides immediate access to any item | need to know size on initialization |
| Linked List    | Uses space proportional to size             | need reference to access an item    |



#### Elementary Sorts:

##### Selection sort:

One of the simplest sorting algorithms works as follows: First, find the smallest item in the array and exchange it with the first entry (itself if the first entry is already the smallest). Then, find the next smallest item and exchange it with the second entry. Continue in this way until the entire array is sorted. This method is called selection sort because it works by **repeatedly selecting the smallest remaining item**. 

##### Insertion sort:

The algorithm that people often use to sort bridge hands is to consider the cards one at a time, **inserting each into its proper place among those already considered** (keeping them sorted). 

##### Shell sort:



## Merge & Quick Sort

## Sorting and Searching

## Search Trees

## Hash Tables

## Swarms

## Undirected Graphs

## Directed Graphs

## Minimum Spanning Tree

## Shortest Path