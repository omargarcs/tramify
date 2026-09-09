package com.omarcs.tramify.controller;

import com.omarcs.tramify.dto.ExpiringDocumentDto;
import com.omarcs.tramify.service.ExpiringDocumentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/api/expiring-documents")
public class ExpiringDocumentController {

    private final ExpiringDocumentService expiringDocumentService;

    public ExpiringDocumentController(ExpiringDocumentService expiringDocumentService){
        this.expiringDocumentService = expiringDocumentService;
    }

    @GetMapping
    public List<ExpiringDocumentDto> getExpiringDocuments(@RequestParam LocalDate start, @RequestParam LocalDate end){
        return expiringDocumentService.getExpiringDocuments(start, end);
    }
}
