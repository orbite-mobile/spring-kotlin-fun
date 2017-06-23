package hello

import org.springframework.data.repository.CrudRepository

interface LightsRepository : CrudRepository<TrafficLight, Long> {

    fun findByPosition(position: Int): Iterable<TrafficLight>
}
