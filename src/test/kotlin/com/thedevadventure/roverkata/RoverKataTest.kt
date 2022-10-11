package com.thedevadventure.roverkata

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class RoverKataTest {

    @Test
    fun `should return true if the plateau is valid`() {
        val expected = true
        val result = validatePlateau(Plateau(7, 8))
        assertEquals(expected, result)
    }

    @Test
    fun `should throw an error if a invalid dimension is passed`() {
        try {
            validatePlateau(Plateau(-1, -2))
            Assertions.fail("Exception expected")
        } catch (e: Exception) {
            assertEquals("Invalid plateau passed both your inputs should be larger than 0!", e.message)
        }
    }

    @Test
    fun `should return value true if the Rovers starting location is on the plateau`() {
        val plateau = Plateau(5, 5)
        val validLocation = Location(0, 5)
        val expected = true
        val result = validateTheRoverHasLanded(plateau, validLocation)
        assertEquals(expected, result)
    }

    @Test
    fun `should throw an error if the Rovers starting location is NOT on the plateau`() {
        try {
            val plateau = Plateau(5, 5)
            val invalidLocation = Location(-1, 1)
            validateTheRoverHasLanded(plateau, invalidLocation)
            Assertions.fail("Exception expected")
        } catch (e: Exception) {
            assertEquals("Mission failed... The rover missed the target!", e.message)
        }
    }


}
