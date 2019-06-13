package authservice.service;

import authservice.model.dto.response.token.TokenValidateResponse;
import authservice.token.ITokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    @Autowired
    private ITokenValidator tokenValidator;


    public TokenValidateResponse checkToken(String token){

        return this.tokenValidator.validateToken(token);
    }


}
