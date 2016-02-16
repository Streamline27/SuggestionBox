package app.core.services;

import app.core.domain.Comment;
import app.core.domain.Suggestion;
import app.core.domain.User;
import app.dto.CommentDTO;
import app.dto.SuggestionDTO;
import app.dto.UserDTO;
import app.dto.UserInfoDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladislav on 12/27/2015.
 */
@Component
public class DTOConverterImpl implements DTOConverter {
    @Override
    public UserDTO createUserDTO(User user) {
        UserDTO userDTO = new UserDTO(user.getUsername(), user.getPassword(), user.getFirstName(), user.getLastName());
        return userDTO;
    }

    @Override
    public UserInfoDTO createUserInfoDTO(User user) {
        return new UserInfoDTO(
                user.getUsername(),
                user.getFirstName(),
                user.getLastName()
        );
    }

    @Override
    public List<SuggestionDTO> createSuggestionDTOs(List<Suggestion> suggestions) {
        List<SuggestionDTO> suggestionDTOs = new ArrayList<>();
        for (Suggestion suggestion : suggestions) suggestionDTOs.add(createSuggestionDTO(suggestion));
        return  suggestionDTOs;
    }

    @Override
    public SuggestionDTO createSuggestionDTO(Suggestion suggestion) {
        SuggestionDTO suggestionDTO = new SuggestionDTO();
        suggestionDTO.setId(suggestion.getId());
        suggestionDTO.setTitle(suggestion.getTitle());
        suggestionDTO.setUpvotes(suggestion.getUpvotes());
        return suggestionDTO;
    }

    @Override
    public List<CommentDTO> createCommentDTOs(List<Comment> comments) {
        List<CommentDTO> commentDTOs = new ArrayList<>();
        for (Comment comment : comments) commentDTOs.add(createCommentDTO(comment));
        return commentDTOs;
    }

    @Override
    public CommentDTO createCommentDTO(Comment comment) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(comment.getId());
        commentDTO.setText(comment.getText());
        commentDTO.setAuthor(comment.getAuthor());
        commentDTO.setDate(comment.getDate());
        return  commentDTO;
    }

    @Override
    public List<Comment> createCommentsFromDTOs(List<CommentDTO> commentDTOs) {
        List<Comment> comments = new ArrayList<>();
        for (CommentDTO commentDTO : commentDTOs) comments.add(createCommentFromDTO(commentDTO));
        return comments;
    }

    @Override
    public Comment createCommentFromDTO(CommentDTO commentDTO) {
        return new Comment(commentDTO.getText(), commentDTO.getAuthor(), commentDTO.getDate());
    }

    @Override
    public List<Suggestion> createSuggestionsFromDTOs(List<SuggestionDTO> suggestionDTOs) {
        List<Suggestion> suggestions = new ArrayList<>();
        for (SuggestionDTO suggestionDTO: suggestionDTOs) suggestions.add(createSuggestionFromDTO(suggestionDTO));
        return suggestions;
    }

    @Override
    public Suggestion createSuggestionFromDTO(SuggestionDTO suggestionDTO) {
        return new Suggestion(suggestionDTO.getId(), suggestionDTO.getTitle(), suggestionDTO.getUpvotes());
    }
}
