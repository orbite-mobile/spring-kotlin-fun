package hello

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class LightsController(val service: LightsService) {


    @GetMapping("/")
    fun findAll() = service.findAll()

    @GetMapping("/green")
    fun findGreen() = service.findGreen()

    @GetMapping("/red")
    fun findRed() = service.findRed()

    @GetMapping("/on")
    fun findOn() = service.findOn()

    @GetMapping("/off")
    fun findOff() = service.findOff()

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long) = service.findById(id)

    @GetMapping("/turnoff/{id}")
    fun turnOff(@PathVariable id: Long) = service.turnOff(id)

    @GetMapping("/turnon/{id}")
    fun turnOn(@PathVariable id: Long) = service.turnOn(id)

    @GetMapping("/algorithms")
    fun listAlgorithms() = service.findAlgorithms()

    @GetMapping("/algorithms/current")
    fun findCurrent() = service.findCurrent()

    @GetMapping("/algorithms/set/{name}")
    fun listAlgorithms(@PathVariable name: String) = service.setAlgorithm(name)

}