package com.thedevadventure.roverkata

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class RoverKataTest {

    @Test
    fun `should return true if the plateau is valid`() {
        val expected = true
        val result = validatePlateau(7, 8)
        assertEquals(expected, result)
    }
}
