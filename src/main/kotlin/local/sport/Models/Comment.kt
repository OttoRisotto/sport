package local.sport.Models

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.util.UUID

@Entity
class Comment {
    @Id
    val id = UUID.randomUUID()
    var content = ""

    @ManyToOne // viele Comments auf ein Event
    var event: Event? = null

    override fun toString(): String {
        return "$content($id)"
    }
}
