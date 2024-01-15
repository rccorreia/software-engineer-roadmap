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
    }
}

