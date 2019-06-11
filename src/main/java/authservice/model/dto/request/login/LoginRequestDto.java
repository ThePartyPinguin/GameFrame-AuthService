package authservice.model.dto.request.login;


public class LoginRequestDto {

    private String loginName;
    private String password;

    //NOSONAR
    public LoginRequestDto() {
    }

    public String getLoginName() {
        return loginName;
    }

    public String getPassword() {
        return password;
    }
}
