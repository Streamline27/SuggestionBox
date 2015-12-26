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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="comment_id", nullable = false)
    private Long id;

    @Column(name="text", nullable = false)
    private String text;

    @Column(name="author", nullable = false)
    private String author;

    @Column(name="date", nullable = false)
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="suggestion_id", nullable = false)
    private Suggestion suggestion;

    private Comment() {
    }

    public Comment(String text, String author, Date date) {
        this.text = text;
        this.author = author;
        this.date = date;
        this.suggestion = suggestion;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAuthor(String author) {
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

    public String getAuthor() {
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
