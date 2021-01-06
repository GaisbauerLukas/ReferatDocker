package at.htl_leonding.service

import at.htl_leonding.model.ExerciseHistory
import at.htl_leonding.model.WorkoutHistory
import at.htl_leonding.repository.ExerciseHistoryRepository
import at.htl_leonding.repository.WorkoutHistoryRepository
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class ExerciseHistoryService {

    @Inject
    lateinit var repository: ExerciseHistoryRepository

    @Inject
    lateinit var workoutHistoryRepository: WorkoutHistoryRepository

    fun getById(id: Long): ExerciseHistory {
        return repository.findById(id)
    }

    fun updateExerciseHistory(workout: ExerciseHistory, id: Long) {
        val forUpdate = repository.findById(id)
        forUpdate.copyValues(workout)
    }

    fun deleteWorkoutHistory(id: Long) {
        val forDeletion = repository.findById(id)
        repository.delete(forDeletion)
    }

    fun getWorkoutHistoryById(id: Long?): WorkoutHistory {
        return workoutHistoryRepository.findById(id)
    }
}