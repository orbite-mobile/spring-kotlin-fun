package hello

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class LightsController(val service: LightsService) {

    @GetMapping("/")
    fun findAll() = service.findAll()

    @GetMapping("/{position}")
    fun findByPosition(@PathVariable position: Int)
            = service.findByPosition(position)


}