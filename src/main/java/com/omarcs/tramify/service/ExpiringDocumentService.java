package com.omarcs.tramify.service;

import com.omarcs.tramify.repository.PersonalDocumentRepository;
import com.omarcs.tramify.repository.VehicleDocumentRepository;
import org.springframework.stereotype.Service;

@Service
public class ExpiringDocumentService {

    private final PersonalDocumentRepository personalDocumentRepository;
    private final VehicleDocumentRepository vehicleDocumentRepository;

    //EXPLICIT CONSTRUCTOR - AUTO USE: @RequiredArgsConstructor
    public ExpiringDocumentService (PersonalDocumentRepository personalDocumentRepository,
                                    VehicleDocumentRepository vehicleDocumentRepository){
        this.personalDocumentRepository = personalDocumentRepository;
        this.vehicleDocumentRepository = vehicleDocumentRepository;
    }
}
