package at.htl_leonding.model

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "trainer")
class Trainer(
        name: String,
        @Column(name = "trainer_since")
        var trainerSince: LocalDate,
        pictureId: Int
) : Person(name, true, pictureId) {
    fun copyValues(other: Trainer) {
        this.pictureId = other.pictureId
        this.trainerSince = other.trainerSince
    }
}