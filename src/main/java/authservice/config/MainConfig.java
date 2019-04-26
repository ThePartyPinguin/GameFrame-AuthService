package authservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.security.SecureRandom;

@Configuration
public class MainConfig {


    private static SecureRandom passwordRandom;
    private static int passwordStrenght;

    @PostConstruct
    public void init(){

        passwordRandom = new SecureRandom("987987".getBytes());
        passwordStrenght = 5;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(passwordStrenght, passwordRandom);
    }


}
