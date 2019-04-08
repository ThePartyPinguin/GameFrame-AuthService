package authservice.service.token.jwt;

import authservice.dao.IAuthDao;
import authservice.model.entity.login.UserLoginData;
import authservice.service.token.ITokenValidator;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.Optional;

public class JwtTokenValidator implements ITokenValidator {


    @Value("${security.jwt.token.secret-key:secret-key}")
    private String secretKey;

    @Autowired
    private IAuthDao authDao;


    @Override
    public boolean validateToken(long userId, String token) {


        Optional<UserLoginData> userLoginData = this.authDao.fingById(userId);

        if(!userLoginData.isPresent())
            return false;

        

        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }
}