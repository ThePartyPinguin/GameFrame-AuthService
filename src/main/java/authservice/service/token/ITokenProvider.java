package authservice.service.token;


import authservice.model.entity.login.Role;

import java.util.List;

public interface ITokenProvider {

    String createToken(String userName, List<Role> roles);
//
//    String getUserName(String token);
//
//    Authentication getAuthentication(String token);
//
//    String resolveToken(String header);
}
