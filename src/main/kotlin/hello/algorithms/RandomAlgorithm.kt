package hello.algorithms

import hello.data.Color
import hello.data.Roundabout
import hello.data.TrafficLight
import org.springframework.stereotype.Component
import java.security.SecureRandom

/**
 * Algorithm will set every green light at roundabout to red and for each a random light to green.
 * If there are no green lights algorithm will turn one random number of lights to green (minimum one).
 * */
@Component
class RandomAlgorithm : LightsAlgorithm {

    override var name = "random"

    override fun chooseLightToTurnOn(roundabout: Roundabout): List<TrafficLight>? {
        val lightsOn = roundabout.findLightsOn()
        if (lightsOn.isEmpty()) return null

        val greenLights = roundabout.findGreenLights()
        if (greenLights.isEmpty()) return lightsOn.randomSublist().apply { forEach { it.color = Color.GREEN } }

        return greenLights.turnEveryRedAndForEachRandomToGreen(lightsOn)
    }

    fun List<TrafficLight>.turnEveryRedAndForEachRandomToGreen(lightsOn: List<TrafficLight>) = this + this.map {
        it.color = Color.RED
        val next = lightsOn.findRed().random()
        next.color = Color.GREEN
        next
    }

    fun List<TrafficLight>.randomSublist(): List<TrafficLight> {
        val sublistSize = SecureRandom().nextInt(size)
        val mList = toMutableList()
        return (0..sublistSize).map {
            val choosen = mList.random()
            mList.remove(choosen)
            choosen
        }
    }

    fun List<TrafficLight>.random() = this[SecureRandom().nextInt(size)]

    fun List<TrafficLight>.findRed() = filter { it.color == Color.RED }
}