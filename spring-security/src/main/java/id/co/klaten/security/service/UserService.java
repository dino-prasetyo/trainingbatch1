package id.co.klaten.security.service;

import id.co.klaten.security.dao.UserRepo;
import id.co.klaten.security.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService
{
    @Autowired
    UserRepo userRepo;
    
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        UserEntity user = userRepo.getByUserName(username);
        
        return user;
    }
    
    public void save(UserEntity userEntity)
    {
        userRepo.save(userEntity);
    }
    
}
