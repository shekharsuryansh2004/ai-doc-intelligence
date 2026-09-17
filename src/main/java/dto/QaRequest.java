package com.example.aidoc.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class QaRequest {

    @NotBlank
    private String documentText;

    @NotBlank
    private String question;
}