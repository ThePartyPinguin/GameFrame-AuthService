package authservice.model.dto.response.token;

import authservice.model.dto.response.Response;

public class TokenValidateResponse extends Response {

    private boolean isValid;
    private long userId;
    private String token;

    public TokenValidateResponse(int responseCode, String responseMessage, boolean isValid, long userId, String token) {
        super(responseCode, responseMessage);
        this.isValid = isValid;
        this.userId = userId;
        this.token = token;
    }

    public TokenValidateResponse(int responseCode, String responseMessage) {
        super(responseCode, responseMessage);
    }

    public TokenValidateResponse() {
    }

    public boolean isValid() {
        return isValid;
    }

    public long getUserId() {
        return userId;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
