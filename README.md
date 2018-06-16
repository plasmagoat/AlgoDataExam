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

**Big-O notation** is used in Computer Science to describe the performance or complexity of an algorithm. **Big-O** specifically describes the worst-case scenario, and can be used to describe the execution time required or the space used (e.g. in memory or on disk) by an algorithm. 

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

A bag is a collection where removing items is not supported—its purpose is to provide clients with the ability to **collect items and then to iterate through the collected items** (the client can also test if a bag is empty and find its number of items). 

add, isEmpty, size

##### Queue:

A FIFO queue (or just a queue) is a collection that is based on the first-in-first-out (**FIFO**) policy. The policy of doing tasks in the **same order that they arrive** is one that we encounter frequently in everyday life: from people waiting in line at a theater, to cars waiting in line at a toll booth.

enqueue, dequeue, isEmpty, size

##### Stacks:

A pushdown stack (or just a stack) is a collection that is based on the last-in-first-out (**LIFO**) policy. When you keep your mail in a pile on your desk, you are using a stack. You pile pieces of new mail on the top when they arrive and take each piece of mail from the top when you are ready to read it.  

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

best case: *½n^2*

worst case: *½n^2* 

One of the simplest sorting algorithms works as follows: First, find the smallest item in the array and exchange it with the first entry (itself if the first entry is already the smallest). Then, find the next smallest item and exchange it with the second entry. Continue in this way until the entire array is sorted. This method is called selection sort because it works by **repeatedly selecting the smallest remaining item**. 

##### Insertion sort:

best case: *n*

worst case: *½n^2* 

The algorithm that people often use to sort bridge hands is to consider the cards one at a time, **inserting each into its proper place among those already considered** (keeping them sorted). 

##### Shell sort:

Shellsort is a simple extension of insertion sort that gains speed by allowing exchanges of entries that are far apart, to produce partially sorted arrays that can be efficiently sorted, eventually by insertion sort. The idea is to rearrange the array to give it the property that taking every *h*th entry (starting anywhere) yields a sorted sequence. Such an array is said to be *h-sorted*. 

> Why not use selection sort for h-sorting in shellsort?
>
> *Solution.* Insertion sort is faster on inputs that are partially-sorted.

## Merge & Quick Sort

#### Merge Sort:

worst case: *n log n*

best case: *½ n log n*

A simple recursive sort method known as *mergesort*: to sort an array, divide it into two halves, sort the two halves (recursively), and then merge the results. 

Mergesort guarantees to sort an array of N items in time proportional to N log N, no matter what the input. Its prime disadvantage is that it uses extra space proportional to N.

##### Abstract in-place merge. 

##### Top-down mergesort. 

Split into 2 halves, and run merge sort on each half recursively. 

##### Bottom-up mergesort. 

Split array into smallest subarrays (length = 2) and sort, then merge, then increase subarray size.



#### Quick Sort:

**Worst case**: *n^2* (/2 ???)

Pivot happens to be biggest or smallest, this would mean doing *n-1* comparisons,

and breaking the list up *n* times

> The standard deviation of the running time is about .65 N, so the running time tends to the average as N grows and is unlikely to be far from the average. The probability that quicksort will use a quadratic number of compares when sorting a large array on your computer is much less than the probability that your computer will be struck by lightning!

**Best case**: *O(n log n)* 

*n* because we have to do *n-1* comparisons,

and log n because we divide the list *n* times

**The basic algorithm. **Quicksort is a divide-and-conquer method for sorting. It works by partitioning an array into two parts, then sorting the parts independently.

 Quicksort works by:

   

- First selecting a *pivot* number in the array,
- Then sorting the other numbers by placing them before or after the pivot number respectively.
- At this point, the pivot number is in the correct location, and the two groups of numbers (one on each side of the pivot number) still need to be sorted.
- New pivot numbers are then chosen within the remaining subsets, and this process is repeated until no swaps are made.

**Improving**: To insure that the pivot isn't the biggest or smallest, pick a pivot of multiple items and choose the median value to be the pivot.

> - *Cutoff to insertion sort.* As with mergesort, it pays to switch to insertion sort for tiny arrays. The optimum value of the cutoff is system-dependent, but any value between 5 and 15 is likely to work well in most situations.
> - *Median-of-three partitioning.* A second easy way to improve the performance of quicksort is to use the median of a small sample of items taken from the array as the partitioning item. Doing so will give a slightly better partition, but at the cost of computing the median. It turns out that most of the available improvement comes from choosing a sample of size 3 (and then partitioning on the middle item).

## Sorting and Searching

Priority queues

Symbol tables

## Search Trees



## Hash Tables

Symbol table applications

 

## Swarms



## Undirected Graphs

Depth first, breadth first, connection

 

## Directed Graphs

Digraphs

Cycles, connection, reachability

## Minimum Spanning Tree



## Shortest Path

A* algorithm

 