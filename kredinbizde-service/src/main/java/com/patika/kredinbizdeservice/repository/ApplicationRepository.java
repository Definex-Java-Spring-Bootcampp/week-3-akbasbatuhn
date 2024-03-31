package com.patika.kredinbizdeservice.repository;

import com.patika.kredinbizdeservice.model.Application;

import java.util.ArrayList;
import java.util.List;

public class ApplicationRepository {

    private List<Application> applicationList = new ArrayList<>();

    public Application save(Application application) {
        applicationList.add(application);
        return application;
    }

    public List<Application> getAllApplicationsByEmail(String email) {
        return applicationList.stream()
                .filter(application -> application.getUser().getEmail().equals(email))
                .toList();
    }
}
