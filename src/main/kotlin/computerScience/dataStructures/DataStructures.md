# Data Structures

## Array

The basic structure for collections, it strongly relates to how memory is organized.
An array is a collection of items of same data type and memory size, stored at contiguous memory locations.

This makes it easier to calculate the position of each element in the array by simply adding an offset to a base value.
The base value is the location of the array on memory, so the first element of the array will be in this position. For most programming languages, the base value is index 0 and the difference between the two indexes is the offset.

Example: Let’s say that an array starts at position 1024 in your memory, and you need to find the element at index 100 in the array.
You also know that each element takes 4 positions (an array reserves constant space for its elements, which in most cases is the size of the memory reference). 
This is an easy problem: our element starts at the position 1024 + 100 * 4 = 1424. 
Accessing an element at a certain position is a very simple and efficient operation, which is a big advantage of using arrays.

### Speed of Operations

In number of steps

#### Reading

Just one step, because the computer can jump to any particular index in the array.

#### Searching

Depends on the algorithm that we are using and the characteristics of the content in the array (sorted or not).
But for now let's think about linear search. And this search can be from 1 step (the value is in the first index), or N steps, where N is the size of the array (when the value is in the last index)

#### Inserting

Depends on where the new element is inserted. If it'll be inserted in the last position, then it is only one step (the array must have space, otherwise will be N + 1 steps).
The worst case is when we want to insert in the first position, because we need to shift every element to the right and then insert. (N + 1 steps)

#### Deleting

Same as Inserting (the elements are shifted left instead of right)

### In Kotlin

Using arrays directly is harder than using other kinds of collections. 
They have a constant size, a limited number of operations, they do not implement any interface, and they **do not override the toString, equals or hashCode methods. 
However, arrays are used by many other data structures under the hood. For instance, when you use mutableListOf on Kotlin/JVM, the result object is ArrayList, which keeps elements in an array. 
This is why finding an element at an index in the default list is so efficient. 
So, ArrayList has the advantages of arrays, but it offers much more. 
Arrays have a constant size, so you cannot add more elements than their size allows. When you add an element to an ArrayList and its internal array is full already, it creates a bigger one and fills it with the previous values. 

Arrays are also used by the default Set and Map that we use in Kotlin. Both are based on a hash table algorithm that needs to use an array to work efficiently.

Based mainly on Kotlin Essentials - Marcin Moskała

## List 

### In Kotlin

Represents an ordered list of elements. It is built on top of Arrays, so it has all the features and extends adding some, like overriding toString, equals or hashCode methods, so you can compare Lists   

## Differences between Arrays and Lists

Usually, we restrict the usage of arrays to performance-critical parts of our applications, because arrays are optimized for primitives.

## Linked List

A sequence of elements (nodes) connected by pointers (one node points to the next node). Each node contains two components: data (it's value) and a reference to the next node in the sequence.

Benefits against Arrays -> the elements doesn't need to be consecutive in memory, the is no fixed size and there can be different value types in the same linked list. The insertion and deletion are more efficient.

Disadvantage -> It is not iterable and all the consequences of it (only linear search, for example). A value in the middle cannot be accessed directly. It requires more memory compared to arrays and its implementation is more complex. 

### Speed of Operations

In number of steps

#### Reading

Worst case read of O(N) because to read the last node we have to start from the first node (the only one we have access initially), and follow the chain of nodes until we reach the final node.

#### Searching

O(N). Similar to reading, to search for a value we have to start in the first node and follow the links of each node to next one.

#### Inserting

In the beginning of the list it only takes one step to insert (We just create the node, links it to the head of the list and then update the head to be the new node.)

If it is not in the beginning, the worst case scenario is inserting on tail (last node), because we have to read every node until we hit the end to insert the new node

#### Deleting

Same as Inserting.

### In Kotlin

There is no implementation of a Linked List in native Kotlin.
You can implement it like:

//data class ListNode<T>(var value: T) {
//    var next: ListNode<T>? = null;
//}

## Set

--

A lot of data structures are based on Arrays.
Set is one of those cases. The simplest Set based on Array is overriding its insert method, making it search the entire data structure and only inserting if the value is not found


## HashMap
## Map