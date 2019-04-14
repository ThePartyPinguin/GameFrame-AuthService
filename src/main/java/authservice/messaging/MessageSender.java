package authservice.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public class MessageSender {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void send(String destination, Object object){
        this.jmsTemplate.convertAndSend(destination, object);
    }


}
