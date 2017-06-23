package hello.algorithms

import hello.data.Color
import hello.data.Roundabout
import hello.data.TrafficLight
import org.springframework.stereotype.Component

/**
 * Algorithm will set every green light at roundabout to red and lighte next to it to green.
 * If there are no green lights algorithm will turn green every second light at roundabout.
 * */
@Component
class NextAlgorithm : LightsAlgorithm {

    override var name = "next"

    override fun chooseLightToTurnOn(roundabout: Roundabout): List<TrafficLight>? {
        val lightsOn = roundabout.findLightsOn()
        if (lightsOn.isEmpty()) return null

        val greenLights = roundabout.findGreenLights()
        if (greenLights.isEmpty()) return lightsOn.turnEverySecondGreen()

        return greenLights.turnEveryRedAndEveryNextGreen(lightsOn)
    }

    fun List<TrafficLight>.turnEveryRedAndEveryNextGreen(lightsOn: List<TrafficLight>) = this + this.map {
        it.color = Color.RED
        val next = lightsOn.next(it)
        next.color = Color.GREEN
        next
    }
}