package unit.computerScience.dataStructures

import com.github.rccorreia.computerScience.dataStructures.LinkedListDataStructure
import com.github.rccorreia.computerScience.dataStructures.ListNode
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LinkedListDataStructureTest {
    @ParameterizedTest(name = "for {0} and {1} the return is {2}")
    @MethodSource("listNodeOfIntAndIntAndListNodeOfIntProvider")
    fun `Given an List Node and an Int k, Then get the list with all numbers except k`(l: ListNode<Int>?, k: Int, expected: ListNode<Int>? ) {
        val linkedListDataStructure = LinkedListDataStructure()
        val result = linkedListDataStructure.removeKFromList(l, k)

        Assertions.assertEquals(expected, result)
    }

    private fun listNodeOfIntAndIntAndListNodeOfIntProvider(): Stream<Arguments> {
        val l1 = ListNode<Int>(3)
        val l2 = ListNode<Int>(1)
        val l3 = ListNode<Int>(2)
        val l4 = ListNode<Int>(3)
        val l5 = ListNode<Int>(4)
        val l6 = ListNode<Int>(5)
        l1.next = l2
        l2.next = l3
        l3.next = l4
        l4.next = l5
        l5.next = l6

        val e1 = ListNode<Int>(1)
        val e2 = ListNode<Int>(2)
        e1.next = e2
        e2.next = l5

        return Stream.of(
            Arguments.of(l1, 3, e1),
            Arguments.of(l1, 12, l1),
            Arguments.of(l6, 5, null)
        )
    }

    @ParameterizedTest(name = "for {0} the return is {1}")
    @MethodSource("listNodeOfIntAndBooleanProvider")
    fun `Given an List Node, Then get if it is a palindrome or not`(l: ListNode<Int>?, expected: Boolean ) {
        val linkedListDataStructure = LinkedListDataStructure()
        val result = linkedListDataStructure.isListPalindrome(l)

        Assertions.assertEquals(expected, result)
    }

    private fun listNodeOfIntAndBooleanProvider(): Stream<Arguments> {
        val l1 = ListNode<Int>(0)
        val l2 = ListNode<Int>(1)
        val l3 = ListNode<Int>(0)
        l1.next = l2
        l2.next = l3

        val e1 = ListNode<Int>(1)
        val e2 = ListNode<Int>(2)
        val e3 = ListNode<Int>(2)
        val e4 = ListNode<Int>(3)
        e1.next = e2
        e2.next = e3
        e3.next = e4

        val s1 = ListNode<Int>(1)
        val s2 = ListNode<Int>(1000000000)
        val s3 = ListNode<Int>(-1000000000)
        val s4 = ListNode<Int>(-1000000000)
        val s5 = ListNode<Int>(1000000000)
        val s6 = ListNode<Int>(1)
        s1.next = s2
        s2.next = s3
        s3.next = s4
        s4.next = s5
        s5.next = s6

        return Stream.of(
            Arguments.of(l1, true),
            Arguments.of(e1, false),
            Arguments.of(s1, true)
        )
    }
}