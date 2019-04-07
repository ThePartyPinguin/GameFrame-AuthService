package authservice.model.dto.response;

public class Response {

    private int responseCode;
    private String responseMessage;

    public Response(int responseCode, String responseMessage) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }

    public Response() {
    }

    public int getResponseCode() {
        return responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }
}
