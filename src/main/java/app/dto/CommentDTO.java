package app.dto;

import app.core.domain.Comment;

import java.util.Date;

/**
 * Created by Vladislav on 12/24/2015.
 */
public class CommentDTO {
    private Long id;
    private String text;
    private String author;
    private Date date;

    public CommentDTO(Comment comment){
        id = comment.getId();
        text = comment.getText();
        author = comment.getAuthor();
        date = comment.getDate();
    }

    public CommentDTO(Long id, String text, String author, Date date) {
        this.id = id;
        this.text = text;
        this.author = author;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
