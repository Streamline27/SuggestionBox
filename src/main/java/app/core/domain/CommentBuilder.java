package app.core.domain;

import java.util.Date;

/**
 * Created by Vladislav on 12/22/2015.
 */
public class CommentBuilder {
    private String text;
    private String author;
    private Date date;
    private Suggestion suggestion;

    public static CommentBuilder createComment(){
        return new CommentBuilder();
    }

    public Comment Build(){
        return new Comment(text, author, date);
    }

    public CommentBuilder withId(Long id){
        return this;
    }

    public CommentBuilder withText(String text){
        this.text = text;
        return this;
    }

    public CommentBuilder withAuthor(String author){
        this.author = author;
        return this;
    }

    public CommentBuilder withDate(Date date){
        this.date = date;
        return this;
    }

}
