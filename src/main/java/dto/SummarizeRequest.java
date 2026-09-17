package com.example.aidoc.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SummarizeRequest {

    @NotBlank(message = "Text must not be blank")
    @Size(min = 50, message = "Text too short to summarize")
    private String text;
}