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

    override fun toString(): String {
        return "$content($id)"
    }
}
