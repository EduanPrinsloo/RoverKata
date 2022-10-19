package com.thedevadventure.roverkata.plateau

import java.util.Scanner

class PlateauService {

    fun getPlateau(): Plateau {
        val scanner = Scanner(System.`in`)
        println("Please enter the dimensions of your plateau starting with the size of X and hitting enter?")
        val plateauDimensionsX = scanner.nextInt()
        println("And the size of Y?")
        val plateauDimensionsY = scanner.nextInt()
        val userPlateau = Plateau(plateauDimensionsX, plateauDimensionsY)
        validatePlateau(userPlateau)
        return userPlateau
    }

    private fun validatePlateau(plateauDimensions: Plateau): Boolean {
        if (plateauDimensions.X > 0 && plateauDimensions.Y > 0) {
            println("Thank you for passing a valid plateau...")
            return true
        } else {
            throw Exception("Invalid plateau passed both your inputs should be larger than 0!")
        }
    }
}
