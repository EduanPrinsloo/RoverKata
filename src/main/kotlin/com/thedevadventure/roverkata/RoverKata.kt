package com.thedevadventure.roverkata

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    println("Please enter the dimensions of your plateau starting with the size of X?")
    val plateauDimensionsX = scanner.nextInt()
    println("And the size of Y?")
    val plateauDimensionsY = scanner.nextInt()
    validatePlateau(plateauDimensionsX, plateauDimensionsY)
}

fun validatePlateau(plateauDimensionsX: Int, plateauDimensionsY: Int): Boolean {
    return plateauDimensionsX > 0 && plateauDimensionsY > 0
}
