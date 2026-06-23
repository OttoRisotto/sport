package local.sport.Models

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.UUID

@Entity
class Event {
    //@Entity versucht jede Eigenschaft innerhalb der @Entity-Klasse als Tabellenspalte zu speichern
    @Id
    val id: UUID = UUID.randomUUID()
    var name: String = ""

    @Transient
    private var createdAtRaw: LocalDateTime= LocalDateTime.now()
    @Transient
    val formatter = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm")
    val createdAt=createdAtRaw.format(formatter)

    override fun toString(): String {
        return "$name($id, created: $createdAt)"
    }
}
