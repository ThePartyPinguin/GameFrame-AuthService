package authservice.model.dto.response.login;

import authservice.model.dto.response.Response;

public class LoginSuccesResponse extends Response {

    private long userId;
    private String token;

    public LoginSuccesResponse(int responseCode, String responseMessage, long userId, String token) {
        super(responseCode, responseMessage);
        this.token = token;
        this.userId = userId;
    }

    public LoginSuccesResponse(int responseCode, String responseMessage) {
        super(responseCode, responseMessage);
    }

    public LoginSuccesResponse() {
    }

    public String getToken() {
        return token;
    }

    public long getUserId() {
        return userId;
    }
}
