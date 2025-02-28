package io.github.halitkalayci.exception.response;

import java.time.LocalDateTime;
import java.util.Map;

public class ValidationErrorResponse extends ErrorResponse {
    private final Map<String, String> errors;

    public ValidationErrorResponse(int status, String message, Map<String, String> errors, LocalDateTime timestamp) {
        super(status, message, timestamp);
        this.errors = errors;
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}