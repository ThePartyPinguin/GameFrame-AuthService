package authservice.dao;

import authservice.dao.jpa.IAuthJpaDao;
import authservice.model.entity.login.UserLoginData;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.Optional;

@ApplicationScope
public class AuthChache extends DaoCache<IAuthJpaDao, UserLoginData, Long> implements IAuthDao {

    @Override
    public void init(IAuthJpaDao jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public boolean existsByUserNameOrEmail(String userName, String email) {
        boolean exists = this.localCache.values().stream().anyMatch(u -> u.getEmail().equals(email) || u.getUserName().equals(userName));
        
        if(!exists)
            exists = this.jpaRepository.existsByUserNameOrEmail(userName, email);

        return exists;
    }

    @Override
    public Optional<UserLoginData> findByUserNameOrEmail(String userName, String email) {

        Optional<UserLoginData> returnValue = this.localCache.values().stream().filter(u -> u.getEmail().equals(email) || u.getUserName().equals(userName)).findFirst();

        if(!returnValue.isPresent()){
            returnValue = this.jpaRepository.findByUserNameOrEmail(userName, email);

            if(returnValue.isPresent()){
                UserLoginData data = returnValue.get();

                saveToCache(data.getUserId(), data);
            }
        }

        return returnValue;
    }

    @Override
    public Optional<UserLoginData> findById(long id) {
        Optional<UserLoginData> returnValue = this.localCache.values().stream().filter(u -> u.getUserId() == id).findFirst();

        if(!returnValue.isPresent()){
            returnValue = this.jpaRepository.findById(id);

            if(returnValue.isPresent()){
                UserLoginData data = returnValue.get();

                saveToCache(data.getUserId(), data);
            }
        }

        return returnValue;
    }
}
