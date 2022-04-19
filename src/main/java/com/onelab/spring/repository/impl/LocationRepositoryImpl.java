package com.onelab.spring.repository.impl;

import com.onelab.spring.dto.Location;
import com.onelab.spring.repository.LocationRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class LocationRepositoryImpl implements LocationRepository {
    private List<Location> locationList;

    @Override
    public List<Location> getAllLocations() {
        return null;
    }
}
