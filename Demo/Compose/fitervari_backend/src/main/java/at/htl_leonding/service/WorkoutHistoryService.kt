package at.htl_leonding.service

import at.htl_leonding.model.Customer
import at.htl_leonding.model.Workout
import at.htl_leonding.model.WorkoutHistory
import at.htl_leonding.repository.CustomerRepository
import at.htl_leonding.repository.WorkoutHistoryRepository
import at.htl_leonding.repository.WorkoutRepository
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class WorkoutHistoryService {
    @Inject
    lateinit var repository: WorkoutHistoryRepository

    @Inject
    lateinit var customerRepository: CustomerRepository

    @Inject
    lateinit var workoutRepository: WorkoutRepository

    fun getById(id: Long): WorkoutHistory {
        return repository.findById(id)
    }

    fun updateWorkoutHistory(workout: WorkoutHistory, id: Long) {
        val forUpdate = repository.findById(id)
        forUpdate.copyValues(workout)
    }

    fun deleteWorkoutHistory(id: Long) {
        val forDeletion = repository.findById(id)
        repository.delete(forDeletion)
    }

    fun getCustomerById(id: Long?): Customer {
        return customerRepository.findById(id)
    }

    fun getWorkoutById(id: Long?): Workout {
        return workoutRepository.findById(id)
    }
}