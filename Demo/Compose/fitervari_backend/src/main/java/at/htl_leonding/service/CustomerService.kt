package at.htl_leonding.service

import at.htl_leonding.model.Customer
import at.htl_leonding.model.Trainer
import at.htl_leonding.repository.CustomerRepository
import at.htl_leonding.repository.PersonRepository
import at.htl_leonding.repository.TrainerRepository
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class CustomerService {

    @Inject
    lateinit var repository: CustomerRepository

    @Inject
    lateinit var trainerRepository: TrainerRepository

    @Inject
    lateinit var personRepository: PersonRepository

    fun test(): String {
        return "trainerservice test"
    }

    fun getById(id: Long): Customer {
        return repository.findById(id)
    }

    fun addCustomer(newCustomer: Customer) {
        this.repository.persist(newCustomer)
    }

    fun updateCustomer(customer: Customer, id: Long) {
        val forUpdate = repository.findById(id)
        val personForUpdate = personRepository.findById(id)
        personForUpdate.copyValues(customer)
        forUpdate.copyValues(customer)
    }

    fun deleteCustomer(id: Long) {
        val forDeletion = repository.findById(id)
        repository.delete(forDeletion)
    }

    fun getTrainerPerId(id: Long): Trainer {
        return trainerRepository.findById(id)
    }
}