package authservice.resource;

import authservice.model.dto.response.token.TokenValidateResponse;
import authservice.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/internal")
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @GetMapping("/token/{token}")
    @ResponseBody
    public TokenValidateResponse checkToken(@PathVariable String token){


        return this.tokenService.checkToken(token);
    }

}
