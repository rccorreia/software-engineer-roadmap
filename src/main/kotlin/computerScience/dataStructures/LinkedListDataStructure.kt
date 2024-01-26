package com.github.rccorreia.computerScience.dataStructures

import java.math.BigInteger

data class ListNode<T>(var value: T) {
    var next: ListNode<T>? = null;
}

class LinkedListDataStructure {

//    Question: Create a function that reverts the linked list.

    fun revertLinkedList(l: ListNode<Int>?): ListNode<Int>? {
        if (l?.next == null) return l

        var prevNode: ListNode<Int>? = null
        var currentNode: ListNode<Int>? = l
        var nextNode: ListNode<Int>? = null

        while (currentNode != null){
            nextNode = currentNode.next

            currentNode.next = prevNode

            prevNode = currentNode
            currentNode = nextNode
        }

        return prevNode
    }


//    Question: Remove a Node from the linked list without having access to its previous node in the chain

    fun removeNodeWithoutPrevious(l: ListNode<Int>?): ListNode<Int>? {
        if (l!!.next == null) return null

        l.value = l.next!!.value
        l.next = l.next!!.next

        return l
    }

//    Question: removeKFromList
//    Note: Try to solve this task in O(n) time using O(1) additional space, where n is the number of elements in the list, since this is what you'll be asked to do during an interview.
//
//    Given a singly linked list of integers l and an integer k, remove all elements from list l that have a value equal to k.
//
//    Example
//
//    For l = [3, 1, 2, 3, 4, 5] and k = 3, the output should be
//    solution(l, k) = [1, 2, 4, 5];
//    For l = [1, 2, 3, 4, 5, 6, 7] and k = 10, the output should be
//    solution(l, k) = [1, 2, 3, 4, 5, 6, 7].
//    Input/Output
//
//    [execution time limit] 3 seconds (kt)
//
//    [memory limit] 1 GB
//
//    [input] linkedlist.integer l
//
//    A singly linked list of integers.
//
//    Guaranteed constraints:
//    0 ≤ list size ≤ 105,
//    -1000 ≤ element value ≤ 1000.
//
//    [input] integer k
//
//    An integer.
//
//    Guaranteed constraints:
//    -1000 ≤ k ≤ 1000.
//
//    [output] linkedlist.integer
//
//    Return l with all the values equal to k removed.

    fun removeKFromList(l: ListNode<Int>?, k: Int): ListNode<Int>? {
        var copyL = l
        var keepGoing = true

        while (keepGoing) {
            if (copyL == null) keepGoing = false

            if (copyL?.next?.value == k){
                copyL.next = copyL.next?.next
            } else {
                copyL = copyL?.next
            }
        }

        return if (l?.value == k) l.next else l
    }

//    Question: isListPalindrome
//    Note: Try to solve this task in O(n) time using O(1) additional space, where n is the number of elements in l, since this is what you'll be asked to do during an interview.
//
//    Given a singly linked list of integers, determine whether it's a palindrome.
//
//    Note: in examples below and tests preview linked lists are presented as arrays just for simplicity of visualization: in real data you will be given a head node l of the linked list
//
//    Example
//
//    For l = [0, 1, 0], the output should be
//    solution(l) = true;
//
//    For l = [1, 2, 2, 3], the output should be
//    solution(l) = false.
//
//    Input/Output
//
//    [execution time limit] 3 seconds (kt)
//
//    [memory limit] 1 GB
//
//    [input] linkedlist.integer l
//
//    A singly linked list of integers.
//
//    Guaranteed constraints:
//    0 ≤ list size ≤ 5 · 105,
//    -109 ≤ element value ≤ 109.
//
//    [output] boolean
//
//    Return true if l is a palindrome, otherwise return false.

    // USING MORE SPACE:
    // fun isListPalindrome(l: ListNode<Int>?): Boolean {
    //     var copyL = l
    //     val sequence: MutableList<Int> = mutableListOf()

    //     while (copyL != null){
    //         sequence.add(copyL.value)
    //         copyL = copyL.next
    //     }

    //     return sequence == sequence.reversed()
    // }

    fun isListPalindrome(l: ListNode<Int>?): Boolean {
        fun reverseNodesList(l: ListNode<Int>?): ListNode<Int>? {
            if (l == null) return null
            var head = l
            var cur = head!!.next
            while (true) {
                if (cur == null) return head
                val tail = cur.next
                cur.next = head
                head = cur
                cur = tail
            }
        }

        if (l?.next == null) return true

        var len = 0
        var head = l
        var left = l

        while(head != null) {
            len += 1
            head = head!!.next
        }

        head = l

        for(i in 0 until len / 2) head = head!!.next
        if (len % 2 == 1) head = head!!.next

        var right = reverseNodesList(head)

        for(i in 0 until len / 2) {
            if(left!!.value != right!!.value) return false
            left = left.next
            right = right.next
        }
        return true
    }

