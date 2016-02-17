package app.core.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Vladislav on 2/8/2016.
 */

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id", nullable = false)
    private Long id;

    @Column(name="login", nullable = false, unique = true)
    private String login;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name="firstname", nullable = false)
    private String firstName;

    @Column(name="lastname", nullable = false)
    private String lastName;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Comment> comments;

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public User(String username, String password, String firstName, String lastName) {
        this.login = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    private User() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return login;
    }


    public void setUsername(String username) {
        this.login = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
