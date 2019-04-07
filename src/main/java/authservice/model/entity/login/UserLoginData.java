package authservice.model.entity.login;

import javax.persistence.*;

@Entity
public class UserLoginData {

    @Column(name = "USER_EMAIL", nullable = false)
    @Id
    private String email;

    @Column(name = "USER_USERNAME", nullable = false)
    private String userName;

    @Column(name = "USER_PWD", nullable = false, length = 75)
    private String password;

    @Column(name = "USER_ID")
    private long userId;

    @Column(name = "USER_ROLE")
    private String userRole;


    public UserLoginData(String email, String userName, String password) {
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    public UserLoginData() {
    }

    public String getUserName() {
        return userName;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
