package com.github.rccorreia
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class CalculatorTest {

    @Test
    fun `Adding 1 and 3 should be equal to 4`() {
        val calculator = Calculator()
        val expected = 4

        assertEquals(expected, calculator.add(1, 3))
    }
}