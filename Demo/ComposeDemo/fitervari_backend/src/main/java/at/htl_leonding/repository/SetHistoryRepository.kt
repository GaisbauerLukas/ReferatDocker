package at.htl_leonding.repository

import at.htl_leonding.model.SetHistory
import io.quarkus.hibernate.orm.panache.PanacheRepository
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class SetHistoryRepository : PanacheRepository<SetHistory> {

}