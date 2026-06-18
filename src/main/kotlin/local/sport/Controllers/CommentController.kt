package local.sport.Controllers

import local.sport.Models.Comment
import local.sport.Service.CommentService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import java.util.UUID

@Controller
class CommentController(private val serv: CommentService) {

    @PostMapping("/comments")
    @ResponseStatus(HttpStatus.CREATED)
    fun saveComment(@RequestParam content: String){
        serv.saveComment(content)
    }

    @GetMapping("/comments")
    @ResponseBody
    fun getComments():List<Comment>{
        return serv.getAllComments()
    }

    @GetMapping("/comments/{id}")
    @ResponseBody
    fun getComment(@PathVariable id: UUID): Comment{
        return serv.getById(id)
    }



    @DeleteMapping("/comments/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteComment(@PathVariable id: UUID){
        serv.deleteComment(id)
    }

}
