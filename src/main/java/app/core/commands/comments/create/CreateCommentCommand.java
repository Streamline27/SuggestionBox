package app.core.commands.comments.create;

import app.core.commands.DomainCommand;
import app.dto.CommentDTO;

/**
 * Created by Vladislav on 12/29/2015.
 */
public class CreateCommentCommand implements DomainCommand<CreateCommentResult> {
    private CommentDTO commentDTO;
    private Long suggestionId;

    public CreateCommentCommand(CommentDTO commentDTO, Long suggestionId) {
        this.commentDTO = commentDTO;
        this.suggestionId = suggestionId;
    }

    public CommentDTO getCommentDTO() {
        return commentDTO;
    }

    public Long getSuggestionId() {
        return suggestionId;
    }
}
