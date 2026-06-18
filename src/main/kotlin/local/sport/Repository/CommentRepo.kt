package local.sport.Repository

import local.sport.Models.Comment
import local.sport.Models.Event
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface CommentRepo: CrudRepository<Comment, UUID>{

    @Query("SELECT c FROM Comment c")
    fun getAllComments(): List<Comment>

    @Query("SELECT c FROM Comment c WHERE c.event = :event")
    fun getCommentsByEvent(event: Event): List<Comment>

    fun getCommentById(id: UUID): Comment?

}