    // Question: addTwoHugeNumbers
//    You're given 2 huge integers represented by linked lists. Each linked list element is a number from 0 to 9999 that represents a number with exactly 4 digits. The represented number might have leading zeros. Your task is to add up these huge integers and return the result in the same format.
//
//    Example
//
//    For a = [9876, 5432, 1999] and b = [1, 8001], the output should be
//    solution(a, b) = [9876, 5434, 0].
//
//    Explanation: 987654321999 + 18001 = 987654340000.
//
//    For a = [123, 4, 5] and b = [100, 100, 100], the output should be
//    solution(a, b) = [223, 104, 105].
//
//    Explanation: 12300040005 + 10001000100 = 22301040105.
//
//    Input/Output
//
//    [execution time limit] 3 seconds (kt)
//
//    [memory limit] 1 GB
//
//    [input] linkedlist.integer a
//
//    The first number, without its leading zeros.
//
//    Guaranteed constraints:
//    0 ≤ a size ≤ 104,
//    0 ≤ element value ≤ 9999.
//
//    [input] linkedlist.integer b
//
//    The second number, without its leading zeros.
//
//    Guaranteed constraints:
//    0 ≤ b size ≤ 104,
//    0 ≤ element value ≤ 9999.
//
//    [output] linkedlist.integer
//
//    The result of adding a and b together, returned without leading zeros in the same format.

    fun addTwoHugeNumbers(a: ListNode<Int>?, b: ListNode<Int>?): ListNode<Int>? {
        val numbersListA: MutableList<Int> = mutableListOf()
        val numbersListB: MutableList<Int> = mutableListOf()
        var copyA = a
        var copyB = b

        while (copyA != null){
            numbersListA.add(copyA.value)
            copyA = copyA.next
        }

        while (copyB != null){
            numbersListB.add(copyB.value)
            copyB = copyB.next
        }

        val firstBigNumber: BigInteger = numbersListA.joinToString("") { it.toString().padStart(4, '0') }.toBigInteger()
        val secondBigNumber: BigInteger = numbersListB.joinToString("") { it.toString().padStart(4, '0') }.toBigInteger()
        var result: String = (firstBigNumber + secondBigNumber).toString()

        if (result.length % 4 != 0) result = result.padStart(result.length + (4 - result.length % 4), '0')

        val resultSliced: MutableList<Int> = mutableListOf()

        for (i in 0 until result.length step 4) {
            resultSliced.add(result.slice(i..i+3).toInt())
        }

        var r: ListNode<Int>? = ListNode(0)
        val copyR = r

        for (resultNumber in resultSliced){
            val nextR = ListNode(resultNumber)
            r!!.next = nextR
            r = r.next
        }

        return copyR!!.next
    }

    // Question mergeTwoLinkedLists
//    Note: Your solution should have O(l1.length + l2.length) time complexity, since this is what you will be asked to accomplish in an interview.
//
//    Given two singly linked lists sorted in non-decreasing order, your task is to merge them. In other words, return a singly linked list, also sorted in non-decreasing order, that contains the elements from both original lists.
//
//    Example
//
//    For l1 = [1, 2, 3] and l2 = [4, 5, 6], the output should be
//    solution(l1, l2) = [1, 2, 3, 4, 5, 6];
//    For l1 = [1, 1, 2, 4] and l2 = [0, 3, 5], the output should be
//    solution(l1, l2) = [0, 1, 1, 2, 3, 4, 5].
//    Input/Output
//
//    [execution time limit] 3 seconds (kt)
//
//    [memory limit] 1 GB
//
//    [input] linkedlist.integer l1
//
//    A singly linked list of integers.
//
//    Guaranteed constraints:
//    0 ≤ list size ≤ 104,
//    -109 ≤ element value ≤ 109.
//
//    [input] linkedlist.integer l2
//
//    A singly linked list of integers.
//
//    Guaranteed constraints:
//    0 ≤ list size ≤ 104,
//    -109 ≤ element value ≤ 109.
//
//    [output] linkedlist.integer
//
//    A list that contains elements from both l1 and l2, sorted in non-decreasing order.

    fun mergeTwoLinkedLists(l1: ListNode<Int>?, l2: ListNode<Int>?): ListNode<Int>? {
        var copyL1 = l1
        var copyL2 = l2
        var r: ListNode<Int>? = ListNode(0)
        val result = r

        while (copyL1 != null || copyL2 != null){
            var current: Int

            if ((copyL1?.value ?: Int.MAX_VALUE) < (copyL2?.value ?: Int.MAX_VALUE)){
                current = copyL1!!.value
                copyL1 = copyL1.next
            } else {
                current = copyL2!!.value
                copyL2 = copyL2.next
            }

            r!!.next = ListNode(current)
            r = r.next
        }

        return result!!.next
    }

//    TODO: reverseNodesInKGroups
//    TODO: rearrangeLastN
}