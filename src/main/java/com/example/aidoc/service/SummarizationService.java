package com.example.aidoc.service;

import dev.langchain4j.model.chat.ChatLanguageModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SummarizationService {

    private final ChatLanguageModel chatModel;

    private static final String SUMMARY_PROMPT = """
            You are an expert document analyst. Summarize the following document
            in a clear, structured manner.

            Requirements:
            - Provide a 2-3 sentence executive summary.
            - List 5 key bullet points.
            - Extract important entities (people, orgs, dates, numbers).

            Document:
            ---
            %s
            ---
            """;

    private static final String QA_PROMPT = """
            Answer the question strictly based on the context below.
            If the answer is not in the context, reply: "Not found in document."

            Context:
            ---
            %s
            ---

            Question: %s
            """;

    private static final String EXTRACT_PROMPT = """
            Extract key information from the document as JSON with fields:
            title, author, date, topics[], keyPoints[], conclusion.

            Document:
            ---
            %s
            ---
            """;

    public String summarize(String documentText) {
        return chatModel.generate(String.format(SUMMARY_PROMPT, documentText));
    }

    public String answerQuestion(String documentText, String question) {
        return chatModel.generate(String.format(QA_PROMPT, documentText, question));
    }

    public String extractKeyInfo(String documentText) {
        return chatModel.generate(String.format(EXTRACT_PROMPT, documentText));
    }
}