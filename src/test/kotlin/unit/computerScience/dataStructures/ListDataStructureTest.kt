package unit.computerScience.dataStructures

import com.github.rccorreia.computerScience.dataStructures.ListDataStructureInterviewQuestions
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class ListDataStructureTest {

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    inner class ListDataStructureInterviewQuestionsTest {

        @ParameterizedTest(name = "for {0} the return is {1}")
        @MethodSource("mutableListIntAndIntProvider")
        fun `Given an int list, Then get the first duplicate number`(list: MutableList<Int>, expected: Int ) {
            val listDataStructureInterviewQuestions = ListDataStructureInterviewQuestions()
            val result = listDataStructureInterviewQuestions.firstDuplicate(list)

            Assertions.assertEquals(expected, result)
        }

        private fun mutableListIntAndIntProvider(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(mutableListOf(1, 3, 3), 3),
                Arguments.of(mutableListOf(2, 4, 3, 5, 1), -1),
                Arguments.of(mutableListOf(2, 1, 7, 5, 7, 2, 6), 7),
                Arguments.of(mutableListOf(1), -1)
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
            val listDataStructureInterviewQuestions = ListDataStructureInterviewQuestions()
            val result = listDataStructureInterviewQuestions.firstNotRepeatingCharacter(string)

            Assertions.assertEquals(expected, result)
        }

        @ParameterizedTest(name = "for {0} the return is {1}")
        @MethodSource("mutableListOfMutableListOfIntAndListOfListOfIntProvider")
        fun `Given an int mutableList of mutableList as image, Then get the rotated image in 90 degrees`(list: MutableList<MutableList<Int>>,
                                                                                             expected: List<List<Int>> ) {
            val listDataStructureInterviewQuestions = ListDataStructureInterviewQuestions()
            val result = listDataStructureInterviewQuestions.rotateImage(list)

            Assertions.assertEquals(expected, result)
        }

        private fun mutableListOfMutableListOfIntAndListOfListOfIntProvider(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(mutableListOf(mutableListOf(1, 2, 3), mutableListOf(4, 5, 6), mutableListOf(7, 8, 9)),
                    listOf(listOf(7, 4, 1), listOf(8, 5, 2), listOf(9, 6, 3))),
                Arguments.of(mutableListOf(mutableListOf(1)),
                    listOf(listOf(1))),
                Arguments.of(mutableListOf(mutableListOf(10, 9, 6, 3, 7), mutableListOf(6, 10, 2, 9, 7),
                    mutableListOf(7, 6, 3, 8, 2), mutableListOf(8, 9, 7, 9, 9), mutableListOf(6, 8, 6, 8, 2)),
                    listOf(listOf(6, 8, 7, 6, 10), listOf(8, 9, 6, 10, 9), listOf(6, 7, 3, 2, 6),
                        listOf(8, 9, 8, 9, 3), listOf(2, 9, 2, 7, 7)))
            )
        }

        @ParameterizedTest(name = "for {0} the return is {1}")
        @MethodSource("listOfListCharAndBooleanProvider")
        fun `Given an char list of list as sudoku game, Then get validation of the game`(list: List<List<Char>>, expected: Boolean ) {
            val listDataStructureInterviewQuestions = ListDataStructureInterviewQuestions()
            val result = listDataStructureInterviewQuestions.sudoku2(list)

            Assertions.assertEquals(expected, result)
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
        @MethodSource("listOfStringAndListOfListOfCharAndBooleanProvider")
        fun `Given an string list as crypt and an char list of list, Then get validation of the solution`(crypt: List<String>,
                                                                                                             solution: List<List<Char>>,
                                                                                                             expected: Boolean ) {
            val listDataStructureInterviewQuestions = ListDataStructureInterviewQuestions()
            val result = listDataStructureInterviewQuestions.isCryptSolution(crypt, solution)

            Assertions.assertEquals(expected, result)
        }

        private fun listOfStringAndListOfListOfCharAndBooleanProvider(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf("SEND", "MORE", "MONEY"),
                    listOf(listOf('O', '0'), listOf('M', '1'), listOf('Y', '2'), listOf('E', '5'),
                        listOf('N', '6'), listOf('D', '7'), listOf('R', '8'), listOf('S', '9')), true),
                Arguments.of(listOf("TEN", "TWO", "ONE"),
                    listOf(listOf('O', '1'), listOf('T', '0'), listOf('W', '9'), listOf('E', '5'),
                        listOf('N', '4')), false),
                Arguments.of(listOf("A", "B", "C"),
                    listOf(listOf('A', '5'), listOf('B', '6'), listOf('C', '1')), false)
            )
        }
    }

}