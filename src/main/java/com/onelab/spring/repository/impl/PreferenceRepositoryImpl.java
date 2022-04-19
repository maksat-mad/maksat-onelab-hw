package com.onelab.spring.repository.impl;

import com.onelab.spring.dto.Preference;
import com.onelab.spring.repository.PreferenceRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PreferenceRepositoryImpl implements PreferenceRepository {
    private List<Preference> preferenceList;

    @Override
    public List<Preference> getAllPreferences() {
        return null;
    }
}
