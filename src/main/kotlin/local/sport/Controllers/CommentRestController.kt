package local.sport.Controllers

import local.sport.Models.Comment
import local.sport.Service.CommentService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/events/{eventId}", produces = [MediaType.APPLICATION_JSON_VALUE])
class CommentRestController(private val serv: CommentService) {

    @PostMapping("/comments")
    @ResponseStatus(HttpStatus.CREATED)
    fun saveComment(@RequestParam content: String, @PathVariable eventId: UUID){
        serv.saveComment(content, eventId)
    }

    @GetMapping("/comments")
    fun getComments(@PathVariable eventId: UUID):List<Comment>{
        return serv.getCommentsByEventId(eventId)
    }

    @GetMapping("/comments/{commentId}")
    fun getComment(@PathVariable eventId: UUID, @PathVariable commentId: UUID): Comment{
        return serv.getCommentById(commentId)
    }

    @PatchMapping("/comments/{commentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun patchComment(
            @PathVariable eventId: UUID,
            @PathVariable commentId: UUID,
            @RequestParam content: String){
        val comment = serv.getCommentById(commentId)
        comment.content = content
        serv.saveComment(content, eventId)
    }

    @DeleteMapping("/comments/{commentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteComment(@PathVariable eventId: UUID, @PathVariable commentId: UUID){
        serv.deleteComment(commentId)
    }

}
