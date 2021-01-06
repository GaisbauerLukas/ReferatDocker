package at.htl_leonding.service

import at.htl_leonding.model.NewsLetter
import at.htl_leonding.repository.NewsLetterRepository
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class NewsLetterService {

    @Inject
    lateinit var repository: NewsLetterRepository

    fun getById(id: Long): NewsLetter {
        return repository.findById(id)
    }

    fun updateNewsLetter(newsLetter: NewsLetter, id: Long) {
        val forUpdate = repository.findById(id)
        forUpdate.copyValues(newsLetter)
    }

    fun deleteNewsLetter(id: Long) {
        val forDeletion = repository.findById(id)
        repository.delete(forDeletion)
    }
    fun getAllNewsLetters(): List<NewsLetter>{
        return repository.listAll();
    }
}