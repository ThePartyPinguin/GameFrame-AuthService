package authservice.model.dto.response.register;

import authservice.model.dto.response.Response;

public class RegisterSuccesResponse extends Response {

    private String token;

    public RegisterSuccesResponse(int responseCode, String responseMessage, String token) {
        super(responseCode, responseMessage);
        this.token = token;
    }

    public RegisterSuccesResponse() {
    }

    public String getToken() {
        return token;
    }
}
