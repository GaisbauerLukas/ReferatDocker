package at.htl_leonding.service

import at.htl_leonding.model.Person
import at.htl_leonding.model.Trainer
import at.htl_leonding.repository.PersonRepository
import at.htl_leonding.repository.TrainerRepository
import java.time.LocalDate
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class TrainerService {

    @Inject
    private lateinit var trainerRepository: TrainerRepository



    fun test(): String {
        return "trainerservice test"
    }

    fun getById(id: Long): Trainer {
        return trainerRepository.findById(id)
    }

    fun addTrainer(newTrainer: Trainer){
        trainerRepository.persist(newTrainer)
    }

    fun updateTrainer(trainer: Trainer, id: Long){
        val forUpdate = trainerRepository.findById(id)
        forUpdate.copyValues(trainer)
    }

    fun deleteTrainer(id: Long){
        val forDeletion = trainerRepository.findById(id)
        trainerRepository.delete(forDeletion)
    }
}