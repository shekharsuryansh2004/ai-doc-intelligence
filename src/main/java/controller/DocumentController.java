package com.example.aidoc.controller;

import com.example.aidoc.dto.ApiResponse;
import com.example.aidoc.dto.QaRequest;
import com.example.aidoc.dto.SummarizeRequest;
import com.example.aidoc.service.DocumentService;
import com.example.aidoc.service.SummarizationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/documents")
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService documentService;
    private final SummarizationService summarizationService;

    @PostMapping(value = "/summarize", consumes = "multipart/form-data")
    public ResponseEntity<ApiResponse> summarizeFile(
            @RequestParam("file") MultipartFile file) throws Exception {
        String text = documentService.extractText(file);
        String summary = summarizationService.summarize(text);
        return ResponseEntity.ok(new ApiResponse(true, summary));
    }

    @PostMapping("/summarize-text")
    public ResponseEntity<ApiResponse> summarizeText(
            @Valid @RequestBody SummarizeRequest req) {
        String text = documentService.extractText(req.getText());
        String summary = summarizationService.summarize(text);
        return ResponseEntity.ok(new ApiResponse(true, summary));
    }

    @PostMapping("/ask")
    public ResponseEntity<ApiResponse> ask(@Valid @RequestBody QaRequest req) {
        String text = documentService.extractText(req.getDocumentText());
        String answer = summarizationService.answerQuestion(text, req.getQuestion());
        return ResponseEntity.ok(new ApiResponse(true, answer));
    }

    @PostMapping("/extract")
    public ResponseEntity<ApiResponse> extract(@Valid @RequestBody SummarizeRequest req) {
        String text = documentService.extractText(req.getText());
        String json = summarizationService.extractKeyInfo(text);
        return ResponseEntity.ok(new ApiResponse(true, json));
    }
}