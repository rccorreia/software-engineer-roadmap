package unit.computerScience.dataStructures

import com.github.rccorreia.computerScience.dataStructures.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream


class ArrayUnitTest {

    @Nested
    inner class ArrayInitializationUnitTest {
        @Test
        fun `Given strings, Then get array of given strings`() {
            val stringsCount = 4
            val banana = "Banana"
            val strawberry = "Strawberry"
            val blueberry = "Blueberry"
            val apple = "Apple"

            val arrayOfFruitsNames = createArrayOfStrings(banana, strawberry, blueberry, apple)

            assertEquals(stringsCount, arrayOfFruitsNames.size)
            assertEquals(banana, arrayOfFruitsNames[0])
            assertEquals(strawberry, arrayOfFruitsNames[1])
            assertEquals(blueberry, arrayOfFruitsNames[2])
            assertEquals(apple, arrayOfFruitsNames[3])
        }
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    inner class ArrayInterviewQuestionsTest {
        @ParameterizedTest(name = "for {0} the return is {1}")
        @MethodSource("arrayIntAndIntProvider")
        fun `Given an int array, Then get the first duplicate number`(array: Array<Int>, expected: Int ) {
            val arrayInterviewQuestions = ArrayInterviewQuestions()
            val result = arrayInterviewQuestions.firstDuplicate(array)

            assertEquals(expected, result)
        }

        private fun arrayIntAndIntProvider(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(arrayOf(1, 3, 3), 3),
                Arguments.of(arrayOf(2, 4, 3, 5, 1), -1),
                Arguments.of(arrayOf(2, 1, 7, 5, 7, 2, 6), 7),
                Arguments.of(arrayOf(1), -1)
            )
        }

        @ParameterizedTest
        @CsvSource(
            "test, e",
            "aaa, _",
            "abba, _",
            "z, z"
        )
        fun `Given a string, Then get the first not repeating character`(string: String, expected: Char) {
            val arrayInterviewQuestions = ArrayInterviewQuestions()
            val result = arrayInterviewQuestions.firstNotRepeatingCharacter(string)

            assertEquals(expected, result)
        }

        @ParameterizedTest(name = "for {0} the return is {1}")
        @MethodSource("arrayOfArrayIntAndArrayOfArrayIntProvider")
        fun `Given an int array of array as image, Then get the rotated image in 90 degrees`(array: Array<Array<Int>>, expected: Array<Array<Int>> ) {
            val arrayInterviewQuestions = ArrayInterviewQuestions()
            val result = arrayInterviewQuestions.rotateImage(array)

            assertArrayEquals(expected, result)
        }

        private fun arrayOfArrayIntAndArrayOfArrayIntProvider(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(arrayOf(arrayOf(1, 2, 3), arrayOf(4, 5, 6), arrayOf(7, 8, 9)),
                    arrayOf(arrayOf(7, 4, 1), arrayOf(8, 5, 2), arrayOf(9, 6, 3))),
                Arguments.of(arrayOf(arrayOf(1)),
                    arrayOf(arrayOf(1))),
                Arguments.of(arrayOf(arrayOf(10, 9, 6, 3, 7), arrayOf(6, 10, 2, 9, 7), arrayOf(7, 6, 3, 8, 2),
                    arrayOf(8, 9, 7, 9, 9), arrayOf(6, 8, 6, 8, 2)),
                    arrayOf(arrayOf(6, 8, 7, 6, 10), arrayOf(8, 9, 6, 10, 9), arrayOf(6, 7, 3, 2, 6),
                        arrayOf(8, 9, 8, 9, 3), arrayOf(2, 9, 2, 7, 7)))
            )
        }

        @ParameterizedTest(name = "for {0} the return is {1}")
        @MethodSource("listOfListCharAndBooleanProvider")
        fun `Given an char array of array as sudoku game, Then get validation of the game`(list: List<List<Char>>, expected: Boolean ) {
            val arrayInterviewQuestions = ArrayInterviewQuestions()
            val result = arrayInterviewQuestions.sudoku2(list)

            assertEquals(expected, result)
        }

