package authservice.dao;

import authservice.model.entity.login.UserLoginData;

import java.util.Optional;

public interface IAuthDao {

    UserLoginData save(UserLoginData data);
    boolean existsByUserNameOrEmail(String userName, String email);

    Optional<UserLoginData> findByUserNameOrEmail(String userName, String email);
    Optional<UserLoginData> findById(long id);

}
