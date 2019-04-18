package authservice.model.dto.request.register;

public class RegisterNewUserRequest {

    private long userId;
    private String userName;
    private String email;

    public RegisterNewUserRequest(long userId, String userName, String email) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
    }

    public long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

}
