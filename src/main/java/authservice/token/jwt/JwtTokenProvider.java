package authservice.token.jwt;

import authservice.model.entity.login.UserLoginData;
import authservice.token.ITokenProvider;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtTokenProvider implements ITokenProvider {

    @Value("${JWT_SECRET_KEY:jwtSecretKey}")
    private String secretKey;

    @Value("${security.jwt.token.expire-length:3600000}")
    private long validityInMilliseconds = 3600000; // 1h

    @Override
    public String createToken(UserLoginData userLoginData) {
        Date now = new Date();
        Claims claims = Jwts.claims().setSubject(userLoginData.getUserName() + userLoginData.getEmail()).setId("" + userLoginData.getUserId()).setIssuedAt(now);


        Date validity = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }
}
