package app.core.commands.comments.get;

import app.core.commands.DomainCommandHandler;
import app.core.database.CommentDAO;
import app.core.database.SuggestionDAO;
import app.core.domain.Suggestion;
import app.core.services.DTOConverter;
import app.dto.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Vladislav on 12/29/2015.
 */
@Component
public class GetSuggestionCommentsHandler
        implements DomainCommandHandler<GetSuggestionCommentsCommand, GetSuggestionCommentsResult> {

    @Autowired SuggestionDAO suggestionDAO;
    @Autowired CommentDAO commentDAO;
    @Autowired DTOConverter converter;

    @Override
    public GetSuggestionCommentsResult execute(GetSuggestionCommentsCommand command) {
        Suggestion suggestion = getRequiredSuggestion(command);
        List<CommentDTO> comments = getCommentsFromSuggestion(suggestion);

        return new GetSuggestionCommentsResult(comments);
    }

    @Override
    public Class getCommandType() {
        return GetSuggestionCommentsCommand.class;
    }


    /* Private helper methods */
    private Suggestion getRequiredSuggestion(GetSuggestionCommentsCommand command) {
        Long suggestionID = command.getSuggestionId();
        return suggestionDAO.getById(suggestionID);
    }
    private List<CommentDTO> getCommentsFromSuggestion(Suggestion suggestion) {
        return converter.createCommentDTOs(suggestion.getComments());
    }
}
