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
    fun `should return the new location if the rover gets an instruction to move North starting from 00`() {
        val plateau = Plateau(1, 1)
        val startingLocation = Location(0, 0)
        val instructions = Instructions("N")
        val expected = listOf(Location(0, 0), Location(0, 1))
        val result = explore(plateau, startingLocation, instructions)
        assertEquals(expected, result)
    }

    @Test
    fun `should return the new location if the rover gets instructions to move North and then East starting from 00`() {
        val plateau = Plateau(1, 1)
        val startingLocation = Location(0, 0)
        val instructions = Instructions("NE")
        val expected = listOf(Location(0, 0), Location(0, 1), Location(1, 1))
        val result = explore(plateau, startingLocation, instructions)
        assertEquals(expected, result)
    }

    @Test
    fun `should return the new location if the rover gets instructions to move 2 North and 2 East starting from 00 ignoring case`() {
        val plateau = Plateau(2, 2)
        val startingLocation = Location(0, 0)
        val instructions = Instructions("NeeN")
        val expected = listOf(Location(0, 0), Location(0, 1), Location(1, 1), Location(2, 1), Location(2, 2))
        val result = explore(plateau, startingLocation, instructions)
        assertEquals(expected, result)
    }

    @Test
    fun `should throw an error if the rover falls of the plateau and the location`() {
        try {
            val plateau = Plateau(3, 3)
            val startingLocation = Location(2, 2)
            val instructions = Instructions("NEE")
            explore(plateau, startingLocation, instructions)
        } catch (e: Exception) {
            assertEquals("Mission failed... The rover was lost at Location(X=4, Y=3)...", e.message)
        }
    }

    @Test
    fun `should return a list of all point on a single rover path`() {
        val plateau = Plateau(5, 5)
        val startingLocation = Location(2, 2)
        val instructions = Instructions("NNN")

        val expected = listOf(Location(2, 2), Location(2, 3), Location(2, 4), Location(2, 5))
        val result = explore(plateau, startingLocation, instructions)
        assertEquals(expected, result)
    }

    @Test
    fun `should return all locations where 2 rover paths intersect`() {
        val plateau = Plateau(3, 3)
//        first rover details
        val startingLocationOfFirstRover = Location(0, 0)
        val instructionsOfFirstRover = Instructions("NENENE")
        val resultOfFirstRover = explore(plateau, startingLocationOfFirstRover, instructionsOfFirstRover)
//        second rover details
        val startingLocationOfSecondRover = Location(3, 0)
        val instructionsOfOfSecondRover = Instructions("NWNWNW")
        val resultOfSecondRover = explore(plateau, startingLocationOfSecondRover, instructionsOfOfSecondRover)

        val expectedIntersectionPoints = listOf(Location(1, 2), Location(2, 2))
        val resultingIntersectionPoints = checkIntersections(resultOfFirstRover, resultOfSecondRover)
        assertEquals(expectedIntersectionPoints, resultingIntersectionPoints)
    }

    @Test
    fun `should return a message if there is no intersection point on 2 paths`() {
        try {
            val plateau = Plateau(3, 3)
//        first rover details
            val startingLocationOfFirstRover = Location(0, 0)
            val instructionsOfFirstRover = Instructions("NE")
            val resultOfFirstRover = explore(plateau, startingLocationOfFirstRover, instructionsOfFirstRover)
//        second rover details
            val startingLocationOfSecondRover = Location(3, 3)
            val instructionsOfOfSecondRover = Instructions("SW")
            val resultOfSecondRover = explore(plateau, startingLocationOfSecondRover, instructionsOfOfSecondRover)
            checkIntersections(resultOfFirstRover, resultOfSecondRover).toString()
            fail("Exception expected")
        } catch (e: Exception) {
            assertEquals("No Intersections found...", e.message)
        }
    }


}
