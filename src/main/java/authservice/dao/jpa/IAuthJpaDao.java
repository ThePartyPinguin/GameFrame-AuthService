package authservice.dao.jpa;

import authservice.dao.IAuthDao;
import authservice.model.entity.login.UserLoginData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface IAuthJpaDao extends JpaRepository<UserLoginData, Long>, IAuthDao {

    boolean existsByUserNameOrEmail(String userName, String emai);

}
