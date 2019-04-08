package authservice.resource;

import authservice.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class TokenController {

    @Autowired
    TokenService tokenService;

    @GetMapping("/token/{userId}/{token}")
    public boolean checkToken(@PathVariable long userId, @PathVariable String token){
        return this.tokenService.checkToken(userId, token);
    }

}
