package app.core.commands.comments.create;

import app.core.commands.DomainCommandResult;
import app.dto.CommentDTO;

/**
 * Created by Vladislav on 12/29/2015.
 */
public class CreateCommentResult implements DomainCommandResult {
    CommentDTO commentDTO;

    public CreateCommentResult(CommentDTO commentDTO) {
        this.commentDTO = commentDTO;
    }

    public CommentDTO getCommentDTO() {
        return commentDTO;
    }
}
