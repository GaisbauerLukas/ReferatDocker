package at.htl_leonding.repository

import at.htl_leonding.model.Customer
import io.quarkus.hibernate.orm.panache.PanacheRepository
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class CustomerRepository: PanacheRepository<Customer>{
}