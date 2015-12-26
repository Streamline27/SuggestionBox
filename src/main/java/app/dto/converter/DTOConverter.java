package app.dto.converter;

import app.core.database.CommentDAO;
import app.core.domain.Comment;
import app.core.domain.Suggestion;
import app.dto.CommentDTO;
import app.dto.SuggestionDTO;

import java.util.List;

/**
 * Created by Vladislav on 12/26/2015.
 */
public interface DTOConverter {
    List<SuggestionDTO> convertSuggestionsToDto(List<Suggestion> suggestions);
    SuggestionDTO convertSuggestionToDto(Suggestion suggestion);

    List<CommentDTO> convertCommentsToDto(List<Comment> comments);
    CommentDTO convertCommentToDto(Comment comment);

    List<Comment> convertDtoToComments(List<CommentDTO> commentDTOs);
    Comment convertDtoToComment(CommentDTO commentDTO);

    List<Suggestion> convertDtoToSuggestions(List<SuggestionDTO> suggestionDTOs);
    Suggestion convertDtoToSuggestion(SuggestionDTO suggestionDTO);

}
