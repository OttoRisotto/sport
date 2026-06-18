package local.sport.Service

import local.sport.Models.Comment
import local.sport.Models.Event
import java.util.UUID

interface CommentService {
    fun getAllComments(): List<Comment>
    fun getById(id: UUID): Comment
    fun saveComment(content: String)
    fun deleteComment(id: UUID)
}
