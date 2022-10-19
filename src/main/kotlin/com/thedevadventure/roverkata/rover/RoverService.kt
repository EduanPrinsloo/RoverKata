package com.thedevadventure.roverkata.rover

import com.thedevadventure.roverkata.location.Location
import com.thedevadventure.roverkata.location.locationService
import com.thedevadventure.roverkata.plateau.Plateau
import java.util.Scanner

class RoverService {

    fun getRoverDetailsAndExplore(plateau: Plateau, locationService: locationService): MutableList<Location> {
        val scanner = Scanner(System.`in`)
        val roverLocation = getRoverLocation(scanner, plateau)
        val roverInstructions = getRoverCommands(scanner)

        return explore(plateau, roverLocation, roverInstructions, locationService)
    }

    private fun explore(
        plateau: Plateau,
        startingLocation: Location,
        roverInstructions: Instructions,
        locationService: locationService,
    ): MutableList<Location> {
        val instructions = roverInstructions.roverCommands.map { it }
        val pathPoints = mutableListOf<Location>()
        var currentLocation = startingLocation
        pathPoints.add(startingLocation)
        for (instruction in instructions) {
            val result = move(instruction, currentLocation, locationService)
            isValidRoverPosition(result, plateau)
            pathPoints.add(result)
            currentLocation = result
        }
        return pathPoints
    }

    private fun move(input: Char, location: Location, locationService: locationService): Location {
        return when (input.uppercaseChar()) {
            'N' -> locationService.increaseY(location)
            'E' -> locationService.increaseX(location)
            'S' -> locationService.decreaseY(location)
            'W' -> locationService.decreaseX(location)
            else -> location
        }
    }

    private fun isValidRoverPosition(currentLocation: Location, plateau: Plateau): Boolean {
        if ((currentLocation.X > plateau.X || currentLocation.X < 0) || (currentLocation.Y > plateau.Y || currentLocation.Y < 0)) {
            throw Exception("Mission failed... The rover was lost at $currentLocation...")
        } else return true
    }

    private fun getRoverLocation(scanner: Scanner, plateau: Plateau): Location {
        println("Please enter the rovers coordinates, starting with X hitting enter and then Y...")
        val roverLocationX = scanner.nextInt()
        val roverLocationY = scanner.nextInt()
        val roverStartingLocation = Location(roverLocationX, roverLocationY)
        validateTheRoverHasLanded(plateau, roverStartingLocation)

        return roverStartingLocation
    }

    private fun getRoverCommands(scanner: Scanner): Instructions {
        println("Please enter the command sequence for a rover... valid inputs are limited to N, E, W, and S! ")
        val roverCommands = scanner.next()
        return validateRoverCommands(roverCommands)
    }

    private fun validateRoverCommands(commands: String): Instructions {
        if (!commands.uppercase().all { it.isLetter().and(it == 'N' || it == 'S' || it == 'W' || it == 'E') }) {
            throw Exception("Computer says No!")
        }
        val roverCommands = Instructions(commands.uppercase())
        println("Commands received: ${roverCommands.roverCommands}...")
        return roverCommands
    }

    private fun validateTheRoverHasLanded(plateau: Plateau, location: Location): Boolean {
        if ((location.X > plateau.X || location.X < 0) || (location.Y > plateau.Y || location.Y < 0)) {
            throw Exception("Mission failed... The rover missed the target!")
        } else {
            println("Rover has been located on the plateau, good job!")
            return true
        }
    }

}
