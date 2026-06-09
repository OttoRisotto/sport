package local.sport.Service

import local.sport.Models.Event
import local.sport.Repository.EventRepository
import org.springframework.stereotype.Service
import java.util.UUID
import javax.swing.text.html.parser.Entity

@Service
class EventsServiceImpl(private val repo: EventRepository) : EventService{

    override fun getAll(): List<Event> {
       return repo.getAllEvents()
    }

    override fun getAll(open: Boolean): List<Event> {
        return if(open){
            repo.findEventsByOpenTrue()
        }else{
            repo.findEventsByOpenFalse()
        }
    }

    override fun getByID(id: UUID): Event? {
        return repo.getEventByIdOrNull(id)
    }

    override fun save(event: Event) {
        repo.save(event)
    }

    override fun delete(id:UUID) {
        repo.deleteById(id)
    }
}