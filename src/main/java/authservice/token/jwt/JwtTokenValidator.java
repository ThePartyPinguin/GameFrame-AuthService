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

import java.util.Date;

@Service
public class JwtTokenValidator implements ITokenValidator {

    @Value("${JWT_SECRET_KEY:jwtSecretKey}")
    private String secretKey;

    @Value("${security.jwt.token.expire-length:3600000}")
    private long validityInMilliseconds = 3600000; // 1h

    @Autowired
    private IAuthDao authDao;

    @Autowired
    private JwtTokenProvider tokenProvider;
    @Override
    public TokenValidateResponse validateToken(String token) {

        long userId = getUserIdFromToken(token);

        if(userId == -2)
            return new TokenValidateResponse(501, "Token expired", false, -1, "");

        if(userId == -1)
            return new TokenValidateResponse(501, "Token not valid", false, -1, "");

        if(!compareDates(token))
            return new TokenValidateResponse(501, "Token expired, please login again", false, -1, "");

        UserLoginData loginData = authDao.findById(userId).orElse(null);

        if(loginData == null)
            return new TokenValidateResponse(501, "Token not valid", false, -1, "");

        boolean tokenMatch = compareToken(token, loginData.getToken());

        if(!tokenMatch)
            return new TokenValidateResponse(501, "Token expired", false, -1, "");


        loginData.setLastLogin(new Date());

        String newToken = this.tokenProvider.createToken(loginData);

        loginData.setToken(newToken);

        this.authDao.save(loginData);

        return new TokenValidateResponse(500, "Token valid", true, loginData.getUserId(), newToken);
    }

    public long getUserIdFromToken(String token){

        long id = -1;

        try{
            String tmp = Jwts.parser().setSigningKey(this.secretKey).parseClaimsJws(token).getBody().getId();
            id = Long.parseLong(tmp);
        }catch (SignatureException ex){
            return - 1;
        }catch (ExpiredJwtException ex){
            return -2;
        }

        return id;
    }

    private boolean compareDates(String token){

        Date tokenDate = Jwts.parser().setSigningKey(this.secretKey).parseClaimsJws(token).getBody().getIssuedAt();

        Date now = new Date();

        long diffMillis = Math.abs(tokenDate.getTime() - now.getTime());

        return diffMillis <= this.validityInMilliseconds;
    }

    private boolean compareToken(String givenToken, String existingToken){
        return existingToken.equals(givenToken);
    }

}
