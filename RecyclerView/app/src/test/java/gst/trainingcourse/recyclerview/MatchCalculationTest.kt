package gst.trainingcourse.recyclerview

import org.junit.Test

class MatchCalculationTest {


    @Test
    fun testAdd() {
        val matchCalculation = MathCalculation()
        val numberA = 1
        val numberB = 2;
        val expectedValue = 3
        assert(matchCalculation.add(numberA, numberB) == expectedValue)
    }
}