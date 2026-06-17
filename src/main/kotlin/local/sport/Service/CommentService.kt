package local.sport.Service

import local.sport.Models.Event
import java.util.UUID

interface CommentService {
    fun getAll(event:Event?): List<Event>
    fun getById(id: UUID)
    fun save(content: String)
    fun delete(id: UUID)
}
