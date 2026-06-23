package local.sport.Service

import local.sport.Models.Event
import local.sport.Repository.EventRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.UUID

@Service
class EventsServiceImpl(private val repo: EventRepository) : EventService{

    override fun getAllEvents(): List<Event> {
       return repo.getAllEvents()
    }

    override fun updateEvent(id: UUID, name:String?) {
        val event = getEventByID(id)
        if (name == ""){

        }
        if(name != null && name != "") {event.name = name}
        repo.save(event)
    }

    override fun getEventByID(id: UUID): Event {
        return repo.getEventByIdOrNull(id)?: throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Event mit id $id nicht gefunden")
    }

    override fun saveEvent(event: Event) {
        repo.save(event)
    }

    override fun deleteEvent(id:UUID) {
        repo.deleteById(id)
    }
}