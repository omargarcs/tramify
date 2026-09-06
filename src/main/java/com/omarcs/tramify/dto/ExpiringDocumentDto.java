package com.omarcs.tramify.dto;

import com.omarcs.tramify.dto.enums.DocumentOrigin;

import java.time.LocalDate;

public record ExpiringDocumentDto (String personName, String documentType, LocalDate expiryDate,
    DocumentOrigin documentOrigin){}