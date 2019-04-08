package authservice.resource;

import authservice.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/internal")
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @GetMapping("/token/{token}")
    public boolean checkToken(@PathVariable String token){
        return this.tokenService.checkToken(token);
    }

}
