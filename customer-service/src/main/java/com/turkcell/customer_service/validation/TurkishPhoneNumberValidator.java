package com.turkcell.customer_service.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class TurkishPhoneNumberValidator implements ConstraintValidator<TurkishPhoneNumber, String> {

    // Regex for Turkish phone numbers (05xx xxx xx xx format)
    private static final Pattern TURKISH_PHONE_PATTERN = Pattern.compile("^(05)([0-9]{9})$");

    @Override
    public void initialize(TurkishPhoneNumber constraintAnnotation) {
        // No initialization needed
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // If the value is null or empty, it's valid (phone is optional)
        if (value == null || value.trim().isEmpty()) {
            return true;
        }

        // Remove any spaces, dashes, parentheses that might be in the number
        String cleaned = value.replaceAll("[\\s\\-()]", "");

        // Check if it matches the Turkish phone number pattern
        return TURKISH_PHONE_PATTERN.matcher(cleaned).matches();
    }
}