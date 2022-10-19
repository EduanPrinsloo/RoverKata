package com.thedevadventure.roverkata

import com.thedevadventure.roverkata.location.locationService
import com.thedevadventure.roverkata.plateau.PlateauService
import com.thedevadventure.roverkata.rover.RoverService

fun main(plateauService: PlateauService, roverService: RoverService, locationService: locationService) {
    val marsTerrain = plateauService.getPlateau()
    val firstRover = roverService.getRoverDetailsAndExplore(marsTerrain, locationService)
    val secondRover = roverService.getRoverDetailsAndExplore(marsTerrain, locationService)
    locationService.checkIntersections(firstRover, secondRover)
}
