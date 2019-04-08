package authservice.token;

import authservice.model.entity.login.UserLoginData;

public interface ITokenProvider {

    String createToken(UserLoginData userLoginData);

}
