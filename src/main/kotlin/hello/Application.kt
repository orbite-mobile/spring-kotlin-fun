package hello

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.PropertySource
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
@PropertySource("classpath:global.properties")
class Application {

    private val log = LoggerFactory.getLogger(Application::class.java)

    @Bean
    fun init(repository: LightsRepository) = CommandLineRunner {
        true
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}
