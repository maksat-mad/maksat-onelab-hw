package com.onelab.task.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.onelab.task.config.security.UserRole.CLIENT;
import static com.onelab.task.config.security.UserRole.MANAGER;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/user/**").permitAll()
                .antMatchers("/client/**").hasRole(CLIENT.name())
                .antMatchers("/manager/**").hasRole(MANAGER.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails romaUser = User.builder()
                .username("roma")
                .password(passwordEncoder.encode("123"))
                .roles(CLIENT.name())
                //.authorities(CLIENT.getGrantedAuthorities())
                .build();

        UserDetails maksatUser = User.builder()
                .username("maksat")
                .password(passwordEncoder.encode("123"))
                .roles(MANAGER.name())
                //.authorities(MANAGER.getGrantedAuthorities())
                .build();

        return new InMemoryUserDetailsManager(
                romaUser,
                maksatUser
        );
    }
}
