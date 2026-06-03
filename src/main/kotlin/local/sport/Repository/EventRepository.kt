package local.sport.Repository

import local.sport.Models.Event
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface EventRepository: CrudRepository<Event, UUID> {

    /* zwei Möglichkeiten
        1. @Query definieren, welcher bei fun Aufruf ausgeführt werden soll
        2. Konvention: fun <Beschreibung>
        - fun findByOpenTrue(): List<Task>
        -> aus fun-Name wird sql query abgeleitet
    */

    @Query("select e from Event e")
    fun getAllEvents(): List<Event>

    @Query("select e from Event e where e.open = true")
    fun getAllOpen(): List<Event>

    @Query("select e from Event e where e.open = true order by e.createdAt asc")
    fun getAllOpenOrderedByCreateAtAsc():List<Event>

    @Query("select e from Event e where e.id = :idParam")
    fun getEventByIdOrNull(@Param("idParam") idParam: UUID): Event?

    @Query("select e from Event e where e.open = true")
    fun findEventByOpenTrue(): List<Event>
}
