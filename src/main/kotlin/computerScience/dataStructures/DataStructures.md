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

### In Kotlin

Using arrays directly is harder than using other kinds of collections. 
They have a constant size, a limited number of operations, they do not implement any interface, and they do not override the toString, equals or hashCode methods. 
However, arrays are used by many other data structures under the hood. For instance, when you use mutableListOf on Kotlin/JVM, the result object is ArrayList, which keeps elements in an array. 
This is why finding an element at an index in the default list is so efficient. 
So, ArrayList has the advantages of arrays, but it offers much more. 
Arrays have a constant size, so you cannot add more elements than their size allows. When you add an element to an ArrayList and its internal array is full already, it creates a bigger one and fills it with the previous values. 
Usually, we restrict the usage of arrays to performance-critical parts of our applications

Arrays are also used by the default Set and Map that we use in Kotlin. Both are based on a hash table algorithm that needs to use an array to work efficiently.

Based mainly on Kotlin Essentials - Marcin Moskała