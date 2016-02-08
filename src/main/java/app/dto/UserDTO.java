package app.dto;

/**
 * Created by Vladislav on 2/8/2016.
 */
public class UserDTO {
    String login;
    String password;
    String firstName;
    String lastName;

    public UserDTO() {
    }

    public UserDTO(String login, String passwrod, String firstName, String lastName) {
        this.login = login;
        this.password = passwrod;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
