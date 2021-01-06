package at.htl_leonding.model

import io.quarkus.hibernate.orm.panache.PanacheEntity
import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Person")
open class Person(
        @Column(name = "name")
        var name: String,
        @Column(name = "is_trainer")
        var is_Trainer: Boolean,
        @Column(name = "picture_id")
        var pictureId: Int

) : PanacheEntity() {
    fun copyValues(other: Person) {
        this.name = other.name
        this.is_Trainer = other.is_Trainer
        this.pictureId = other.pictureId
    }
}