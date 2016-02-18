package app.core.commands.comments;

import app.core.database.UserDAO;
import app.core.domain.Comment;
import app.core.domain.User;
import app.dto.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladislav on 2/18/2016.
 */
@Component
public class CommentConverter {
    @Autowired
    UserDAO userDAO;

    public List<CommentDTO> toDTOs(List<Comment> comments) {
        List<CommentDTO> commentDTOs = new ArrayList<>();
        for (Comment comment : comments) commentDTOs.add(toDTO(comment));
        return commentDTOs;
    }

    public CommentDTO toDTO(Comment comment) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(comment.getId());
        commentDTO.setText(comment.getText());
        commentDTO.setAuthor(comment.getAuthor().getFirstName());
        commentDTO.setDate(comment.getDate());
        return  commentDTO;
    }

    public List<Comment> fromDTOs(List<CommentDTO> commentDTOs) {
        List<Comment> comments = new ArrayList<>();
        for (CommentDTO commentDTO : commentDTOs) comments.add(fromDTO(commentDTO));
        return comments;
    }

    public Comment fromDTO(CommentDTO commentDTO) {
        /*TODO Make sure that there is always an author by Authentication */
        User user = userDAO.getByLogin(commentDTO.getAuthor());
        return new Comment(commentDTO.getText(), user, commentDTO.getDate());
    }

}
