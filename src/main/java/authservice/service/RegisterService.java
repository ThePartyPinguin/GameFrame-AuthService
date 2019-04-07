package authservice.service;

import authservice.dao.IAuthDao;
import authservice.model.dto.request.register.RegisterRequestDto;
import authservice.model.dto.response.Response;
import authservice.model.dto.response.register.RegisterSuccesResponse;
import authservice.model.entity.login.UserLoginData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisterService {

    @Autowired
    private IAuthDao authDao;

    public Response registerNewUser(RegisterRequestDto dto)
    {
        boolean exists = this.authDao.existsByUserNameOrEmail(dto.getUserName(), dto.getEmail());
        if(exists)
            return new Response(501, "User with this username or email already exists");
        
        UserLoginData data = new UserLoginData(dto.getEmail(), dto.getUserName(), dto.getPassword());

        UserLoginData response = this.authDao.save(data);

        if(response == null)
            return new Response(501, "User could not be registered");

        return new RegisterSuccesResponse( 500, "user registered", "token");
    }

}
