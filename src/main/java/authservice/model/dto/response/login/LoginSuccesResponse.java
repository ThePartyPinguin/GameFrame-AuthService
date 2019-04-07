package authservice.model.dto.response.login;

import authservice.model.dto.response.Response;

public class LoginSuccesResponse extends Response {

    private String token;

    public LoginSuccesResponse(int responseCode, String responseMessage, String token) {
        super(responseCode, responseMessage);
        this.token = token;
    }

    public LoginSuccesResponse(int responseCode, String responseMessage) {
        super(responseCode, responseMessage);
    }

    public LoginSuccesResponse() {
    }

    public String getToken() {
        return token;
    }
}
