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
        arrayOf(s.groupingBy { it }.eachCount()
            .filter { it.value == 1 }).firstOrNull()?.keys?.firstOrNull() ?: '_'


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

//    A cryptarithm is a mathematical puzzle for which the goal is to find the correspondence between letters and digits, such that the given arithmetic equation consisting of letters holds true when the letters are converted to digits.
//
//    You have an array of strings crypt, the cryptarithm, and an an array containing the mapping of letters and digits, solution. The array crypt will contain three non-empty strings that follow the structure: [word1, word2, word3], which should be interpreted as the word1 + word2 = word3 cryptarithm.
//
//    If crypt, when it is decoded by replacing all of the letters in the cryptarithm with digits using the mapping in solution, becomes a valid arithmetic equation containing no numbers with leading zeroes, the answer is true. If it does not become a valid arithmetic solution, the answer is false.
//
//    Note that number 0 doesn't contain leading zeroes (while for example 00 or 0123 do).
//
//    Example
//
//    For crypt = ["SEND", "MORE", "MONEY"] and
//
//    solution = [['O', '0'],
//    ['M', '1'],
//    ['Y', '2'],
//    ['E', '5'],
//    ['N', '6'],
//    ['D', '7'],
//    ['R', '8'],
//    ['S', '9']]
//    the output should be
//    solution(crypt, solution) = true.
//
//    When you decrypt "SEND", "MORE", and "MONEY" using the mapping given in crypt, you get 9567 + 1085 = 10652 which is correct and a valid arithmetic equation.
//
//    For crypt = ["TEN", "TWO", "ONE"] and
//
//    solution = [['O', '1'],
//    ['T', '0'],
//    ['W', '9'],
//    ['E', '5'],
//    ['N', '4']]
//    the output should be
//    solution(crypt, solution) = false.
//
//    Even though 054 + 091 = 145, 054 and 091 both contain leading zeroes, meaning that this is not a valid solution.
//
//    Input/Output
//
//    [execution time limit] 3 seconds (kt)
//
//    [memory limit] 1 GB
//
//    [input] array.string crypt
//
//    An array of three non-empty strings containing only uppercase English letters.
//
//    Guaranteed constraints:
//    crypt.length = 3,
//    1 ≤ crypt[i].length ≤ 14.
//
//    [input] array.array.char solution
//
//    An array consisting of pairs of characters that represent the correspondence between letters and numbers in the cryptarithm. The first character in the pair is an uppercase English letter, and the second one is a digit in the range from 0 to 9.
//
//    It is guaranteed that solution only contains entries for the letters present in crypt and that different letters have different values.
//
//    Guaranteed constraints:
//    solution[i].length = 2,
//    'A' ≤ solution[i][0] ≤ 'Z',
//    '0' ≤ solution[i][1] ≤ '9',
//    solution[i][0] ≠ solution[j][0], i ≠ j,
//    solution[i][1] ≠ solution[j][1], i ≠ j.
//
//    [output] boolean
//
//    Return true if the solution represents the correct solution to the cryptarithm crypt, otherwise return false.

    fun isCryptSolution(crypt: Array<String>, solution: Array<Array<Char>>): Boolean {
        val mappedSolution = solution.associate { it[0] to it[1] }

        if (thereIsALeadingZero(crypt, mappedSolution)) return false

        val intOfString1 = crypt[0].map { mappedSolution[it] ?: '0' }.joinToString("").toIntOrNull() ?: 0
        val intOfString2 = crypt[1].map { mappedSolution[it] ?: '0' }.joinToString("").toIntOrNull() ?: 0
        val intOfString3 = crypt[2].map { mappedSolution[it] ?: '0' }.joinToString("").toIntOrNull() ?: 0

        return intOfString1 + intOfString2 == intOfString3
    }

    private fun thereIsALeadingZero(crypt: Array<String>, mappedSolution: Map<Char, Char>): Boolean{
        (0 until 3 ).forEach { if ( mappedSolution[crypt[it][0]] == '0' && crypt[it].length > 1) return true }

        return false
    }
}