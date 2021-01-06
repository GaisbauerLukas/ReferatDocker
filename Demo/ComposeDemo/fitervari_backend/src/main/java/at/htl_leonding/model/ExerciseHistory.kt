package at.htl_leonding.model

import io.quarkus.hibernate.orm.panache.PanacheEntity
import javax.persistence.*
import kotlin.collections.Set

@Entity
@Table(name = "exercise_history")
data class ExerciseHistory(
        @ManyToOne
        @JoinColumn(name = "workout_history_id")
        var workoutHistory: WorkoutHistory
) : PanacheEntity() {
    fun copyValues(other: ExerciseHistory) {
        this.workoutHistory = other.workoutHistory
    }
}