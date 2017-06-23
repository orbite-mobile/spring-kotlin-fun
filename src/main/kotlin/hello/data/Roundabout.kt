package hello.data

import hello.LightsRepository
import org.springframework.stereotype.Component

@Component
data class Roundabout(val repository: LightsRepository) {
    fun lights() = repository.findAll()
}
