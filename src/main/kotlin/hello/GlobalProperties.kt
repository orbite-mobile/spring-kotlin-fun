package hello

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Component
import java.awt.Color

@Component
@PropertySource("classpath:global.properties")
@ConfigurationProperties
open class GlobalProperties {

    var lights: Int = 0
}
