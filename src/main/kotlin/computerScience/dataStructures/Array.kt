package com.github.rccorreia.computerScience.dataStructures

import kotlin.math.abs

fun createArrayOfStrings(vararg args: String): Array<String> = arrayOf(*args)

class ArrayInterviewQuestions{

    //  Question: Given an array a that contains only numbers in the range from 1 to a.length, find
    //  the first duplicate number for which the second occurrence has the minimal index.
    //  In other words, if there are more than 1 duplicated numbers, return the number for which the
    //  second occurrence has a smaller index than the second occurrence of the other number does.
    //  If there are no such elements, return -1.

    //  Example
    //
    //  For a = [2, 1, 3, 5, 3, 2], the output should be solution(a) = 3.
    //
    //  There are 2 duplicates: numbers 2 and 3. The second occurrence of 3 has a smaller index than
    //  the second occurrence of 2 does, so the answer is 3.
    //
    //  For a = [2, 2], the output should be solution(a) = 2;
    //  For a = [2, 4, 3, 5, 1], the output should be solution(a) = -1.

    //  Guaranteed constraints:
    //  1 ≤ a.length ≤ 105,
    //  1 ≤ a[i] ≤ a.length.

    // Answer:

    //  Without memory restriction

    //  val search = mutableSetOf<Int>()
    //  for(number in a){
    //      if (number in search) return number else search.add(number)
    //  }
    //  return -1

    fun firstDuplicate(a: Array<Int>): Int{
        for (i in a.indices){
            if(a[abs(a[i])-1] < 0){
                return abs(a[i])
            } else {
                a[abs(a[i])-1]=-a[abs(a[i])-1]
            }
        }
        return -1
    }
}