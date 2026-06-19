package local.sport.Controllers

import local.sport.Service.EventService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class EventsController (private val serv: EventService){
    @GetMapping("/")
    fun showEvents(model: Model): String{
        val events = serv.getAllEvents()
        model.addAttribute("events", events)
        return "Events/showEvents" // referenziert das templates/Events/showEvents.ftlh
    }
}
