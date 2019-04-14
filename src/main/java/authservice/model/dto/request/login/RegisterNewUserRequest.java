package authservice.model.dto.request.login;

public class RegisterNewUserRequest {

    private long userId;
    private String userName;
    private String userEmail;

    public RegisterNewUserRequest(long userId, String userName, String userEmail) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
    }

    public RegisterNewUserRequest() {
    }

    public long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }
}
