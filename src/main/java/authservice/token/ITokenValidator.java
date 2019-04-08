package authservice.token;


public interface ITokenValidator {

    boolean validateToken(String token);
}
