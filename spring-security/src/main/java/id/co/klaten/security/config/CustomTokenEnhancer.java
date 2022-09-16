package id.co.klaten.security.config;

import id.co.klaten.security.model.UserEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

@Log4j2
public class CustomTokenEnhancer implements TokenEnhancer
{

    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        final Map<String, Object> additionalInfo = new HashMap();
        UserEntity user = (UserEntity) authentication.getPrincipal();

        additionalInfo.put("idUser", user.getUserId());
        additionalInfo.put("userName", user.getUsername());
        
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        return accessToken;
    }
    
    
}
