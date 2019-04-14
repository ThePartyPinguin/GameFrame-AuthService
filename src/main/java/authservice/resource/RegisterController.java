package authservice.resource;

import authservice.model.dto.request.register.RegisterRequestDto;
import authservice.model.dto.response.Response;
import authservice.model.dto.response.register.RegisterSuccesResponse;
import authservice.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping(value = "/signup")
    public Response registerNewUser(@RequestBody RegisterRequestDto dto){
        return this.registerService.registerNewUser(dto);
    }
}
