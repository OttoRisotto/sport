package local.sport.Models

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.UUID

@Entity
class Event {
    @Id
    val id: UUID = UUID.randomUUID()
    var name: String = ""
    var open: Boolean = false
    var createdAt: LocalDateTime= LocalDateTime.now()

    @ManyToOne
    var comment: Comment? = null

    override fun toString(): String {
        var openText="is open"
        if (!open){
            openText="is closed"
        }
        val formatter= DateTimeFormatter.ofPattern("dd.MM.yy HH:mm")
        val formattedCreatedAt=createdAt.format(formatter)

        return "$name($id, $openText, created: $formattedCreatedAt)"
    }
}
