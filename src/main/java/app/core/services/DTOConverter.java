package app.core.services;

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
    List<SuggestionDTO> createSuggestionDTOs(List<Suggestion> suggestions);
    SuggestionDTO createSuggestionDTO(Suggestion suggestion);

    List<CommentDTO> createCommentDTOs(List<Comment> comments);
    CommentDTO createCommentDTO(Comment comment);

    List<Comment> createCommentsFromDTOs(List<CommentDTO> commentDTOs);
    Comment createCommentFromDTO(CommentDTO commentDTO);

    List<Suggestion> createSuggestionsFromDTOs(List<SuggestionDTO> suggestionDTOs);
    Suggestion createSuggestionFromDTO(SuggestionDTO suggestionDTO);

}
