package com.vuongnm.fintrack.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/export")
@RequiredArgsConstructor
public class ExportService {
//    private final ExportService exportService;
//
//    //Export transaction to PDF
//    @GetMapping("/pdf")
//    public ResponseEntity<byte[]> exportToPDF() {
//        byte[] pdfData = exportService.exportToPDF();
//    }
}
