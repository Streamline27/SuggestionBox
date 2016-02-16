package app.core.domain;

import org.hibernate.mapping.Bag;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Vladislav on 12/20/2015.
 */

@Entity
@Table(name = "suggestions")
public class Suggestion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="suggestion_id", nullable = false)
    private Long id;

    @Column(name="title", nullable = false)
    public String title;

    @Column(name="upvotes", nullable = false)
    private Long upvotes;

    @OneToMany(mappedBy = "suggestion", fetch = FetchType.LAZY)
    private List<Comment> comments = new ArrayList<>();


    public Suggestion() {
    }

    public Suggestion(String title, Long upvotes) {
        this.title = title;
        this.upvotes = upvotes;
    }

    public Suggestion(Long id, String title, Long upvotes) {
        this.title = title;
        this.upvotes = upvotes;
        this.id = id;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Comment> getComments(){
        return comments;
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
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

    public void addComment(Comment comment){
        //comments.add(comment);
        comment.setSuggestion(this);
    }

}
