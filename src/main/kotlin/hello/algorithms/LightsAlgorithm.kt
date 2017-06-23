package hello.algorithms

import hello.data.Color
import hello.data.Roundabout
import hello.data.TrafficLight

interface LightsAlgorithm {

    var name: String

    fun chooseLightToTurnOn(roundabout: Roundabout): List<TrafficLight>?

    fun Roundabout.findLightsOn() = lights().filter { it.color != Color.ORANGE }

    fun Roundabout.findGreenLights() = lights().filter { it.color == Color.GREEN }

    fun List<TrafficLight>.turnEverySecondGreen() = getEverySecond().apply { forEach { it.color = Color.GREEN } }

    fun List<TrafficLight>.getEverySecond() = filter { indexOf(it) % 2 == 0 }

    fun List<TrafficLight>.next(light: TrafficLight) = if (last() == light) get(0) else get(indexOf(light) + 1)
}
