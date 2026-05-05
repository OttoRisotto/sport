package local.sport.Models

import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.util.Date
import java.util.UUID

@Entity
class Event {
    @Id
    val id: UUID = UUID.randomUUID()
    var name: String = ""
    var open: Boolean = false
    var createdAt: Date = Date()

    override fun toString(): String {
        return "Event ($name, $id, open: $open, created: ${createdAt.time})"
    }
}