package at.htl_leonding.repository

import at.htl_leonding.model.Workout
import io.quarkus.hibernate.orm.panache.PanacheRepository
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class WorkoutRepository : PanacheRepository<Workout> {
}