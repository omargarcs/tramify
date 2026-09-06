package com.omarcs.tramify.dto;

import com.omarcs.tramify.dto.enums.DocumentOrigin;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class ExpiringDocumentDto {

    private final String personName;
    private final String documentType;
    private final LocalDate expiryDate;
    private final DocumentOrigin documentOrigin;
}