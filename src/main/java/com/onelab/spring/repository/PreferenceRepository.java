package com.onelab.spring.repository;

import com.onelab.spring.dto.Preference;

import java.util.List;
import java.util.Map;

public interface PreferenceRepository {
    public List<Preference> getAllPreferences();
}
