package hello

import hello.algorithms.NextAlgorithm
import hello.algorithms.RandomAlgorithm
import hello.data.Color
import hello.data.TrafficLight
import spock.lang.Specification

class LightsServiceTest extends Specification {

    def algorithms = [new NextAlgorithm(), new RandomAlgorithm()]
    def globalProperties = Mock(GlobalProperties)

    LightsService service

    TrafficLight light

    LightsRepository repository

    void setup() {
        light = new TrafficLight()
        repository = Mock(LightsRepository) {
            findAll() >> [light]
            findById(_ as Long) >> [light]
        }

        service = new LightsService(repository, globalProperties)
        service.algorithms = algorithms
    }

    def turnOnTest() {
        given:
            service.turnOff(light.id)
        when:
            service.turnOn(light.id)
        then:
            light.getColor() == Color.RED
    }

    def turnOffTest() {
        when:
            service.turnOff(light.id)
        then:
            light.getColor() == Color.ORANGE
    }

    def setAlgorithm() {
        when:
            service.setAlgorithm(name)
        then:
            service.getAlgorithm().name == name
        where:
            name << ["next", "random"]
    }
}
