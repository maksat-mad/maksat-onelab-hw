package com.onelab.task.config.security;

import com.onelab.task.auth.ApplicationUserService;
import com.onelab.task.jwt.JwtConfig;
import com.onelab.task.jwt.JwtTokenVerifier;
import com.onelab.task.jwt.JwtUsernameAndPasswordAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.crypto.SecretKey;

import static com.onelab.task.config.security.UserRole.CLIENT;
import static com.onelab.task.config.security.UserRole.MANAGER;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final ApplicationUserService applicationUserService;
    private final SecretKey secretKey;
    private final JwtConfig jwtConfig;

    @Autowired
    public SecurityConfig(PasswordEncoder passwordEncoder,
                                 ApplicationUserService applicationUserService,
                                 SecretKey secretKey,
                                 JwtConfig jwtConfig) {
        this.passwordEncoder = passwordEncoder;
        this.applicationUserService = applicationUserService;
        this.secretKey = secretKey;
        this.jwtConfig = jwtConfig;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /**
         * NOTE: if you want to just view authors, books and genres,
         * then, you do not have to login.
         *
         * NOTE: if you want to buy book,
         * you have to login as a CLIENT.
         *
         * NOTE: if you want to create, update, delete authors, books and genres
         * and if you want to see data that is for data analysis team,
         * then you have to login as a MANAGER.
         *
         * In order to login:
         * 1. (open POSTMAN)
         * 2. write POST method: http://localhost:8080/login
         * 3. write Body part this:
         * // This is for MANAGER
         * {
         *     "username": "maksat",
         *     "password": "123"
         * }
         * // This is for CLIENT
         *{
         *     "username": "roma",
         *     "password": "123"
         * }
         * 4. Then run it. After that take Token from Headers section
         * 5. Then put it to Bearer Token Authorization
         * 6. That it :)
         * */

        http
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager(), jwtConfig, secretKey))
                .addFilterAfter(new JwtTokenVerifier(secretKey, jwtConfig),JwtUsernameAndPasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/user/**").permitAll()
                .antMatchers("/client/**").hasRole(CLIENT.name())
                .antMatchers("/manager/**").hasRole(MANAGER.name())
                .anyRequest()
                .authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(applicationUserService);
        return provider;
    }

}
