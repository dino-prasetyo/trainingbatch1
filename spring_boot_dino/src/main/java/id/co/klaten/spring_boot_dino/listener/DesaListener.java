package id.co.klaten.spring_boot_dino.listener;

import com.google.gson.Gson;
import id.co.klaten.spring_boot_dino.model.DesaEntity;
import id.co.klaten.spring_boot_dino.service.DesaService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import java.util.Map;

@Component
public class DesaListener
{
    @Autowired
    DesaService desaService;
    
    @JmsListener(destination = "percobaa")
    public void onMessage(Message message) throws JMSException
    {
        if(message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage)message;
            System.out.println("message.getBody() = " + textMessage);;
        }
    }
    
    @SneakyThrows
    @JmsListener(destination = "desa.save")
    public void save(Message message)
    {
        String messageData = null;
        System.out.println("Received message " + message);
        if(message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage)message;
            messageData = textMessage.getText();
            DesaEntity desa = new Gson().fromJson(messageData, DesaEntity.class);
            desaService.save(desa);
        }
    }
}
