package authservice.config;

import authservice.dao.AuthChache;
import authservice.dao.IAuthDao;
import authservice.dao.jpa.IAuthJpaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import javax.annotation.Priority;
import java.security.SecureRandom;

@Configuration
public class MainConfig {

    @Value("${jwt.random.seed}")
    private String secureRandomSeed;

    @Value("${jwt.random.strength}")
    private int strength;


    private static SecureRandom passwordRandom;

    @Bean
    public PasswordEncoder passwordEncoder() {
        if(passwordRandom == null)
            passwordRandom = new SecureRandom(secureRandomSeed.getBytes());

        return new BCryptPasswordEncoder(this.strength, passwordRandom);
    }

    @Bean
    @Primary
    public IAuthDao authDao(@Autowired IAuthJpaDao jpaDao){
        AuthChache cache = new AuthChache();
        cache.init(jpaDao);
        return cache;
    }

}
