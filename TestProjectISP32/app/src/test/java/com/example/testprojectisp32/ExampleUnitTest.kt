package com.example.testprojectisp32

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        var calculator:Calculator= Calculator(4,6)
        assertEquals(10, calculator.Add())
        assertNotEquals(9, calculator.Add())
        calculator=Calculator(-4,6)
        assertEquals(2, calculator.Add())
    }
    @Test
    fun subtract_isCorrect() {
        var calculator:Calculator= Calculator(4,6)
        assertEquals(-2, calculator.Sub())
        assertNotEquals(9, calculator.Sub())
        calculator=Calculator(-4,6)
        assertEquals(-10, calculator.Sub())
    }
}