package authservice.service.token;

public interface ITokenValidator {

    boolean validateToken(long userId, String token);

}
