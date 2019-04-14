package authservice.service;

import authservice.dao.IAuthDao;
import authservice.model.dto.request.login.LoginRequestDto;
import authservice.model.dto.response.Response;
import authservice.model.dto.response.login.LoginSuccesResponse;
import authservice.model.entity.login.UserLoginData;
import authservice.token.ITokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private IAuthDao authDao;

    @Autowired
    private ITokenProvider tokenProvider;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Response login(LoginRequestDto dto){

        Optional<UserLoginData> data = this.authDao.findByUserNameOrEmail(dto.getLoginName(), dto.getLoginName());

        if(!data.isPresent())
            return new Response(501, "This user does not exist");

        boolean passwordCorrect = this.passwordEncoder.matches(dto.getPassword(), data.get().getPassword());

        if(!passwordCorrect)
            return new Response(501, "Credentials not correct");

        UserLoginData loginData = data.get();

        String token = this.tokenProvider.createToken(data.get());

        loginData.setToken(token);

        this.authDao.save(loginData);

        return new LoginSuccesResponse(500, "LOGIN SUCCESS", loginData.getUserId(), token);
    }
}
