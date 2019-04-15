package authservice.token;


import authservice.model.dto.response.token.TokenValidateResponse;

public interface ITokenValidator {

    TokenValidateResponse validateToken(String token);
}
