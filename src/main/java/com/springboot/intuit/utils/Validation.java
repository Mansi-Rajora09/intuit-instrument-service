package com.springboot.intuit.utils;

import java.util.Date;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.springboot.intuit.payload.InstrumentDto;

import jakarta.validation.ValidationException;

@Service
public class Validation {
    Pattern pattern = Pattern.compile("\\d+");

    public void validateName(String categoryName) {
        // Define a regex pattern to match only integers
        if (categoryName == null || categoryName.trim().isEmpty()) {
            throw new ValidationException(" name cannot be empty");
        }

        // Check if the category name contains only integers
        if (pattern.matcher(categoryName).matches()) {
            throw new ValidationException(" name cannot contain only integers");
        }
    }

    public void validateUserId(String userId) {
        // Define a regex pattern to match only integers
        if (userId == null || userId.trim().isEmpty()) {
            throw new ValidationException(" userId cannot be empty");
        }
    }

    public void validateInstrumentDto(InstrumentDto instrumentDto) {
        validateUserId(instrumentDto.getUserId());
        validateName(instrumentDto.getName());
        validateDescription(instrumentDto.getDescription());
        validateCategoryId(instrumentDto.getCategoryId());
        // Add validation for other fields as needed
    }

    public void validateDescription(String description) {
        // Add validation rules for the description field if needed
        validateName(description);

    }

    public void validateCategoryId(String categoryId) {
        // Add validation rules for the categoryId field if needed
        if (!pattern.matcher(categoryId).matches()) {
            throw new ValidationException("categoryId cannot contain string");
        }
    }

}
