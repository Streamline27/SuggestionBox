package app.core.commands.comments.create;

import app.core.commands.DomainCommandHandler;
import app.core.commands.comments.CommentConverter;
import app.core.database.SuggestionDAO;
import app.core.domain.Comment;
import app.core.domain.Suggestion;
import app.core.services.CommentingService;
import app.dto.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Vladislav on 12/29/2015.
 */
@Component
public class CreateCommentCommandHandler implements DomainCommandHandler<CreateCommentCommand, CreateCommentResult> {
    @Autowired SuggestionDAO suggestionDAO;
    @Autowired CommentingService commentingService;
    @Autowired CommentConverter converter;

    @Override
    public CreateCommentResult execute(CreateCommentCommand command) {
        Suggestion suggestion = getSuggestion(command);
        Comment comment = getComment(command);

        commentingService.commentOnSuggestion(comment, suggestion);
        return new CreateCommentResult(convertToDTO(comment));
    }

    private CommentDTO convertToDTO(Comment comment) {
        return converter.toDTO(comment);
    }

    private Comment getComment(CreateCommentCommand command) {
        return converter.fromDTO(command.getCommentDTO());
    }

    private Suggestion getSuggestion(CreateCommentCommand command) {
        return suggestionDAO.getById(command.getSuggestionId());
    }

    @Override
    public Class getCommandType() {
        return CreateCommentCommand.class;
    }
}
