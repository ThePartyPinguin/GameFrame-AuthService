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


    private static SecureRandom passwordRandom;
    private static int passwordStrenght;

    @PostConstruct
    public void init(){
        passwordRandom = new SecureRandom(secureRandomSeed.getBytes());
        passwordStrenght = 5;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(passwordStrenght, passwordRandom);
    }

    @Bean
    @Primary
    public IAuthDao authDao(@Autowired IAuthJpaDao jpaDao){
        AuthChache cache = new AuthChache();
        cache.init(jpaDao);
        return cache;
    }

}
