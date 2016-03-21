package app.core.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Vladislav on 12/22/2015.
 */

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_seq")
    @SequenceGenerator(name = "comment_seq", sequenceName = "comment_seq", allocationSize = 1)
    @Column(name="comment_id", nullable = false)
    private Long id;

    @Column(name="text", nullable = false)
    private String text;

//    @Column(name="author", nullable = false)
//    private String author;

    @Column(name="comment_date", nullable = false)
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="suggestion_id")
    private Suggestion suggestion;

    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User author;


    private Comment() {
    }

    public Comment(String text, User author, Date date) {
        this.text = text;
        this.author = author;
        this.date = date;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public User getAuthor() {
        return author;
    }

    public Date getDate() {
        return date;
    }

    public Suggestion getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(Suggestion suggestion)
    {
        this.suggestion = suggestion;
    }

}
