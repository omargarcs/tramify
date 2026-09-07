package com.omarcs.tramify.service;

import com.omarcs.tramify.dto.ExpiringDocumentDto;
import com.omarcs.tramify.dto.enums.DocumentOrigin;
import com.omarcs.tramify.entity.PersonalDocument;
import com.omarcs.tramify.entity.VehicleDocument;
import com.omarcs.tramify.repository.PersonalDocumentRepository;
import com.omarcs.tramify.repository.VehicleDocumentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

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

    public List<ExpiringDocumentDto> getExpiringDocuments (LocalDate start, LocalDate end){

        List<PersonalDocument> personalDocuments = personalDocumentRepository.findExpiringWithPerson(start, end);
        List<VehicleDocument> vehicleDocuments = vehicleDocumentRepository.findExpiringWithVehicleAndPerson(start, end);

        //USING STREAMS
        Stream<ExpiringDocumentDto> expiringPersonalDocuments = personalDocuments.stream()
                .map(pd -> new ExpiringDocumentDto(pd.getPerson().getName(),
                        pd.getPersonalDocumentType().name(), pd.getExpiryDate(), DocumentOrigin.PERSONAL));

        Stream<ExpiringDocumentDto> expiringVehicleDocuments = vehicleDocuments.stream()
                .map(vd -> new ExpiringDocumentDto(vd.getVehicle().getPerson().getName(),
                        vd.getVehicleDocumentType().name(), vd.getExpiryDate(), DocumentOrigin.VEHICULAR));

        return Stream.concat(expiringPersonalDocuments, expiringVehicleDocuments).toList();
    }
}
