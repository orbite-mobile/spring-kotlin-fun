package hello

import hello.data.Color
import hello.data.TrafficLight
import org.springframework.data.repository.CrudRepository

interface LightsRepository : CrudRepository<TrafficLight, Long> {

    fun findById(id: Long): Iterable<TrafficLight>

    fun findByColor(color: Color): Iterable<TrafficLight>

}
