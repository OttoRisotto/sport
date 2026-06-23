package local.sport.Controllers

import local.sport.Models.Event
import local.sport.Service.EventService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import java.util.UUID

@Controller
class EventsController (private val serv: EventService){

    @GetMapping("/")
    fun showEvents(model: Model): String{
        val events = serv.getAllEvents()
        model.addAttribute("events", events)
        return "Events/showEvents" // referenziert das templates/Events/showEvents.ftlh
    }

    @GetMapping("/events/{id}")
    fun getEvent(@PathVariable id: UUID, model: Model): String{
        val event = serv.getEventByID(id)
        model.addAttribute("event", event)
        return "Events/showEvent"
    }

    @PostMapping("/events/{id}")
    fun updateEvent(@PathVariable id: UUID,name: String): String{
        serv.updateEvent(id, name)
        val event = serv.getEventByID(id)
        return "redirect:/events/${event.id}"
    }

    @PostMapping("/events")
    fun saveEvent(@RequestParam name: String): String{
        val event: Event = Event()
        event.name = name
        serv.saveEvent(event)
        return "redirect:/"
    }

    @DeleteMapping("/events/{id}")
    fun deleteEvent(@PathVariable id: UUID): String{
        serv.deleteEvent(id)
        return "redirect:/"
    }

}
