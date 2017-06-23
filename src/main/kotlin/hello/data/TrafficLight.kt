package hello.data

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class TrafficLight(
        var color: Color = Color.RED,
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = -1) {

    fun turnOff(): TrafficLight {
        color = Color.ORANGE
        return this
    }

    fun turnRed(): TrafficLight {
        color = Color.RED
        return this
    }
}
