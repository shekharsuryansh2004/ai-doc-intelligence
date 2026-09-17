package com.example.aidoc.util;

import org.springframework.stereotype.Component;

@Component
public class TextPreprocessor {

    private static final int MAX_CHARS = 12000;

    public String clean(String text) {
        if (text == null) return "";

        String cleaned = text
                .replaceAll("\\r\\n", "\n")
                .replaceAll("[ \\t]+", " ")
                .replaceAll("\\n{3,}", "\n\n")
                .trim();

        if (cleaned.length() > MAX_CHARS) {
            cleaned = cleaned.substring(0, MAX_CHARS);
        }
        return cleaned;
    }

    public boolean isMeaningful(String text) {
        return text != null && text.trim().split("\\s+").length >= 20;
    }
}