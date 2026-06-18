package local.sport.Service

import local.sport.Models.Event
import java.util.UUID

interface EventService {

    fun getAll(): List<Event>
    fun getAll(open: Boolean): List<Event>
    fun getByID(id: UUID): Event?

    fun save(event: Event)
    fun delete(id:UUID)
}