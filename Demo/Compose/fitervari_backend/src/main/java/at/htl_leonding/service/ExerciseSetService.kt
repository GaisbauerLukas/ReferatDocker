package at.htl_leonding.service

import at.htl_leonding.model.Exercise
import at.htl_leonding.model.ExerciseHistory
import at.htl_leonding.model.ExerciseSet
import at.htl_leonding.model.SetHistory
import at.htl_leonding.repository.ExerciseRepository
import at.htl_leonding.repository.ExerciseSetRepository
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class ExerciseSetService {

    @Inject
    lateinit var repository: ExerciseSetRepository

    @Inject
    lateinit var exerciseRepository: ExerciseRepository

    fun getById(id: Long): ExerciseSet {
        return repository.findById(id)
    }

    fun updateExerciseSet(setHistory: ExerciseSet, id: Long) {
        val forUpdate = repository.findById(id)
        forUpdate.copyValues(setHistory)
    }

    fun deleteExerciseSet(id: Long) {
        val forDeletion = repository.findById(id)
        repository.delete(forDeletion)
    }

    fun gerExerciseById(id: Long?): Exercise {
        return exerciseRepository.findById(id)
    }
}