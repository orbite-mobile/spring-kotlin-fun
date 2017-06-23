package hello

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class TrafficLight(
        var isOn: Boolean,
        val position: Int,
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = -1)

