package com.patika.garantiservice.service;

import com.patika.garantiservice.converter.ApplicationConverter;
import com.patika.garantiservice.dto.ApplicationRequest;
import com.patika.garantiservice.dto.ApplicationResponse;
import com.patika.garantiservice.entity.Application;
import com.patika.garantiservice.repository.ApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    private ApplicationRepository applicationRepository = new ApplicationRepository();

    private final ApplicationConverter applicationConverter;

    public ApplicationService(ApplicationConverter applicationConverter) {
        this.applicationConverter = applicationConverter;
    }

    public ApplicationResponse createApplication(ApplicationRequest request) {

        Application application = applicationConverter.toApplication(request);

        return applicationConverter.toResponse(applicationRepository.save(application));
    }


    public List<ApplicationResponse> getAll() {
        List<Application> applications = applicationRepository.getAll();

        return applicationConverter.toResponseList(applications);
    }
}
