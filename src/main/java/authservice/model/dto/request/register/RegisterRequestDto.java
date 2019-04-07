package authservice.model.dto.request.register;

public class RegisterRequestDto {

    private String userName;
    private String email;
    private String password;

    public RegisterRequestDto() {
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
