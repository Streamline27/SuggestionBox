package app.dto.converter;

import app.core.domain.Comment;
import app.core.domain.Suggestion;
import app.dto.CommentDTO;
import app.dto.SuggestionDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladislav on 12/27/2015.
 */
public class DTOConverterImpl implements DTOConverter{

    @Override
    public List<SuggestionDTO> convertSuggestionsToDto(List<Suggestion> suggestions) {
        List<SuggestionDTO> suggestionDTOs = new ArrayList<>();
        for (Suggestion suggestion : suggestions) suggestionDTOs.add(convertSuggestionToDto(suggestion));
        return  suggestionDTOs;
    }

    @Override
    public SuggestionDTO convertSuggestionToDto(Suggestion suggestion) {
        SuggestionDTO suggestionDTO = new SuggestionDTO();
        suggestionDTO.setId(suggestion.getId());
        suggestionDTO.setTitle(suggestion.getTitle());
        suggestionDTO.setUpvotes(suggestion.getUpvotes());

        List<CommentDTO> commentDTOs = convertCommentsToDto(suggestion.getComments());
        suggestionDTO.setComments(commentDTOs);
        return suggestionDTO;
    }

    @Override
    public List<CommentDTO> convertCommentsToDto(List<Comment> comments) {
        List<CommentDTO> commentDTOs = new ArrayList<>();
        for (Comment comment : comments) commentDTOs.add(convertCommentToDto(comment));
        return commentDTOs;
    }

    @Override
    public CommentDTO convertCommentToDto(Comment comment) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(comment.getId());
        commentDTO.setText(comment.getText());
        commentDTO.setAuthor(comment.getAuthor());
        commentDTO.setDate(comment.getDate());
        return  commentDTO;
    }

    @Override
    public List<Comment> convertDtoToComments(List<CommentDTO> commentDTOs) {
        List<Comment> comments = new ArrayList<>();
        for (CommentDTO commentDTO : commentDTOs) comments.add(convertDtoToComment(commentDTO));
        return comments;
    }

    @Override
    public Comment convertDtoToComment(CommentDTO commentDTO) {
        return new Comment(commentDTO.getText(), commentDTO.getAuthor(), commentDTO.getDate());
    }

    @Override
    public List<Suggestion> convertDtoToSuggestions(List<SuggestionDTO> suggestionDTOs) {
        List<Suggestion> suggestions = new ArrayList<>();
        for (SuggestionDTO suggestionDTO: suggestionDTOs) suggestions.add(convertDtoToSuggestion(suggestionDTO));
        return suggestions;
    }

    @Override
    public Suggestion convertDtoToSuggestion(SuggestionDTO suggestionDTO) {
        Suggestion suggestion = new Suggestion(suggestionDTO.getTitle(), suggestionDTO.getUpvotes());
        suggestion.setComments(convertDtoToComments(suggestionDTO.getComments()));
        return suggestion;
    }
}
