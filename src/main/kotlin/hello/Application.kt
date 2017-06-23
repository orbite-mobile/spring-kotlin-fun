package hello

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class Application {

    private val log = LoggerFactory.getLogger(Application::class.java)


    @Bean
    fun init(repository: LightsRepository) = CommandLineRunner {
        repository.save(TrafficLight(false, 1))
        repository.save(TrafficLight(false, 2))
        repository.save(TrafficLight(false, 3))
        repository.save(TrafficLight(false, 4))
        repository.save(TrafficLight(false, 5))
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}