        private fun listOfListCharAndBooleanProvider(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf(listOf('.', '.', '.', '1', '4', '.', '.', '2', '.'),
                    listOf('.', '.', '6', '.', '.', '.', '.', '.', '.'),
                    listOf('.', '.', '.', '.', '.', '.', '.', '.', '.'),
                    listOf('.', '.', '1', '.', '.', '.', '.', '.', '.'),
                    listOf('.', '6', '7', '.', '.', '.', '.', '.', '9'),
                    listOf('.', '.', '.', '.', '.', '.', '8', '1', '.'),
                    listOf('.', '3', '.', '.', '.', '.', '.', '.', '6'),
                    listOf('.', '.', '.', '.', '.', '7', '.', '.', '.'),
                    listOf('.', '.', '.', '5', '.', '.', '.', '7', '.')), true),
                Arguments.of(listOf(listOf('.', '.', '.', '.', '2', '.', '.', '9', '.'),
                    listOf('.', '.', '.', '.', '6', '.', '.', '.', '.'),
                    listOf('7', '1', '.', '.', '7', '5', '.', '.', '.'),
                    listOf('.', '7', '.', '.', '.', '.', '.', '.', '.'),
                    listOf('.', '.', '.', '.', '8', '3', '.', '.', '.'),
                    listOf('.', '.', '8', '.', '.', '7', '.', '6', '.'),
                    listOf('.', '.', '.', '.', '.', '1', '.', '.', '.'),
                    listOf('.', '3', '.', '9', '.', '.', '.', '.', '.'),
                    listOf('.', '2', '.', '.', '3', '.', '.', '7', '.')), false),
                Arguments.of(listOf(listOf('.', '.', '.', '.', '2', '.', '.', '9', '.'),
                    listOf('.', '.', '.', '.', '6', '.', '.', '.', '.'),
                    listOf('7', '1', '.', '.', '8', '5', '.', '.', '.'),
                    listOf('.', '7', '.', '.', '.', '.', '.', '.', '.'),
                    listOf('.', '.', '.', '.', '8', '3', '.', '.', '.'),
                    listOf('.', '.', '8', '.', '.', '7', '.', '6', '.'),
                    listOf('.', '.', '.', '.', '.', '1', '.', '.', '.'),
                    listOf('.', '3', '.', '9', '.', '.', '.', '.', '.'),
                    listOf('.', '2', '.', '.', '3', '.', '.', '7', '.')), false),
                Arguments.of(listOf(listOf('.', '.', '.', '.', '2', '.', '.', '9', '.'),
                    listOf('.', '.', '.', '.', '6', '.', '.', '.', '.'),
                    listOf('7', '1', '.', '.', '8', '5', '.', '.', '.'),
                    listOf('.', '7', '.', '.', '.', '.', '.', '.', '.'),
                    listOf('.', '.', '.', '.', '5', '3', '.', '.', '.'),
                    listOf('.', '.', '8', '.', '.', '7', '.', '6', '.'),
                    listOf('.', '.', '.', '.', '.', '1', '.', '.', '.'),
                    listOf('.', '3', '2', '9', '.', '.', '.', '.', '.'),
                    listOf('.', '2', '.', '.', '3', '.', '.', '7', '.')), false)
            )
        }


        @ParameterizedTest(name = "for {0} and {1} the return is {2}")
        @MethodSource("arrayOfStringAndArrayOfArrayOfCharAndBooleanProvider")
        fun `Given an string array as crypt and an char array of array, Then get validation of the solution`(crypt: Array<String>,
                                                                                                             solution: Array<Array<Char>>,
                                                                                                             expected: Boolean ) {
            val arrayInterviewQuestions = ArrayInterviewQuestions()
            val result = arrayInterviewQuestions.isCryptSolution(crypt, solution)

            assertEquals(expected, result)
        }

        private fun arrayOfStringAndArrayOfArrayOfCharAndBooleanProvider(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(arrayOf("SEND", "MORE", "MONEY"),
                    arrayOf(arrayOf('O', '0'), arrayOf('M', '1'), arrayOf('Y', '2'), arrayOf('E', '5'),
                        arrayOf('N', '6'), arrayOf('D', '7'), arrayOf('R', '8'), arrayOf('S', '9')), true),
                Arguments.of(arrayOf("TEN", "TWO", "ONE"),
                    arrayOf(arrayOf('O', '1'), arrayOf('T', '0'), arrayOf('W', '9'), arrayOf('E', '5'),
                        arrayOf('N', '4')), false),
                Arguments.of(arrayOf("A", "B", "C"),
                    arrayOf(arrayOf('A', '5'), arrayOf('B', '6'), arrayOf('C', '1')), false)
            )
        }
    }
}
