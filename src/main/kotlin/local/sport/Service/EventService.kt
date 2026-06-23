package local.sport.Service

import local.sport.Models.Event
import java.util.UUID

interface EventService {

    fun getAllEvents(): List<Event>
    fun getEventByID(id: UUID): Event

    fun updateEvent(id: UUID, name:String?)

    fun saveEvent(event: Event)
    fun deleteEvent(id:UUID)
}
