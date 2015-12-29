package app.core.commands.comments.get;

import app.core.commands.DomainCommandResult;
import app.dto.CommentDTO;

import java.util.List;

/**
 * Created by Vladislav on 12/29/2015.
 */
public class GetSuggestionCommentsResult implements DomainCommandResult{
    List<CommentDTO> commets;

    public GetSuggestionCommentsResult(List<CommentDTO> commets) {
        this.commets = commets;
    }

    public List<CommentDTO> getCommets() {
        return commets;
    }
}
