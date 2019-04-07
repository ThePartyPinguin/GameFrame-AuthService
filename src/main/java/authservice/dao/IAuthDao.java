package authservice.dao;

import authservice.model.entity.login.UserLoginData;

import java.util.Optional;

public interface IAuthDao {

    UserLoginData save(UserLoginData data);
    boolean existsByUserNameOrEmail(String userName, String emai);

}
