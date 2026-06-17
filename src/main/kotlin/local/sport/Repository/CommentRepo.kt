package local.sport.Repository

import local.sport.Models.Comment
import org.springframework.data.repository.CrudRepository
import java.util.UUID


interface CommentRepo: CrudRepository<Comment, UUID>{

}