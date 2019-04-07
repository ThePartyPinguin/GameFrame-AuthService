package authservice.resource;

import authservice.model.dto.request.register.RegisterRequestDto;
import authservice.model.dto.response.Response;
import authservice.model.dto.response.register.RegisterSuccesResponse;
import authservice.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping("/register")
    public Response registerNewUser(@RequestBody RegisterRequestDto dto){
        System.out.println("hit");
        return this.registerService.registerNewUser(dto);
    }
}
