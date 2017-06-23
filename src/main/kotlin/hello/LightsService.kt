package hello

import org.springframework.stereotype.Service

@Service
class LightsService(val repository: LightsRepository) {

    fun findByPosition(position: Int)
            = repository.findByPosition(position)

    fun findAll() = repository.findAll()
}
