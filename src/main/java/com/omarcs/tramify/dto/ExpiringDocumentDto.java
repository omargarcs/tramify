package com.omarcs.tramify.dto;

import com.omarcs.tramify.dto.enums.DocumentOrigin;

import java.time.LocalDate;

public class ExpiringDocumentDto {

    private final String personName;
    private final String documentType;
    private final LocalDate expiryDate;
    private final DocumentOrigin documentOrigin;

    public ExpiringDocumentDto (String personName, String documentType, LocalDate expiryDate, DocumentOrigin documentOrigin){
        this.personName = personName;
        this.documentType = documentType;
        this.expiryDate = expiryDate;
        this.documentOrigin = documentOrigin;
    }

    public String getPersonName() {
        return personName;
    }

    public String getDocumentType() {
        return documentType;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public DocumentOrigin getDocumentOrigin() {
        return documentOrigin;
    }
}