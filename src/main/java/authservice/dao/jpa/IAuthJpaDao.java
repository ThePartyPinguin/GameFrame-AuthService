package authservice.dao.jpa;

import authservice.dao.IAuthDao;
import authservice.model.entity.login.UserLoginData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface IAuthJpaDao extends JpaRepository<UserLoginData, Long>, IAuthDao {

    boolean existsByUserNameOrEmail(String userName, String emai);
    Optional<UserLoginData> findByUserNameOrEmail(String userName, String email);

}
