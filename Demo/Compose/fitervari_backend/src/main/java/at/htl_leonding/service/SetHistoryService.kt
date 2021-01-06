package at.htl_leonding.service

import at.htl_leonding.model.ExerciseHistory
import at.htl_leonding.model.SetHistory
import at.htl_leonding.model.WorkoutHistory
import at.htl_leonding.repository.ExerciseHistoryRepository
import at.htl_leonding.repository.SetHistoryRepository
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class SetHistoryService {

    @Inject
    lateinit var repository: SetHistoryRepository

    @Inject
    lateinit var exerciseHistoryRepository: ExerciseHistoryRepository

    fun getById(id: Long): SetHistory {
        return repository.findById(id)
    }

    fun updateSetHistory(setHistory: SetHistory, id: Long){
        val forUpdate = repository.findById(id)
        forUpdate.copyValues(setHistory)
    }

    fun deleteSetHistory(id: Long){
        val forDeletion = repository.findById(id)
        repository.delete(forDeletion)
    }

    fun getExerciseHistoryById(id: Long?): ExerciseHistory {
        return exerciseHistoryRepository.findById(id)
    }
}