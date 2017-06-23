package hello

import hello.algorithms.LightsAlgorithm
import hello.data.Color
import hello.data.Roundabout
import hello.data.TrafficLight
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.security.SecureRandom

@Service
class LightsService(val repository: LightsRepository, globalProperties: GlobalProperties) {
    private val log = LoggerFactory.getLogger(LightsService::class.java)

    @Autowired
    lateinit var algorithms: List<LightsAlgorithm>

    @Autowired
    lateinit var roundabout: Roundabout

    var algorithm: LightsAlgorithm? = null

    init {
        //todo: move properties to initialization in application class
        (1..globalProperties.lights).map { TrafficLight().save() }
    }

    fun drawRandomAlgorithm() = algorithms[SecureRandom().nextInt(algorithms.size)]

    @Scheduled(fixedRate = 5000)
    fun changeLight() {
        if (algorithm == null) algorithm = drawRandomAlgorithm()
        algorithm?.chooseLightToTurnOn(roundabout)?.forEach { it.save() }
    }

    fun findById(id: Long) = repository.findById(id)

    fun findAll() = repository.findAll()

    //todo: adjust
    fun findOn() = findRed() + findGreen()

    fun findOff() = repository.findByColor(Color.ORANGE)

    fun findGreen() = repository.findByColor(Color.GREEN)

    fun findRed() = repository.findByColor(Color.RED)

    fun findAlgorithms() = algorithms.map { it.name }

    fun findCurrent() = algorithm?.name

    fun setAlgorithm(name: String) {
        val choosen = algorithms.filter { it.name == name }
        if (choosen.isEmpty()) return
        else algorithm = choosen.first()
    }

    fun turnOff(id: Long) {
        log.info("turnOff new light id: $id")
        val list = findById(id).toList()
        if (!list.isEmpty()) list.first().turnOff().save()
    }

    fun turnOn(id: Long) {
        val list = findById(id).toList()
        if (!list.isEmpty()) list.first().turnRed().save()
    }

    fun TrafficLight.save(){
        log.info("saving new light id: $id $color")
        repository.save(this)
    }
}
