package authservice.dao;

import authservice.model.entity.login.UserLoginData;
import jdk.nashorn.internal.runtime.options.Option;

import java.util.Optional;

public interface IAuthDao {

    UserLoginData save(UserLoginData data);
    boolean existsByUserNameOrEmail(String userName, String emai);

    Optional<UserLoginData> fingById(long id);

}
