package local.sport.Controllers

import com.sun.net.httpserver.HttpsServer
import local.sport.Models.Event
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

@Controller
class EventController {

    val events: ArrayList<Event> = arrayListOf()

    @GetMapping("/events")
    @ResponseBody
    fun getEvents(): String{
        return "Events: ${events.joinToString(",")}"
    }

    @GetMapping("/events/{id}")
    @ResponseBody
    fun getEvent(@PathVariable("id") id: String): String{
        for (event in events){
            if((event.id.toString()) == id.toString()) {
                return event.name
            }
        }
        throw Exception("Fehler: Event mit id: $id existiert nicht")
    }

    @PostMapping("/events")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    fun addEvent(name: String /*Query Parameter: ?name=Jonas*/ ){
        var event = Event()
        event.name = name
        events.add(event)
    }

    @PutMapping("/events/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateEventByID(@PathVariable("id") id: String, name: String){
        for(event in events){
            if(event.id.toString() == id){
                event.name = name
            }
        }
    }
    @DeleteMapping("/events/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteEvent(@PathVariable("id") id:String){
        for (event in events){
            if (event.id.toString() == id){
                events.remove(event)
                return
            }
        }
        throw Exception("Fehler: Es existiert kein Event mit der ID: $id")
    }
}

