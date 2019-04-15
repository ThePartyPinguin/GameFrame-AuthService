package authservice.model.dto.response.token;

import authservice.model.dto.response.Response;

public class TokenValidateResponse extends Response {

    private boolean isValid;
    private long userId;

    public TokenValidateResponse(int responseCode, String responseMessage, boolean isValid, long userId) {
        super(responseCode, responseMessage);
        this.isValid = isValid;
        this.userId = userId;
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
}
