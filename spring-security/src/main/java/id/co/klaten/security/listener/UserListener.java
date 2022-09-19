package id.co.klaten.security.listener;

import id.co.klaten.security.model.UserEntity;
import id.co.klaten.security.service.UserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@Component
public class UserListener
{
    @Autowired
    UserService userService;
    
    @SneakyThrows
    @JmsListener(destination = "user.save" )
    public void onMessage(Message message) {
        userService.save(message.getBody(UserEntity.class));
    }
    @SneakyThrows
    @JmsListener(destination = "test" )
    public void test(Message message) {
        System.out.println("message.getBody() = " + message.getBody(Object.class));
    }
}
