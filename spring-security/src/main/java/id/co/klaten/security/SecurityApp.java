package id.co.klaten.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages={"id.co.klaten"})
@EnableTransactionManagement
@EntityScan("id.co.klaten")
@EnableJpaRepositories("id.co.klaten")
//@EnableJms
public class SecurityApp
{
    
    public static void main(String[] args)throws Exception
    {
        SpringApplication.run(SecurityApp.class, args);
    }
}
