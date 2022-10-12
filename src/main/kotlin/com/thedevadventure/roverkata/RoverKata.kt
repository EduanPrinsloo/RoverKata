package com.thedevadventure.roverkata

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
//    Get and validate the plateau
    println("Please enter the dimensions of your plateau starting with the size of X?")
    val plateauDimensionsX = scanner.nextInt()
    println("And the size of Y?")
    val plateauDimensionsY = scanner.nextInt()
    val marsTerrain = Plateau(plateauDimensionsX, plateauDimensionsY)
    validatePlateau(marsTerrain)

//    Get and validate the locations of the rovers
    println("Please enter the first rovers coordinates, starting with X hitting enter and then Y...")
    val firstRoverLocation = Location(scanner.nextInt(), scanner.nextInt())
    validateTheRoverHasLanded(marsTerrain, firstRoverLocation)

//    Get Rover Instructions
    val firstRoverCommands = getRoverCommands(scanner)
}

fun validatePlateau(plateauDimensions: Plateau): Boolean {
    if (plateauDimensions.X > 0 && plateauDimensions.Y > 0) {
        println("Thank you for passing a valid plateau...")
        return true
    } else {
        throw Exception("Invalid plateau passed both your inputs should be larger than 0!")
    }
}

fun validateTheRoverHasLanded(plateau: Plateau, location: Location): Boolean {
    if ((location.X > plateau.X || location.X < 0) || (location.Y > plateau.Y || location.Y < 0)) {
        throw Exception("Mission failed... The rover missed the target!")
    } else {
        println("Rover has been located on the plateau, good job!")
        return true
    }
}

fun validateRoverCommands(commands: String): Instructions {
    if (!commands.uppercase().all { it.isLetter().and(it == 'N' || it == 'S' || it == 'W' || it == 'E') }) {
        throw  Exception("Computer says No!")
    }
    val roverCommands = Instructions(commands.uppercase())
    println("Commands received: ${roverCommands.roverCommands}...")
    return roverCommands
}

fun getRoverCommands(scanner: Scanner): Instructions{
    println("Please enter the command sequence for the first rover... valid inputs are limited to N, E, W, and S! ")
    val roverCommands = scanner.next()
    return validateRoverCommands(roverCommands)
}

data class Plateau(val X: Int, val Y: Int)
data class Location(val X: Int, val Y: Int)
data class Instructions(val roverCommands: String) {}
