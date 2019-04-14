package authservice.service;

import authservice.clients.IUserService;
import authservice.dao.IAuthDao;
import authservice.model.dto.request.login.RegisterNewUserRequest;
import authservice.model.dto.request.register.RegisterRequestDto;
import authservice.model.dto.response.Response;
import authservice.model.dto.response.register.RegisterSuccesResponse;
import authservice.model.entity.login.UserLoginData;
import authservice.token.ITokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class RegisterService {

    @Autowired
    private IAuthDao authDao;

    @Autowired
    private IUserService userService;

    @Autowired
    private ITokenProvider tokenProvider;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Response registerNewUser(RegisterRequestDto dto)
    {
        boolean exists = this.authDao.existsByUserNameOrEmail(dto.getUserName(), dto.getEmail());
        if(exists)
            return new Response(501, "User with this username or email already exists");


        String encodedPassword = this.passwordEncoder.encode(dto.getPassword());


        UserLoginData data = new UserLoginData(dto.getEmail(), dto.getUserName(), encodedPassword);

        data.setLastLogin(new Date());

        UserLoginData response = this.authDao.save(data);

        String token = this.tokenProvider.createToken(response);

        response.setToken(token);

        this.authDao.save(response);

        RegisterNewUserRequest userRequest = new RegisterNewUserRequest(response.getUserId(), response.getUserName(), response.getEmail());
        this.userService.registerNewUser(userRequest);

        return new RegisterSuccesResponse( 500, "user registered", response.getUserId(),response.getToken());
    }

}
