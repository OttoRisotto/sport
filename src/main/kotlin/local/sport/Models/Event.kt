package local.sport.Models

import java.util.UUID

class Event {
    val id: UUID = UUID.randomUUID()
    var name: String = ""

    override fun toString(): String {
        return "Treffen($name, $id)"
    }
}