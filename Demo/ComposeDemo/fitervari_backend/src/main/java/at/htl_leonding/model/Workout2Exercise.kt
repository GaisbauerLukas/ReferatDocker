package at.htl_leonding.model

import io.quarkus.hibernate.orm.panache.PanacheEntity
import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "workout2exercise")
data class Workout2Exercise(
        @ManyToOne
        var workout: Workout,
        @ManyToOne
        var exerciseId: Exercise
) : PanacheEntity()