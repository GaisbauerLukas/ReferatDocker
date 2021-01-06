package at.htl_leonding.model


import at.htl_leonding.model.Exercise
import io.quarkus.hibernate.orm.panache.PanacheEntity
import javax.persistence.*

@Entity
@Table(name = "set")
data class ExerciseSet(
        var repeditions: Int?,
        var distance: Double?,
        var weight: Double?,
        var time: Double?,
        @Column(name = "set_number")
        var setNumber: Int,
        var type: String,
        @ManyToOne
        @JoinColumn(name = "exercise_id")
        var exercise: Exercise
) : PanacheEntity() {
    fun copyValues(other: ExerciseSet) {
        this.repeditions = other.repeditions
        this.distance = other.distance
        this.weight = other.weight
        this.time = other.time
        this.setNumber = other.setNumber
        this.type = other.type
        this.exercise = other.exercise
    }
}
