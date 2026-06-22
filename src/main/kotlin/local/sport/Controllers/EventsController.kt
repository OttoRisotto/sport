package local.sport.Controllers

import local.sport.Models.Event
import local.sport.Service.EventService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class EventsController (private val serv: EventService){
    @GetMapping("/")
    fun showEvents(model: Model): String{
        val events = serv.getAllEvents()
        model.addAttribute("events", events)
        return "Events/showEvents" // referenziert das templates/Events/showEvents.ftlh
    }

    @PostMapping("/events")
    fun saveEvents(name: String): String{
        val event: Event = Event()
        event.name = name
        serv.saveEvent(event)
        return "redirect:/"
    }

}
