package local.sport.Controllers

import com.sun.net.httpserver.HttpsServer
import local.sport.Models.Event
import local.sport.Repository.EventRepository
import local.sport.Service.EventService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.client.HttpStatusCodeException
import org.springframework.web.server.ResponseStatusException
import java.util.UUID

@Controller //definierter Endpunkt dieses Programms für HTTP-Requests
class EventController (private val service: EventService){

    @GetMapping("/events")
    @ResponseBody
    fun getEvents(): String{
        val events = service.getAll()
        return "Events: \n\n${ events.joinToString(",\n\n ") }"
    }

    @GetMapping("/events/{id}")
    @ResponseBody
    fun getEvent(@PathVariable("id") id: UUID): String{
        val event:Event = service.getByID(id)
            ?: throw ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Event mit id: $id nicht gefunden"
            )
        return event.toString()
    }

    @PostMapping("/events")
    @ResponseStatus(HttpStatus.CREATED)
    fun addEvent(name: String /*Query Parameter: ?name=Jonas*/ ){
        val event = Event()
        event.name = name
        service.save(event)
    }

    @PutMapping("/events/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateEventByID ( @PathVariable("id") id: UUID, @RequestParam("name") nameParam:String ) {/*Query Parameter
        1. Spring Boot interpretiert unannotierte Parameter mit einfachen Datentypen (wie String) standardmäßig als Query-Parameter. Der URL-Zusatz ?newName=... wird automatisch dem Parameter newName zugewiesen.
        2. explizit wäre: fun updateEventByID(@PathVariable("id") id: UUID, @RequestParam("newName") newName: String)
       */
        val event: Event = service.getByID(id)
            ?: throw ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Event mit id $id nicht gefunden"
            )
        event.name = nameParam
        service.save(event)
    }

    @DeleteMapping("/events/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteEvent(@PathVariable("id") id: UUID){
        service.delete(id)
    }
}
