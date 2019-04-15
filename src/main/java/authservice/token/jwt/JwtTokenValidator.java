package authservice.token.jwt;

import authservice.dao.IAuthDao;
import authservice.model.dto.response.token.TokenValidateResponse;
import authservice.model.entity.login.UserLoginData;
import authservice.token.ITokenValidator;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JwtTokenValidator implements ITokenValidator {

    @Value("${security.jwt.token.secret-key:secret-key}")
    private String secretKey;

    @Value("${security.jwt.token.expire-length:3600000}")
    private long validityInMilliseconds = 3600000; // 1h

    @Autowired
    private IAuthDao authDao;

    @Override
    public TokenValidateResponse validateToken(String token) {

        long userId = getUserIdFromToken(token);

        if(userId == -2)
            return new TokenValidateResponse(501, "Token expired", false, -1);

        if(userId == -1)
            return new TokenValidateResponse(501, "Token not valid", false, -1);

        UserLoginData loginData = authDao.findById(userId).orElse(null);

        if(loginData == null)
            return new TokenValidateResponse(501, "Token not valid", false, -1);



        return new TokenValidateResponse(500, "Token valid", true, loginData.getUserId());
    }

    public long getUserIdFromToken(String token){

        long id = -1;

        try{
            String tmp = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getId();
            id = Long.parseLong(tmp);
        }catch (SignatureException ex){
            return - 1;
        }catch (ExpiredJwtException ex){
            return -2;
        }

        return id;
    }

    private String getUserNameFromToken(String token){
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

}
