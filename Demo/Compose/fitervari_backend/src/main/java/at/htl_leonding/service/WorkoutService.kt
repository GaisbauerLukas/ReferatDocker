package at.htl_leonding.service

import at.htl_leonding.model.Person
import at.htl_leonding.model.Workout
import at.htl_leonding.repository.PersonRepository
import at.htl_leonding.repository.WorkoutRepository
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class WorkoutService {
    @Inject
    lateinit var repository: WorkoutRepository

    @Inject
    lateinit var personRepository: PersonRepository

    fun test(): String {
        return "trainerservice test"
    }

    fun getById(id: Long): Workout {
        return repository.findById(id)
    }

    fun updateWorkout(workout: Workout, id: Long) {
        val forUpdate = repository.findById(id)
        forUpdate.copyValues(workout)
    }

    fun deleteWorkout(id: Long) {
        val forDeletion = repository.findById(id)
        repository.delete(forDeletion)
    }

    fun getPersonById(id: Long?): Person {
        return personRepository.findById(id)
    }
}