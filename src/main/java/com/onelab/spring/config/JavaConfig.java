package com.onelab.spring.config;

import com.onelab.spring.repository.LocationRepository;
import com.onelab.spring.repository.PreferenceRepository;
import com.onelab.spring.repository.UserRepository;
import com.onelab.spring.repository.impl.LocationRepositoryImpl;
import com.onelab.spring.repository.impl.PreferenceRepositoryImpl;
import com.onelab.spring.repository.impl.UserRepositoryImpl;
import com.onelab.spring.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
    @Bean
    public UserService userService() {
        return new UserService();
    }

    @Bean
    public UserRepository userRepository() {
        return new UserRepositoryImpl();
    }

    @Bean
    public LocationRepository locationRepository() {
        return new LocationRepositoryImpl();
    }

    @Bean
    public PreferenceRepository preferenceRepository() {
        return new PreferenceRepositoryImpl();
    }
}
