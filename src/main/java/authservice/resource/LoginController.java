package authservice.resource;

import authservice.model.dto.request.login.LoginRequestDto;
import authservice.model.dto.response.Response;
import authservice.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping(value = "/signin")
    public Response login(@RequestBody LoginRequestDto dto){
        return this.loginService.login(dto);
    }
}
