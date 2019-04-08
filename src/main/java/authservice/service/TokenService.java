package authservice.service;

import org.springframework.stereotype.Service;

@Service
public class TokenService {




    public boolean checkToken(long userId, String token){
        return true;
    }

    public String generateToken(long userId){
        return "";
    }

}
