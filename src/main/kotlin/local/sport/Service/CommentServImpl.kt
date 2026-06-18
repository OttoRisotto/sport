package local.sport.Service

import local.sport.Models.Comment
import local.sport.Models.Event
import local.sport.Repository.CommentRepo
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CommentServImpl(private val repo: CommentRepo) : CommentService{

    override fun getAllComments(): List<Comment> {
        return repo.getAllComments()
    }

    override fun getById(id: UUID): Comment {
        return repo.findCommentById(id)
    }

    override fun saveComment(content: String) {
        val comment = Comment()
        comment.content = content
        repo.save(comment)
    }

    override fun deleteComment(id: UUID) {
        val comment = getById(id)
        repo.delete(comment)
    }
}
