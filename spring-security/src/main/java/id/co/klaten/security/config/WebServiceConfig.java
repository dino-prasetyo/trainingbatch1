/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package id.co.klaten.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebServiceConfig extends WebSecurityConfigurerAdapter
{
    
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception
    {
        return super.authenticationManagerBean();
    }
    
    @Bean
    public PasswordEncoder passwordEncoderBean()
    {
        return NoOpPasswordEncoder.getInstance();
    }
    
    
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.authorizeRequests()
                .antMatchers("/noauth").permitAll()
                .antMatchers("/oauth2/keys").permitAll()
                .antMatchers(HttpMethod.POST, "/oauth/token").permitAll()
                .antMatchers(HttpMethod.DELETE, "/oauth/token").permitAll()
                .antMatchers("/oauth/token/revokeById/**").permitAll()
                .antMatchers(HttpMethod.POST, "/oauth/check_token").permitAll()
                .antMatchers(HttpMethod.GET, "/oauth/token_key").permitAll()
                .antMatchers("/tokens/**").permitAll()
                
                .anyRequest().authenticated()
                //.and().formLogin().loginPage("/noauth")
                .and().csrf().disable()
        
        //.oauth2ResourceServer(oauth2 -> oauth2.jwt())
        ;
    }
}
