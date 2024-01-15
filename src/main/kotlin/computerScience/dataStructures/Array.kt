package com.github.rccorreia.computerScience.dataStructures

import kotlin.math.abs

fun createArrayOfStrings(vararg args: String): Array<String> = arrayOf(*args)

class ArrayInterviewQuestions{

//      Question: Given an array a that contains only numbers in the range from 1 to a.length, find
//      the first duplicate number for which the second occurrence has the minimal index.
//      In other words, if there are more than 1 duplicated numbers, return the number for which the
//      second occurrence has a smaller index than the second occurrence of the other number does.
//      If there are no such elements, return -1.
//
//      Example
//
//      For a = [2, 1, 3, 5, 3, 2], the output should be solution(a) = 3.
//
//      There are 2 duplicates: numbers 2 and 3. The second occurrence of 3 has a smaller index than
//      the second occurrence of 2 does, so the answer is 3.
//
//      For a = [2, 2], the output should be solution(a) = 2;
//      For a = [2, 4, 3, 5, 1], the output should be solution(a) = -1.
//
//      Guaranteed constraints:
//      1 ≤ a.length ≤ 105,
//      1 ≤ a[i] ≤ a.length.
//
//     Answer:
//
//      Without memory restriction
//
//      val search = mutableSetOf<Int>()
//      for(number in a){
//          if (number in search) return number else search.add(number)
//      }
//      return -1

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

//    Given a string s consisting of small English letters, find and return the first instance of a non-repeating
//    character in it. If there is no such character, return '_'.
//
//    Example
//
//    For s = "abacabad", the output should be
//    solution(s) = 'c'.
//
//    There are 2 non-repeating characters in the string: 'c' and 'd'. Return c since it appears in the string first.
//
//    For s = "abacabaabacaba", the output should be
//    solution(s) = '_'.
//
//    There are no characters in this string that do not repeat.
//
//    Input/Output
//
//    [execution time limit] 3 seconds (kt)
//
//    [memory limit] 1 GB
//
//    [input] string s
//
//    A string that contains only lowercase English letters.
//
//    Guaranteed constraints:
//    1 ≤ s.length ≤ 105.
//
//    [output] char
//
//    The first non-repeating character in s, or '_' if there are no characters that do not repeat.

// First function made:
// fun solution(s: String): Char {
//     for (character in s){
//         if (s.indexOf(character) == s.lastIndexOf(character)){
//             return character
//         }
//     }
//     return '_'
// }

    fun firstNotRepeatingCharacter(s: String) =
        s.groupingBy { it }.eachCount()
            .filter { it.value == 1 }.toList().firstOrNull()?.first ?: '_'


//    You are given an n x n 2D matrix that represents an image. Rotate the image by 90 degrees (clockwise).
//
//    Example
//
//    For
//
//    a = [[1, 2, 3],
//    [4, 5, 6],
//    [7, 8, 9]]
//    the output should be
//
//    solution(a) =
//    [[7, 4, 1],
//    [8, 5, 2],
//    [9, 6, 3]]
//    Input/Output
//
//    [execution time limit] 3 seconds (kt)
//
//    [memory limit] 1 GB
//
//    [input] array.array.integer a
//
//    Guaranteed constraints:
//    1 ≤ a.length ≤ 100,
//    a[i].length = a.length,
//    1 ≤ a[i][j] ≤ 104.
//
//    [output] array.array.integer

    //Remember:
    // Rotate + 90º -> Transpose + Reverse row
    // Rotate - 90º -> Reverse row + Transpose

    fun rotateImage(a: Array<Array<Int>>): Array<Array<Int>> {
        var helper: Int

        for (rowIndex in a.indices){
            for (columnIndex in rowIndex+1 until a[0].size){
                helper = a[rowIndex][columnIndex]
                a[rowIndex][columnIndex] = a[columnIndex][rowIndex]
                a[columnIndex][rowIndex] = helper
            }
        }

        a.map { it.reverse() }
        return a
    }
}