package at.htl_leonding.model

import io.quarkus.hibernate.orm.panache.PanacheEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "news_letter")
class NewsLetter(
        @Column(name = "title")
        var title: String,
        @Column(name = "body")
        var body: String,
        @Column(name = "imageUrl")
        var imageUrl: String

) : PanacheEntity() {
    fun copyValues(other: NewsLetter) {

    }
}