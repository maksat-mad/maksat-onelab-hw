package com.onelab.spring.service;

import com.onelab.spring.dto.Location;
import com.onelab.spring.dto.Preference;
import com.onelab.spring.dto.User;
import com.onelab.spring.repository.LocationRepository;
import com.onelab.spring.repository.PreferenceRepository;
import com.onelab.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private PreferenceRepository preferenceRepository;

}
