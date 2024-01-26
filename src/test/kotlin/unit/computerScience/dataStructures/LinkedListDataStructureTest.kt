package unit.computerScience.dataStructures

import com.github.rccorreia.computerScience.dataStructures.LinkedListDataStructure
import com.github.rccorreia.computerScience.dataStructures.ListNode
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LinkedListDataStructureTest {
    @ParameterizedTest(name = "for {0} return {1}")
    @MethodSource("listNodeOfIntAndListNodeOfIntProvider")
    fun `Given an List Node, Then get the reversed list`(l: ListNode<Int>?, expected: ListNode<Int>? ) {
        val linkedListDataStructure = LinkedListDataStructure()
        val result = linkedListDataStructure.revertLinkedList(l)

        Assertions.assertEquals(expected, result)
    }

    private fun listNodeOfIntAndListNodeOfIntProvider(): Stream<Arguments> {
        val l1 = ListNode<Int>(1)
        val l2 = ListNode<Int>(2)
        val l3 = ListNode<Int>(3)
        val l4 = ListNode<Int>(4)
        val l5 = ListNode<Int>(5)
        l1.next = l2
        l2.next = l3
        l3.next = l4
        l4.next = l5

        val r1 = ListNode<Int>(5)
        val r2 = ListNode<Int>(4)
        val r3 = ListNode<Int>(3)
        val r4 = ListNode<Int>(2)
        val r5 = ListNode<Int>(1)
        r1.next = r2
        r2.next = r3
        r3.next = r4
        r4.next = r5

        val a1 = ListNode<Int>(7)

        val b1 = ListNode<Int>(0)
        val b2 = ListNode<Int>(10)

        val c1 = ListNode<Int>(10)
        val c2 = ListNode<Int>(0)

        b1.next = b2
        c1.next = c2

        return Stream.of(
            Arguments.of(l1, r1),
            Arguments.of(a1, a1),
            Arguments.of(b1, c1)
        )
    }

    @Test
    fun `Given an List Node and a node to remove, Then get the list with node removed`() {
        val l1 = ListNode<Int>(1)
        val l2 = ListNode<Int>(2)
        val l3 = ListNode<Int>(3)

        l1.next = l2
        l2.next = l3

        val r1 = ListNode<Int>(1)
        val r2 = ListNode<Int>(3)

        r1.next = r2

        val linkedListDataStructure = LinkedListDataStructure()
        linkedListDataStructure.removeNodeWithoutPrevious(l2)

        Assertions.assertEquals(r1, l1)
    }

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

    @ParameterizedTest(name = "for {0} and {1} the return is {2}")
    @MethodSource("listNodeOfIntAndListNodeOfIntAndListNodeOfIntProvider")
    fun `Given an huge number as Int List Node and another huge number as Int List Node, Then get the sum of huge numbers as Int List Node`(a: ListNode<Int>?, b: ListNode<Int>?, expected: ListNode<Int>? ) {
        val linkedListDataStructure = LinkedListDataStructure()
        val result = linkedListDataStructure.addTwoHugeNumbers(a, b)

        Assertions.assertEquals(expected, result)
    }

    private fun listNodeOfIntAndListNodeOfIntAndListNodeOfIntProvider(): Stream<Arguments> {
        val a1 = ListNode<Int>(9876)
        val a2 = ListNode<Int>(5432)
        val a3 = ListNode<Int>(1999)
        a1.next = a2
        a2.next = a3

        val b1 = ListNode<Int>(1)
        val b2 = ListNode<Int>(8001)
        b1.next = b2

        val r1 = ListNode<Int>(9876)
        val r2 = ListNode<Int>(5434)
        val r3 = ListNode<Int>(0)
        r1.next = r2
        r2.next = r3

        val z = ListNode<Int>(0)

        val c = ListNode<Int>(1)

        val d1 = ListNode<Int>(9998)
        val d2 = ListNode<Int>(9999)
        val d3 = ListNode<Int>(9999)
        val d4 = ListNode<Int>(9999)
        val d5 = ListNode<Int>(9999)
        val d6 = ListNode<Int>(9999)
        d1.next = d2
        d2.next = d3
        d3.next = d4
        d4.next = d5
        d5.next = d6

        val rr1 = ListNode<Int>(9999)
        val rr2 = ListNode<Int>(0)
        val rr3 = ListNode<Int>(0)
        val rr4 = ListNode<Int>(0)
        val rr5 = ListNode<Int>(0)
        val rr6 = ListNode<Int>(0)
        rr1.next = rr2
        rr2.next = rr3
        rr3.next = rr4
        rr4.next = rr5
        rr5.next = rr6

        return Stream.of(
            Arguments.of(a1, b1, r1),
            Arguments.of(z, z, z),
            Arguments.of(c, d1, rr1)
        )
    }

    @ParameterizedTest(name = "for {0} and {1} the return is {2}")
    @MethodSource("listNodeOfIntAndListNodeOfIntAndListNodeOfIntForMergeTwoLinkedListsProvider")
    fun `Given an Int List Node and another Int List Node, Then get the merged Int List Node`(l1: ListNode<Int>?, l2: ListNode<Int>?, expected: ListNode<Int>? ) {
        val linkedListDataStructure = LinkedListDataStructure()
        val result = linkedListDataStructure.mergeTwoLinkedLists(l1, l2)

        Assertions.assertEquals(expected, result)
    }

    private fun listNodeOfIntAndListNodeOfIntAndListNodeOfIntForMergeTwoLinkedListsProvider(): Stream<Arguments> {
        val l101 = ListNode<Int>(1)
        val l102 = ListNode<Int>(2)
        val l103 = ListNode<Int>(3)
        l101.next = l102
        l102.next = l103

        val l201 = ListNode<Int>(4)
        val l202 = ListNode<Int>(5)
        val l203 = ListNode<Int>(6)
        l201.next = l202
        l202.next = l203

        val r1201 = ListNode<Int>(1)
        val r1202 = ListNode<Int>(2)
        val r1203 = ListNode<Int>(3)
        val r1204 = ListNode<Int>(4)
        val r1205 = ListNode<Int>(5)
        val r1206 = ListNode<Int>(6)
        r1201.next = r1202
        r1202.next = r1203
        r1203.next = r1204
        r1204.next = r1205
        r1205.next = r1206



        val l301 = ListNode<Int>(5)
        val l302 = ListNode<Int>(10)
        val l303 = ListNode<Int>(15)
        val l304 = ListNode<Int>(40)
        l301.next = l302
        l302.next = l303
        l303.next = l304

        val l401 = ListNode<Int>(2)
        val l402 = ListNode<Int>(3)
        val l403 = ListNode<Int>(20)
        l401.next = l402
        l402.next = l403

        val r3401 = ListNode<Int>(2)
        val r3402 = ListNode<Int>(3)
        val r3403 = ListNode<Int>(5)
        val r3404 = ListNode<Int>(10)
        val r3405 = ListNode<Int>(15)
        val r3406 = ListNode<Int>(20)
        val r3407 = ListNode<Int>(40)
        r3401.next = r3402
        r3402.next = r3403
        r3403.next = r3404
        r3404.next = r3405
        r3405.next = r3406
        r3406.next = r3407

        return Stream.of(
            Arguments.of(l101, l201, r1201),
            Arguments.of(l301, l401, r3401)
        )
    }
}