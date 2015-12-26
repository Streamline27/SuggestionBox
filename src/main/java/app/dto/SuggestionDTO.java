package app.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladislav on 12/24/2015.
 */
public class SuggestionDTO {
    private Long id;
    public String title;
    private Long upvotes;
    private List<CommentDTO> comments;

    public SuggestionDTO() {
        comments = new ArrayList<>();
    }

    public SuggestionDTO(Long id, String title, Long upvotes, List<CommentDTO> comments) {
        this.id = id;
        this.title = title;
        this.upvotes = upvotes;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(Long upvotes) {
        this.upvotes = upvotes;
    }

    public List<CommentDTO> getComments() {
        return comments;
    }

    public void setComments(List<CommentDTO> comments) {
        this.comments = comments;
    }
}
