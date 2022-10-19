package com.thedevadventure.roverkata.location

class locationService {

    fun checkIntersections(pathPoints1: List<Location>, pathPoints2: List<Location>): MutableList<Location> {
        val intersections = pathPoints1.intersect(pathPoints2.toSet()).toMutableList()
        if (intersections.isEmpty()) {
            throw Exception("No Intersections found...")
        } else {
            println("Intersection point are: $intersections")
        }
        return intersections
    }

    fun increaseX(location: Location): Location {
        return Location(location.X + 1, location.Y)
    }

    fun increaseY(location: Location): Location {
        return Location(location.X, location.Y + 1)
    }

    fun decreaseX(location: Location): Location {
        return Location(location.X - 1, location.Y)
    }

    fun decreaseY(location: Location): Location {
        return Location(location.X, location.Y - 1)
    }
}
