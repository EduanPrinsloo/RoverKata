package com.thedevadventure.roverkata

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.fail
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
            fail("Exception expected")
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
            fail("Exception expected")
        } catch (e: Exception) {
            assertEquals("Mission failed... The rover missed the target!", e.message)
        }
    }

    @Test
    fun `should throw an error if numbers are passed in the commands for a rover`() {
        try {
            val invalidCommands = "123"
            validateRoverCommands(invalidCommands)
            fail("Exception expected")
        } catch (e: Exception) {
            assertEquals("Computer says No!", e.message)
        }
    }

    @Test
    fun `should throw an error if invalid letters are passed as commands for a rover`() {
        try {
            val invalidCommands = "MorneMisNiePappa"
            validateRoverCommands(invalidCommands)
            fail("Exception expected")
        } catch (e: Exception) {
            assertEquals("Computer says No!", e.message)
        }
    }

    @Test
    fun `should pass even if lower case letters are passed in the rover commands`() {
        val expected = Instructions("NEWS")
        val result = validateRoverCommands("news")
        assertEquals(expected, result)
    }

    @Test
    fun `should return the new location if the rover gets an instruction to move North starting from 00`(){
        val startingLocation = Location(0,0)
        val instructions = Instructions("N")
        val expected = Location(0,1)
        val result = explore(startingLocation, instructions)
        assertEquals(expected, result)
    }

    @Test
    fun `should return the new location if the rover gets an instruction to move North and then East starting from 00`(){
        val startingLocation = Location(0,0)
        val instructions = Instructions("NE")
        val expected = Location(1,1)
        val result = explore(startingLocation, instructions)
        assertEquals(expected, result)
    }



}
