package com.example.aidoc.service;

import com.example.aidoc.util.TextPreprocessor;
import lombok.RequiredArgsConstructor;
import org.apache.tika.Tika;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class DocumentService {

    private final TextPreprocessor preprocessor;
    private final Tika tika = new Tika();

    public String extractText(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("Uploaded file is empty");
        }
        try {
            String raw = tika.parseToString(file.getInputStream());
            return preprocessor.clean(raw);
        } catch (Exception e) {
            throw new IOException("Failed to parse document: " + e.getMessage(), e);
        }
    }

    public String extractText(String rawText) {
        return preprocessor.clean(rawText);
    }
}