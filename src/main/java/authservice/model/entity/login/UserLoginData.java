package authservice.model.entity.login;

import javax.persistence.*;
import java.util.Date;

@Entity
public class UserLoginData {

    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public long userId;

    @Column(name = "USER_EMAIL", nullable = false)
    private String email;

    @Column(name = "USER_USERNAME", nullable = false)
    private String userName;

    @Column(name = "USER_PWD", nullable = false, length = 75)
    private String password;

    @Column(name = "USER_ROLE")
    private String userRole;

    @Column(name = "USER_TOKEN")
    private String token;

    @Column(name = "USER_LAST_LOGIN")
    private Date lastLogin;



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

    public void setUserRole(Role userRole) {
        this.userRole = userRole.getAuthority();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }
}
