package local.sport.Service

import local.sport.Models.Comment
import local.sport.Models.Event
import java.util.UUID

interface CommentService {
    fun getCommentsByEventId(eventId: UUID): List<Comment>
    fun getCommentById(id: UUID): Comment
    fun saveComment(content: String, eventId: UUID)
    fun deleteComment(id: UUID)
}
