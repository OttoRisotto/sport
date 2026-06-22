package local.sport.Service

import local.sport.Models.Comment
import local.sport.Models.Event
import local.sport.Repository.CommentRepo
import org.apache.coyote.Response
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.UUID

@Service
class CommentServImpl(private val cRepo: CommentRepo, private val eServ: EventService) : CommentService{

    override fun getComment(eId: UUID, cId: UUID): Comment {
        val comment = cRepo.getCommentById(cId)
            ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST, "User with id $cId Not found")

        if (comment.event.id != eId){
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Comment($cId) belongs to the Event(${comment.event.id}, you requested an EventID $eId)")
        }
        return comment
    }

    override fun getCommentsByEventId(eventId: UUID): List<Comment> {
        val event = eServ.getEventByID(eventId)
        return cRepo.getCommentsByEvent(event)
    }

    override fun updateComment(content: String, eId: UUID, cId: UUID) {
        val comment = getComment(eId, cId)
        saveComment(content, eId)
    }

    override fun saveComment(content: String, eventId: UUID, comment: Comment) {
        val comment = comment
        comment.content = content
        comment.event = eServ.getEventByID(eventId)
        cRepo.save(comment)
    }

    override fun deleteComment(id: UUID) {
        cRepo.deleteById(id)
    }
}
