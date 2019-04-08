package authservice.model.dto.response.register;

import authservice.model.dto.response.Response;

public class RegisterSuccesResponse extends Response {

    private long userId;
    private String token;

    public RegisterSuccesResponse(int responseCode, String responseMessage, long userId, String token) {
        super(responseCode, responseMessage);
        this.token = token;
        this.userId = userId;
    }

    public RegisterSuccesResponse() {
    }

    public String getToken() {
        return token;
    }

    public long getUserId() {
        return userId;
    }
}
