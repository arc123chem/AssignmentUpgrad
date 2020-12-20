package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

  //The method calls the createComment() method in the Repository and passes the comment to be persisted in the database
    public Comment createComment(Comment comment) {
        return commentRepository.createComment(comment);
    }

    //The method calls the getCommentsById() method in the Repository and passes the title of the image to be fetched

    public List<Comment> getCommentsById(Integer imageId){

        return commentRepository.getCommentsById(imageId);
    }

}
