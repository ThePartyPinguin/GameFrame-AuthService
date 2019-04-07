package authservice.service;

import authservice.model.dto.request.login.LoginRequestDto;
import authservice.model.dto.response.Response;
import org.springframework.stereotype.Service;

@Service
public class LoginService {



    public Response login(LoginRequestDto dto){

        return new Response(500, "sdfsdf");



    }


}
