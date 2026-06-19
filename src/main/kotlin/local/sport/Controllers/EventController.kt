package local.sport.Controllers

import local.sport.Models.Event
import local.sport.Service.CommentService
import local.sport.Service.EventService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import java.util.UUID


@RestController //definierter Endpunkt dieses Programms für HTTP-Requests
@RequestMapping( produces = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE] )
class EventController (private val service: EventService){

    @GetMapping("/events")
    fun getEvents(): String{
        val events = service.getAllEvents()
        return "Events: \n\n${ events.joinToString(",\n\n ") }"
    }

    @GetMapping("/events/{id}")
    fun getEvent(@PathVariable("id") id: UUID): String{
        val event:Event = service.getEventByID(id)

        return event.toString()
    }

    @PostMapping("/events")
    @ResponseStatus(HttpStatus.CREATED)
    fun addEvent(name: String /*Query Parameter: ?name=Jonas*/ ){
        val event = Event()
        event.name = name
        service.saveEvent(event)
    }

    @PutMapping("/events/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateEventByID ( @PathVariable("id") id: UUID, @RequestParam("name") nameParam:String ) {/*Query Parameter
        1. Spring Boot interpretiert unannotierte Parameter mit einfachen Datentypen (wie String) standardmäßig als Query-Parameter. Der URL-Zusatz ?newName=... wird automatisch dem Parameter newName zugewiesen.
        2. explizit wäre: fun updateEventByID(@PathVariable("id") id: UUID, @RequestParam("newName") newName: String)
       */
        val event: Event = service.getEventByID(id)

        event.name = nameParam
        service.saveEvent(event)
    }

    @DeleteMapping("/events/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteEvent(@PathVariable("id") id: UUID){
        service.deleteEvent(id)
    }
}
