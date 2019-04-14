//package authservice.clients;
//
//import authservice.messaging.MessageSender;
//import authservice.model.dto.request.login.RegisterNewUserRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//
//@Service
//public class UserServiceJmsImpl implements IUserService {
//
//    @Autowired
//    private MessageSender messageSender;
//
//    @Value("${REGISER_NEW_USER_QUEUE:queue.user.register.new}")
//    private String destination;
//
//    @Override
//    public void registerNewUser(RegisterNewUserRequest request) {
//        this.messageSender.send(destination, request);
//    }
//}
